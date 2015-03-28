# ArduinoKeyboard

This piece of program converts a CSV file into code that runs on Arduino boards that supports the "Keyboard" library, 
such as Arduino Leonardo. So that we can "replay" the keystrokes recorded in a file repeatedly many times to study the pattern.

1. Runs the main function.
2. From the GUI, click "Open the target file" to choose a CSV file.
3. Click "choose a directory to save the code" to choose a directory.
4. A valid Subject need to be specified, ie an existing Subject in the CSV file, eg s003,s033, etc.
5. Sessions(s) and Rep(s) also need to be specified. Note that Sessions and Reps can be a range. eg 1-4, 2-5, etc.
6. Click "start".
7. Click "show code".
8. Copy the code into Arduino IDE.
9. Connect the Arduino board, and upload the code. Plug wire to pin 4 to run the code.
 
Set up the Arduino Board: http://arduino.cc/en/uploads/Tutorial/KeyboardMessage3_bb.png
 
Note: The Arduino Board will repeat repeat the process until the wire to pin 4 is unplugged.
You will be noticed at the end of the process, and decide whether to pull the plug

The CSV file format follows the sample on the project webpage. http://www.cs.cmu.edu/~keystroke/DSL-StrongPasswordData.csv
