# 🎮 START HERE - Emerald Collector Mod

## 👋 Welcome!

You asked me to create a Minecraft mod that:
- ✅ Sits at an idle position
- ✅ Detects emerald items nearby
- ✅ Moves toward them automatically
- ✅ Returns to idle when no emeralds are found
- ✅ Can be toggled with Numpad 0

**I've created everything you need!** Let's get it running.

---

## 📦 What's Included

Your mod project contains:

### Code Files (Java)
- `EmeraldCollectorMod.java` - Main mod initialization
- `EmeraldCollectorClient.java` - Movement and detection logic

### Configuration Files
- `fabric.mod.json` - Mod information
- `build.gradle` - Build instructions
- `gradle.properties` - Version settings
- `settings.gradle` - Gradle configuration
- `en_us.json` - English language strings

### Documentation Files
- **THIS FILE** - Quick start guide (you're reading it!)
- `PROJECT_OVERVIEW.md` - Complete project guide
- `SETUP_INSTRUCTIONS.md` - Detailed setup steps
- `VISUAL_GUIDE.md` - Testing and troubleshooting
- `README.md` - Feature overview

---

## 🚀 5-Minute Quick Start

### Step 1: Install Java ☕
**Windows/Mac/Linux:**
1. Go to: https://adoptium.net/
2. Download "JDK 17" (the LTS version)
3. Install it
4. Open terminal/command prompt and type:
   ```
   java -version
   ```
   You should see "openjdk version 17..." ✅

### Step 2: Install Fabric 🧵
1. Go to: https://fabricmc.net/use/installer/
2. Download "Universal JAR" installer
3. Run it (double-click)
4. Select:
   - **Client** (not server)
   - **Version: 1.20.4**
5. Click "Install" ✅

### Step 3: Install Fabric API 📚
1. Go to: https://modrinth.com/mod/fabric-api/versions
2. Find version for **Minecraft 1.20.4**
3. Download the `.jar` file
4. Move it to:
   - **Windows**: `%APPDATA%\.minecraft\mods`
   - **Mac**: `~/Library/Application Support/minecraft/mods`
   - **Linux**: `~/.minecraft/mods`
5. Create the `mods` folder if it doesn't exist ✅

### Step 4: Build Your Mod 🔨
**Windows:**
```cmd
cd path\to\emerald-collector-mod
gradlew.bat build
```

**Mac/Linux:**
```bash
cd path/to/emerald-collector-mod
chmod +x gradlew
./gradlew build
```

**Wait 5-10 minutes** for first build (downloads dependencies) ⏳

### Step 5: Install Your Mod 📥
1. Find: `build/libs/emerald-collector-1.0.0.jar`
2. Copy to your Minecraft `mods` folder (same as Step 3)
3. You should now have TWO files in `mods`:
   - `fabric-api-...jar` 
   - `emerald-collector-1.0.0.jar` ✅

### Step 6: Test It! 🎉
1. Launch Minecraft
2. Select "Fabric" profile
3. Create new world (Creative mode)
4. Press **Numpad 0** → see "Emerald Collector: enabled"
5. Type: `/give @p emerald`
6. Press **Q** to drop the emerald
7. **Watch your character move to it!** 🎯

---

## 🎮 How to Use

### Basic Controls
- **Numpad 0**: Toggle ON/OFF
- **Q**: Drop held item
- **F3**: Debug info (coordinates)
- **T**: Open chat

### Testing Commands
```
/give @p emerald 64          Get 64 emeralds
/gamemode creative           Creative mode
/tp @p ~ ~10 ~              Teleport up 10 blocks
```

### Expected Behavior
1. **Enable mod** (Numpad 0)
2. **Current position becomes idle point**
3. **Drop/spawn emerald**
4. Character **automatically moves** toward it
5. **Picks it up**
6. **Returns to idle position**
7. **Waits** for next emerald

---

## ⚠️ Troubleshooting

### "Build failed" / "Java not found"
- Make sure JDK 17+ is installed
- Verify with: `java -version`
- Restart terminal after installing Java

### "Mod doesn't appear in game"
- Check both files in `mods` folder:
  - Fabric API
  - Your mod
- Launch with "Fabric" profile
- Check Minecraft version is 1.20.4

### "Numpad 0 doesn't work"
- Use **Numpad** 0, not regular 0
- Check Controls → Key Binds for conflicts
- See message in chat when pressed

### "Character won't move"
- Make sure mod is enabled (Numpad 0)
- Drop emerald closer (within 16 blocks)
- Check you're not in Spectator mode
- Try in new Creative world

### Still having issues?
1. Read `SETUP_INSTRUCTIONS.md` for detailed help
2. Check `logs/latest.log` in `.minecraft` folder
3. Look for red error messages
4. Make sure prerequisites are installed

---

## 📝 File Locations Reference

### Windows
- Minecraft: `%APPDATA%\.minecraft`
- Mods: `%APPDATA%\.minecraft\mods`
- Logs: `%APPDATA%\.minecraft\logs`

### Mac
- Minecraft: `~/Library/Application Support/minecraft`
- Mods: `~/Library/Application Support/minecraft/mods`
- Logs: `~/Library/Application Support/minecraft/logs`

### Linux
- Minecraft: `~/.minecraft`
- Mods: `~/.minecraft/mods`
- Logs: `~/.minecraft/logs`

---

## 🎯 What Next?

### First Time Setup (Today)
1. ✅ Install Java
2. ✅ Install Fabric
3. ✅ Install Fabric API
4. ✅ Build your mod
5. ✅ Test it works

### Customization (Later)
Want to change something? See `PROJECT_OVERVIEW.md` section "Customization Guide" for:
- Changing target item (emerald → diamond)
- Adjusting detection range
- Changing movement speed
- Changing toggle key
- Adding more features

### Learning More
- `PROJECT_OVERVIEW.md` - Complete guide with code explanations
- `VISUAL_GUIDE.md` - Visual testing guide
- Fabric Wiki: https://fabricmc.net/wiki/

---

## ✅ Success Checklist

Before asking for help, verify:
- [ ] Java 17+ installed (`java -version`)
- [ ] Fabric Loader installed for 1.20.4
- [ ] Fabric API in mods folder
- [ ] Your mod in mods folder
- [ ] Launched with "Fabric" profile
- [ ] Pressed Numpad 0 (see message in chat)
- [ ] Emerald is within 16 blocks
- [ ] Not in Spectator mode

---

## 💡 Pro Tips

1. **Use Creative Mode** for testing - no need to find emeralds
2. **Use F3** to see coordinates and debug info
3. **Test in new world** to avoid conflicts
4. **Read error messages** in logs folder
5. **Start simple** - test with one emerald first

---

## 🎊 You Did It!

Congratulations! You've created your first Minecraft mod with:
- ✅ Custom keybinding
- ✅ Entity detection
- ✅ Automatic movement
- ✅ State management

This is impressive for someone with no programming background! 

**Enjoy your new emerald-collecting powers!** 💎

---

**Next Steps:**
1. Follow Steps 1-6 above
2. Test the mod in-game
3. Read other docs to understand the code
4. Experiment with customization
5. Build something even cooler!

**Need more help?** Check the other `.md` files - they have tons of detail!
