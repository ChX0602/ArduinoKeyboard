import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class CodeGenerator{
	private static int minutes;
	private static int seconds;
	private static int timeCount;
	
	public CodeGenerator()
	{
		minutes=0;
		seconds=0;
		timeCount=0;
	}
	
	public void run(String inputFileName, String outputFileName) throws IOException
	{
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFileName));
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));
			/*
			 * write skeleton code in the target file
			 * start executing code when pin 4 is connected to high volt
			 * i.e. it works like a physical switch
			 */
			bw.write("const int buttonPin = 4;\n");
	
			bw.write("void setup() {\n");
			bw.write("  pinMode(buttonPin, INPUT);\n");
			bw.write("  Keyboard.begin();\n");
			bw.write("}\n");
			
			bw.write("void loop() {\n");
			bw.write("  int buttonState = digitalRead(buttonPin);\n");
			bw.write("  if (buttonState == HIGH) {\n");
			try {
				int currentTime = 0;
				int lastTime = 0;
				int key = ~1;
				int interval = 0;
				Boolean state = true;
				Set<Integer> keyPressed = new HashSet<Integer>();
				while((line = br.readLine()) != null)
				{
					if (line.substring(0, 3).equals("//F"))
					{
						bw.write("    " + line + "\n");
						bw.write("    Serial.println(\"" + line.substring(2) + "\");\n");
					}
					
					else if (line.substring(0, 3).equals("//S"))
					{
						bw.write("    " + line + "\n");
						bw.write("    Serial.println(\"" + line.substring(2) + "\");\n");
					}
					else
					{
						String[] tokens = line.split(",");
						currentTime = Integer.valueOf(tokens[0]);
						key = Integer.valueOf(tokens[1]);
						state = (tokens[2].equals("p"));
						interval = currentTime-lastTime;
						lastTime = currentTime;
						
						bw.write("    delay("+String.valueOf(interval)+");\n");
						timeCount+=interval;
						
						if (state)
						{
							//action = "pressed";
							if (keyPressed.contains(key))
							{
								System.err.println("the key "+String.valueOf(key)+
										"is pressed again before release, this is impossible, please check the source");
							}
							keyPressed.add(key);
							bw.write("    Keyboard.press("+key+");\n");
						}
						else if(!state)
						{
							//action = "released";
							if(!keyPressed.contains(key))
							{
								System.err.println("the key has not even been pressed! something wrong with the source!");
							}
							keyPressed.remove(key);
							bw.write("    Keyboard.release("+key+");\n");
						}
					}
					
				
				}
				/* after all the keystrokes, inform the user */
				bw.write("    Serial.println(\"done!\\n\");\n");
				bw.write("    int counter = 10;\n");
				bw.write("    while (counter > 0 && buttonState == HIGH)\n");
				bw.write("    {\n");
				bw.write("      Serial.print(\"the process will repeat in \");\n");
				bw.write("      Serial.print(counter);\n");
				bw.write("      Serial.print(\" seconds, unplug the wire to cancel\\n\");\n");
				bw.write("      counter--;\n");
				bw.write("      buttonState = digitalRead(buttonPin);\n");
				bw.write("      delay(1000);\n");
				bw.write("    }\n");
				bw.write("  }\n");
				bw.write("}");
				bw.close();
				
				/* tell the user the amount of time the keystroke simulation will take*/
				timeInMinute(timeCount);
				System.out.println(timeCount);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void timeInMinute(int timeInMilli)
	{
		minutes = timeInMilli / 60000;
		seconds = (timeInMilli % 60000)/ 1000;
		System.out.println("The simulator will run for about "+String.valueOf(minutes)+ 
				" " + "minutes and" + " " +String.valueOf(seconds)+" " +"seconds");
	}
	
	public int getMinutes()
	{
		return minutes;
	}
	
	public int getSeconds()
	{
		return seconds;
	}
	
}