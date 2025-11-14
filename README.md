🚀 Download & Play

You don’t need any coding tools.
You only need Java 21+ installed (Java 25 works perfectly).

1. Go to the Releases section

➡️ Click Releases on the right side of the repo
➡️ Download:

CountFlapula.jar

Run_CountFlapula.bat

(Mac) CountFlapula.zip — contains CountFlapula.app

2. Run the Game
Windows Users

Double-click Run_CountFlapula.bat
(or run manually)

java -jar CountFlapula.jar

Mac Users

Install Java:

brew install temurin


Unzip CountFlapula.zip

Right-click CountFlapula.app → Open

Click Open again to confirm Gatekeeper

Play!

If macOS blocks it, run this in Terminal:

xattr -rd com.apple.quarantine /path/to/CountFlapula.app

🎮 Controls
Action	Key
Flap / Jump	Click
Start Game	Click
Exit	Escape or click Exit button
🕹️ Features

Flying animation

Hitbox-based collision detection

Obstacle generation

Score display

Custom textures (bird, spikes, cave, background)

Centered game window

Runnable without any IDE

📁 Project Structure
src/
  BirdImage.java
  GamePanel.java
  CaveSpikeImage.java
  MenuPanel.java
  FlappyGui.java
  Image/
    FlapUp.png
    FlapDown.png
    CaveWall.png
    NewBackDrop.png
    IntroPicture.png

dist/
  CountFlapula.jar
  Run_CountFlapula.bat

🧱 Building from Source

If you want to modify the game:

Clone the repo

Import into Eclipse

Run FlappyGui.java

📝 Credits

Created by Jordan Ayling
