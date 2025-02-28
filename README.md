# Compose keyboard focus issue repro

Instructions:

- control the focus with keyboard
- focus the BasicTextField
- press dpad left and right to move the cursor
- press the button to toggle BasicTextField horizontal padding
- move focus to the BasicTextField
- pressing dpad left moves focus to the button instead of moving the cursor

Tested with emulator: 35.3.11-12836668

See screen recording in project root. 