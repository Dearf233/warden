# 📸 Visual Guide - Emerald Collector Mod

## What You'll See

### Step 1: Toggle the Mod
When you press **Numpad 0**, you'll see one of these messages in chat:

```
✅ Enabled:
"Emerald Collector: enabled" (in green)

❌ Disabled:
"Emerald Collector: disabled" (in green)
```

### Step 2: Dropping an Emerald
When you drop an emerald (press Q while holding it), the item will appear on the ground as a spinning emerald item entity.

### Step 3: Automatic Movement
Your character will:
1. **Rotate** to face the emerald
2. **Move forward** smoothly towards it
3. **Pick it up** automatically when close enough
4. **Return** to the idle position

### Step 4: Multiple Emeralds
If there are multiple emeralds:
- The mod targets the **nearest** one first
- After picking it up, it moves to the next nearest
- This continues until all emeralds are collected

### Step 5: Idle Behavior
When no emeralds are detected:
- Character returns to the position where you first enabled the mod
- Once at idle position, character stops moving
- Waits for new emeralds to spawn

## Testing the Mod

### Basic Test
1. Enable mod (Numpad 0)
2. Use command: `/give @p emerald 1`
3. Drop the emerald (press Q)
4. Watch your character collect it!

### Advanced Test
1. Enable mod
2. Spawn multiple emeralds around you
3. Drop them at different distances
4. Observe the collection priority (nearest first)

### Return Test
1. Enable mod at position A
2. Manually move to position B
3. Drop an emerald at position C
4. Character should: Move to C → Collect → Return to A

## Visual Indicators

### Character Behavior
- **Head rotation**: Points towards target emerald
- **Body rotation**: Faces movement direction  
- **Movement**: Smooth gliding motion (not walking animation)
- **Idle**: Stands still at idle position

### What to Expect
```
You (Idle Position)
     ↓
     Move to emerald
     ↓
🟢 Emerald Item (picked up)
     ↓
     Return to idle
     ↓
You (Idle Position)
```

## Common Visual Bugs (and fixes)

### Character spinning rapidly
- **Cause**: Emerald is directly above/below
- **Fix**: This is normal, character is trying to face it

### Character moving jittery
- **Cause**: Multiple emeralds at similar distances
- **Expected**: Will smooth out as one becomes clearly nearest

### Character doesn't return to idle
- **Cause**: Idle position was set in a bad location
- **Fix**: Toggle OFF then ON to reset idle position

### Character moves through walls
- **Note**: This mod doesn't have collision detection
- **This is normal**: Minecraft's movement system handles blocks

## Controls Reference

### Keybindings
- **Numpad 0**: Toggle mod ON/OFF
- **F3**: Debug screen (shows coordinates)
- **Q**: Drop held item

### Useful Commands
```
/give @p emerald 64          - Get 64 emeralds
/tp @p ~ ~5 ~                - Teleport up 5 blocks
/gamemode creative           - Switch to creative mode
/gamemode survival           - Switch to survival mode
```

## Performance Tips

### Optimal Usage
- Keep detection radius at 16 blocks (default)
- Don't enable in areas with too many item entities
- Toggle OFF when not collecting emeralds

### What Affects Performance
- ✅ Small detection radius = Better performance
- ✅ Fewer total items in world = Better performance
- ❌ Large detection radius = More lag
- ❌ Hundreds of items nearby = Slowdown

## Troubleshooting Visual Issues

### "I don't see the toggle message"
- Check chat isn't hidden (press T to open chat)
- Look for green text in chat
- Check F3 console for errors

### "Character moves but doesn't pick up emerald"
- You might be in spectator mode
- Emerald might be too far away
- Try getting closer manually first

### "Character won't move at all"
- Verify mod is ON (press Numpad 0)
- Check emerald is within 16 blocks
- Use F3 to see coordinates
- Try dropping emerald right in front of you

### "Character moves in wrong direction"
- Might be targeting a different emerald
- Use F3+B to show entity hitboxes
- See which emerald is actually nearest

## Video Demonstration Script

Want to record a demonstration? Follow this:

1. **Intro (0:00-0:10)**
   - Show normal Minecraft gameplay
   - Press Numpad 0 to enable

2. **Basic Demo (0:10-0:30)**
   - Drop single emerald
   - Show automatic collection
   - Return to idle

3. **Multiple Emeralds (0:30-0:50)**
   - Drop 5-10 emeralds around
   - Show collection order (nearest first)

4. **Distance Demo (0:50-1:10)**
   - Drop emerald far away
   - Show long-distance movement
   - Demonstrate 16 block radius

5. **Outro (1:10-1:20)**
   - Toggle OFF
   - Show it stops working

---

**Pro Tip**: Use F1 to hide UI for cleaner screenshots/videos!
