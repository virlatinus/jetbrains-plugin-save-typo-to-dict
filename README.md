# jetbrains-plugin-save-typo-to-dict
Adds a shortcut to quickly add the current word under the carret to the project-level dictionary

## Requirements

- Docker (the build runs entirely inside a `gradle:8-jdk21` container, so no local JDK or Gradle install is needed)
- A JetBrains IDE compatible with build range 232–242.* (2023.2–2024.2, e.g. IntelliJ IDEA 2023.2+)

## Build

```
make
```

This produces the installable plugin archive at `build/distributions/save-typo-to-dictionary-1.0.0.zip`.

## Install

1. In your JetBrains IDE, go to `Settings/Preferences > Plugins`.
2. Click the gear icon and choose `Install Plugin from Disk...`.
3. Select `build/distributions/save-typo-to-dictionary-1.0.0.zip`.
4. Restart the IDE when prompted.

## Usage

Place the caret on a word and press `Shift+Ctrl+Alt+S` (or right-click the word and choose **Save Word Under Caret to Dictionary**) to add it to the project-level spelling dictionary. The keyboard shortcut can be changed under `Settings/Preferences > Keymap`.
