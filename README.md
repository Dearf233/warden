# 🟢 Emerald Collector Mod for Minecraft 1.20.4

A Fabric mod that automatically moves your character to collect emerald items!

## 🎮 Features
- **Automatic Detection**: Scans for emerald items within 16 blocks
- **Smart Movement**: Uses vector-based pathfinding to reach emeralds
- **Idle Return**: Returns to starting position when no emeralds are nearby
- **Easy Toggle**: Press Numpad 0 to enable/disable
- **Visual Feedback**: In-game messages show mod status

## 📋 Requirements
- Minecraft Java Edition 1.20.4
- Java 17 or higher
- Fabric Loader 0.15.3+
- Fabric API 0.95.1+

## 🚀 Quick Start

### For Players (Installing):
1. Install Fabric Loader for Minecraft 1.20.4
2. Download Fabric API and place in `.minecraft/mods`
3. Download the mod `.jar` file
4. Place it in `.minecraft/mods` folder
5. Launch Minecraft and press **Numpad 0** in-game!

### For Developers (Building):
1. Install JDK 17+
2. Set up the project structure (see SETUP_INSTRUCTIONS.md)
3. Run `gradlew build` (Windows) or `./gradlew build` (Mac/Linux)
4. Find compiled mod in `build/libs/`

## 🎯 How to Use
1. Launch Minecraft with the mod installed
2. Enter a world
3. Press **Numpad 0** to toggle the collector ON
4. Drop an emerald or spawn one with `/give @p emerald`
5. Watch your character automatically move to collect it!
6. Press **Numpad 0** again to toggle OFF

## ⚙️ Configuration
Edit these values in `EmeraldCollectorClient.java`:
- `DETECTION_RADIUS`: How far to scan (default: 16 blocks)
- `MOVEMENT_SPEED`: Movement speed (default: 0.2)
- `REACH_THRESHOLD`: Pickup distance (default: 1.5 blocks)

## 📁 Project Structure
```
emerald-collector-mod/
├── src/main/java/com/yourname/emeraldcollector/
│   ├── EmeraldCollectorMod.java          # Main mod class
│   └── EmeraldCollectorClient.java       # Movement logic
├── src/main/resources/
│   ├── fabric.mod.json                    # Mod metadata
│   └── assets/emeraldcollector/lang/
│       └── en_us.json                     # Translations
├── build.gradle                           # Build configuration
└── gradle.properties                      # Version properties
```

## 🔧 How It Works
1. **Initialization**: Registers Numpad 0 as toggle key
2. **Tick Event**: Checks every game tick (20x/second) if enabled
3. **Scanning**: Searches for emerald ItemEntities within radius
4. **Movement**: Calculates vector to nearest emerald and moves player
5. **Idle State**: Returns to original position when no emeralds found

## 🐛 Troubleshooting

**Mod won't load?**
- Check Fabric Loader and Fabric API are installed
- Verify versions match (1.20.4)
- Check `logs/latest.log` for errors

**Key not working?**
- Use Numpad 0, not regular 0
- Check for key binding conflicts in controls

**Character won't move?**
- Toggle mod ON with Numpad 0
- Emerald must be within 16 blocks
- Check you're in survival/creative, not spectator

## 🎨 Customization Ideas
- Change target item type (diamonds, gold, etc.)
- Adjust detection radius for larger/smaller range
- Modify movement speed for faster/slower collection
- Add support for multiple item types
- Implement priority system for valuable items
- Add sound effects when emeralds are detected

## 📜 License
MIT License - Feel free to modify and share!

## 🙏 Credits
Built with Fabric modding framework
Created for educational purposes

---

For detailed setup instructions, see **SETUP_INSTRUCTIONS.md**
