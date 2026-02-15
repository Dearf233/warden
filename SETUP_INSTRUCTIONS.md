# Emerald Collector Mod - Setup Instructions

## Overview
This mod automatically moves your character towards emerald items when they spawn nearby. When no emeralds are detected, your character returns to the idle position. Press Numpad 0 to toggle the feature on/off.

## Features
- ✅ Automatic emerald detection within 16 blocks
- ✅ Vector-based smooth movement towards emeralds
- ✅ Automatic return to idle position
- ✅ Toggle on/off with Numpad 0
- ✅ In-game notification when toggled

## Prerequisites
Before you start, you need to install:

1. **Java Development Kit (JDK) 17 or higher**
   - Download from: https://adoptium.net/
   - Choose "JDK 17" or later
   - Install and verify by opening terminal/command prompt and typing: `java -version`

2. **Minecraft Java Edition 1.20.4**
   - Make sure you have this version installed

3. **Fabric Loader**
   - Download from: https://fabricmc.net/use/installer/
   - Run the installer and select version 1.20.4
   - Install client to your .minecraft folder

4. **Fabric API**
   - Download from: https://modrinth.com/mod/fabric-api/versions
   - Get version for Minecraft 1.20.4
   - Place the .jar file in your `.minecraft/mods` folder

## Project Setup

### Step 1: Create Project Structure
Create the following folder structure:

```
emerald-collector-mod/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── yourname/
│   │   │           └── emeraldcollector/
│   │   │               ├── EmeraldCollectorMod.java
│   │   │               └── EmeraldCollectorClient.java
│   │   └── resources/
│   │       ├── fabric.mod.json
│   │       └── assets/
│   │           └── emeraldcollector/
│   │               └── lang/
│   │                   └── en_us.json
├── build.gradle
└── gradle.properties
```

### Step 2: Place the Files
1. Copy `EmeraldCollectorMod.java` to: `src/main/java/com/yourname/emeraldcollector/`
2. Copy `EmeraldCollectorClient.java` to: `src/main/java/com/yourname/emeraldcollector/`
3. Copy `fabric.mod.json` to: `src/main/resources/`
4. Copy `en_us.json` to: `src/main/resources/assets/emeraldcollector/lang/`
5. Copy `build.gradle` to the root folder
6. Copy `gradle.properties` to the root folder

### Step 3: Build the Mod

#### On Windows:
1. Open Command Prompt
2. Navigate to your mod folder: `cd path\to\emerald-collector-mod`
3. Run: `gradlew.bat build`

#### On Mac/Linux:
1. Open Terminal
2. Navigate to your mod folder: `cd path/to/emerald-collector-mod`
3. Make gradlew executable: `chmod +x gradlew`
4. Run: `./gradlew build`

### Step 4: Install the Mod
1. After building, find the mod file at: `build/libs/emerald-collector-1.0.0.jar`
2. Copy this file to your `.minecraft/mods` folder
   - Windows: `%APPDATA%\.minecraft\mods`
   - Mac: `~/Library/Application Support/minecraft/mods`
   - Linux: `~/.minecraft/mods`

### Step 5: Test the Mod
1. Launch Minecraft with Fabric
2. Create a new world or join an existing one
3. Press **Numpad 0** to enable the mod
4. Throw an emerald on the ground (or use `/give @p emerald`)
5. Your character should automatically move towards it!

## How It Works

### Code Explanation

**EmeraldCollectorMod.java** - Main initialization
- Registers the toggle key (Numpad 0)
- Listens for key presses
- Manages the enabled/disabled state
- Shows messages to the player

**EmeraldCollectorClient.java** - Movement logic
- Runs every game tick (20 times per second)
- Scans for emerald items within 16 blocks
- Calculates direction vector to the nearest emerald
- Moves the player using velocity
- Returns to idle position when no emeralds are found

### Key Variables You Can Customize

In `EmeraldCollectorClient.java`:
- `DETECTION_RADIUS = 16.0` - How far to scan for emeralds (in blocks)
- `MOVEMENT_SPEED = 0.2` - How fast to move towards emeralds
- `REACH_THRESHOLD = 1.5` - How close to get before considering "reached"

## Troubleshooting

### Build Errors
- Make sure JDK 17+ is installed: `java -version`
- Delete `.gradle` folder and try again
- Check that all files are in the correct folders

### Mod Not Loading
- Verify Fabric Loader is installed for 1.20.4
- Verify Fabric API is in the mods folder
- Check the `logs/latest.log` file for errors

### Key Not Working
- Make sure you're pressing Numpad 0, not the regular 0 key
- Check Minecraft controls to see if there's a conflict

### Character Not Moving
- Make sure the mod is toggled ON (press Numpad 0)
- Check that emeralds are within 16 blocks
- Try in a new world to rule out conflicts

## Customization Ideas

Want to modify the mod? Here are some ideas:

1. **Change the item type**: In `EmeraldCollectorClient.java`, change `Items.EMERALD` to `Items.DIAMOND`, `Items.GOLD_INGOT`, etc.

2. **Change the detection radius**: Modify `DETECTION_RADIUS` value

3. **Change the toggle key**: In `EmeraldCollectorMod.java`, change `GLFW.GLFW_KEY_KP_0` to another key code from: https://www.glfw.org/docs/latest/group__keys.html

4. **Add multiple item types**: Modify the filter in `findNearestEmerald()` to check for multiple item types

## License
This mod is provided as-is for educational purposes. Feel free to modify and distribute!

## Credits
Created with assistance from Claude (Anthropic)
Built with Fabric modding framework

---

Need help? Common issues are usually solved by:
1. Checking Java version
2. Verifying all dependencies are installed
3. Reading the error logs in `.minecraft/logs/latest.log`
