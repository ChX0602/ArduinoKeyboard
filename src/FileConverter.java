import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FileConverter{
	private static final String hold = "H";
	private static final String downDown = "DD";
	private BufferedReader br;
	private BufferedWriter bw;
	private String inputFileName;
	private String outputFileName;
	private String subject;
	private int sessionIndexLow;
	private int sessionIndexHigh;
	private int repLow;
	private int repHigh;
	private AsciiMap asciiDict;
	
	public FileConverter(String inputFile) throws IOException
	{
		inputFileName = inputFile;
		outputFileName = "tempData.txt";
		br = new BufferedReader(new FileReader(inputFileName));
		bw = new BufferedWriter(new FileWriter(outputFileName));
		asciiDict = new AsciiMap();
	}
	
	/*
	 * given a subject, get all the sessions and reps that subject performed
	 */
	
	public void generateTempFile(String subject, String sessionIndex, String rep) throws IOException
	{
		this.subject = subject;
		
		//keep each rep in log, and sort the keystrokes in order of time
		ArrayList<String> log = new ArrayList<String>();
		
		//the firstLine contains actions and name of keys
		String firstLine = br.readLine();
		String [] firstLineTokens = firstLine.split(",");
		int lineLength = firstLineTokens.length;
		
		/*
		 * parse the range of sessionIndex
		 */
		try {
			int i = Integer.parseInt(sessionIndex);
			sessionIndexLow = i;
			sessionIndexHigh = i;
		} catch(NumberFormatException e) {
			String s = sessionIndex.replaceAll("[\\D]",",");
			String [] toks = s.split(",");
			sessionIndexLow = Integer.valueOf(toks[0]);
			sessionIndexHigh = Integer.valueOf(toks[1]);
		}
		
		/*
		 * parse the range of rep
		 */
		try {
			int i = Integer.parseInt(rep);
			repLow = i;
			repHigh = i;
		} catch(NumberFormatException e) {
			String s = rep.replaceAll("[\\D]",",");
			String [] toks = s.split(",");
			repLow = Integer.valueOf(toks[0]);
			repHigh = Integer.valueOf(toks[1]);
		}
		
		String line;
		String [] tokens;
		
		int timeline = 5000;
		
		while((line = br.readLine())!=null)
		{
			tokens = line.split(",");
			if(tokens[0].equals(this.subject))
			{
				sessionIndex = tokens[1];
				rep = tokens[2];
				
				int currentSessionIndex = Integer.valueOf(sessionIndex);
				int currentRep = Integer.valueOf(rep);
				
				if (currentSessionIndex >= sessionIndexLow && currentSessionIndex <= sessionIndexHigh
						&& currentRep >= repLow && currentRep <= repHigh)
				{
					
					for (int i=3; i<lineLength; i++)
					{
						String [] action = firstLineTokens[i].split("\\.");
						String act = action[0];
						// first key in a row
						if(i==3)
						{
							bw.write("//Starting in 5 seconds: subject: "+ subject + ", "+ "session: " + sessionIndex + ", " + "rep: " + rep + "\n");
						}
						if(act.equals(hold))
						{
							
							float holdTime = Float.valueOf(tokens[i]);
							int ascii = ~42;
							if(action.length == 2)
							{
								String key = action[1];
								if(!asciiDict.containsKey(key))
								{
									System.err.println("ASCII value of key "+key+" not found");
								}
								else
								{
									ascii = asciiDict.get(key);
								}
								log.add(String.valueOf(timeline)+","+String.valueOf(ascii)+","+"p");
								log.add(String.valueOf(timeline+(int)(holdTime * 1000))+","+String.valueOf(ascii)+","+"r");
							}
							
							else if(action.length == 3)
							{
								String modKey = action[1];
								String key = action[2];
								if(!asciiDict.containsKey(modKey))
								{
									System.err.println("ASCII value of key "+modKey+" not found");
								}
								else
								{
									ascii = asciiDict.get(modKey);
									log.add(String.valueOf(timeline)+","+String.valueOf(ascii)+","+"p");
									log.add(String.valueOf(timeline+(int)(holdTime * 1000))+","+String.valueOf(ascii)+","+"r");
								}
								
								
								if(!asciiDict.containsKey(key))
								{
									System.err.println("ASCII value of key "+key+" not found");
								}
								else
								{
									ascii = asciiDict.get(key);
									log.add(String.valueOf(timeline+1)+","+String.valueOf(ascii)+","+"p");
									log.add(String.valueOf(timeline+(int)(holdTime * 1000)-1)+","+String.valueOf(ascii)+","+"r");
								}
								
							}
							
							//this is the last key in the row, extend the timeline until the last key releases
							if(i==lineLength-1)
							{
								timeline+=(int)(holdTime * 1000);
							}
						}
						else if(act.equals(downDown))
						{
							float interval = Float.valueOf(tokens[i]);
							timeline += (int)(interval * 1000);
						}
						
						//this is the last key in the row, delay the timeline by 5 seconds, then start the next row
							
					}
					
					Collections.sort(log, new timeComp());
					for (String s: log)
					{
						bw.write(s+"\n");
					}
					log.clear();
					timeline += 5000;
					bw.write("//Finished: subject: "+ subject + ", "+ "session: " + sessionIndex + ", " + "rep: " + rep + "\n");
				}
			}
		}
		br.close();
		bw.close();
	}
		class timeComp implements Comparator<String>{
			@Override
			public int compare(String s1, String s2)
			{
				int i1 = Integer.valueOf(s1.split(",")[0]);
				int i2 = Integer.valueOf(s2.split(",")[0]);
				if(i1>i2) return 1;
				else return -1;
			}
		}
}