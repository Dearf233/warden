package com.yourname.emeraldcollector;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

import java.util.List;

/**
 * Client-side mod initialization
 * Handles the movement logic for collecting emeralds
 */
public class EmeraldCollectorClient implements ClientModInitializer {
    // The idle position where the player returns when no emeralds are nearby
    private Vec3d idlePosition = null;
    
    // Detection radius for finding emerald items (in blocks)
    private static final double DETECTION_RADIUS = 16.0;
    
    // Movement speed multiplier
    private static final double MOVEMENT_SPEED = 0.2;
    
    // Distance threshold to consider "reached" the target
    private static final double REACH_THRESHOLD = 1.5;
    
    @Override
    public void onInitializeClient() {
        EmeraldCollectorMod.LOGGER.info("Initializing Emerald Collector Client");
        
        // Register tick event to handle movement logic
        ClientTickEvents.END_CLIENT_TICK.register(this::onClientTick);
    }
    
    /**
     * Called every client tick to update player movement
     */
    private void onClientTick(MinecraftClient client) {
        // Only run if the feature is enabled and player exists
        if (!EmeraldCollectorMod.isEnabled() || client.player == null || client.world == null) {
            return;
        }
        
        ClientPlayerEntity player = client.player;
        
        // Set idle position on first enable (current position)
        if (idlePosition == null) {
            idlePosition = player.getPos();
            EmeraldCollectorMod.LOGGER.info("Idle position set to: {}", idlePosition);
        }
        
        // Find nearby emerald items
        ItemEntity nearestEmerald = findNearestEmerald(player);
        
        if (nearestEmerald != null) {
            // Move towards the emerald
            moveTowards(player, nearestEmerald.getPos());
        } else {
            // No emeralds nearby, return to idle position
            if (!isAtPosition(player.getPos(), idlePosition, REACH_THRESHOLD)) {
                moveTowards(player, idlePosition);
            }
        }
    }
    
    /**
     * Finds the nearest emerald item entity within detection radius
     */
    private ItemEntity findNearestEmerald(ClientPlayerEntity player) {
        Vec3d playerPos = player.getPos();
        
        // Create a bounding box around the player for detection
        Box searchBox = new Box(
            playerPos.x - DETECTION_RADIUS,
            playerPos.y - DETECTION_RADIUS,
            playerPos.y + DETECTION_RADIUS,
            playerPos.x + DETECTION_RADIUS,
            playerPos.y + DETECTION_RADIUS,
            playerPos.z + DETECTION_RADIUS
        );
        
        // Get all item entities in range
        List<ItemEntity> items = player.getWorld().getEntitiesByClass(
            ItemEntity.class,
            searchBox,
            entity -> entity.getStack().getItem() == Items.EMERALD
        );
        
        // Find the closest one
        ItemEntity nearest = null;
        double minDistance = Double.MAX_VALUE;
        
        for (ItemEntity item : items) {
            double distance = playerPos.distanceTo(item.getPos());
            if (distance < minDistance) {
                minDistance = distance;
                nearest = item;
            }
        }
        
        return nearest;
    }
    
    /**
     * Moves the player towards a target position using vector-based movement
     */
    private void moveTowards(ClientPlayerEntity player, Vec3d targetPos) {
        Vec3d currentPos = player.getPos();
        
        // Calculate direction vector
        Vec3d direction = targetPos.subtract(currentPos).normalize();
        
        // Calculate velocity
        Vec3d velocity = direction.multiply(MOVEMENT_SPEED);
        
        // Set player velocity
        player.setVelocity(velocity.x, velocity.y, velocity.z);
        
        // Update player movement input to match velocity direction
        if (Math.abs(velocity.x) > 0.01 || Math.abs(velocity.z) > 0.01) {
            // Calculate yaw (horizontal rotation) from velocity
            float yaw = (float) Math.toDegrees(Math.atan2(-velocity.x, velocity.z));
            player.setYaw(yaw);
            
            // Calculate pitch (vertical rotation) from velocity
            double horizontalDistance = Math.sqrt(velocity.x * velocity.x + velocity.z * velocity.z);
            float pitch = (float) Math.toDegrees(Math.atan2(-velocity.y, horizontalDistance));
            player.setPitch(pitch);
        }
    }
    
    /**
     * Checks if the player is at a specific position (within threshold)
     */
    private boolean isAtPosition(Vec3d current, Vec3d target, double threshold) {
        return current.distanceTo(target) < threshold;
    }
    
    /**
     * Resets the idle position (called when feature is disabled/re-enabled)
     */
    public void resetIdlePosition() {
        idlePosition = null;
    }
}
