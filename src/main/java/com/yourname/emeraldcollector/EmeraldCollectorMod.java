package com.yourname.emeraldcollector;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main mod class for Emerald Collector
 * This mod automatically moves the player to collect emerald items
 */
public class EmeraldCollectorMod implements ModInitializer {
    // Mod ID - used to identify your mod
    public static final String MOD_ID = "emeraldcollector";
    
    // Logger for debugging messages
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    // Key binding for toggling the feature (Numpad 0)
    private static KeyBinding toggleKey;
    
    // Flag to track if the feature is enabled
    public static boolean isEnabled = false;
    
    @Override
    public void onInitialize() {
        LOGGER.info("Emerald Collector Mod is initializing!");
        
        // Register the toggle key (Numpad 0)
        toggleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.emeraldcollector.toggle", // Translation key
            InputUtil.Type.KEYSYM, // Input type
            GLFW.GLFW_KEY_KP_0, // Numpad 0 key
            "category.emeraldcollector" // Category in controls menu
        ));
        
        // Register tick event to check for key presses
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Check if toggle key was pressed
            while (toggleKey.wasPressed()) {
                isEnabled = !isEnabled;
                if (client.player != null) {
                    String status = isEnabled ? "enabled" : "disabled";
                    client.player.sendMessage(
                        net.minecraft.text.Text.literal("§aEmerald Collector: §f" + status),
                        false
                    );
                }
                LOGGER.info("Emerald Collector toggled: {}", isEnabled);
            }
        });
        
        LOGGER.info("Emerald Collector Mod initialized successfully!");
    }
    
    public static boolean isEnabled() {
        return isEnabled;
    }
}
