package Project_3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HammingDistance {
	
	private final static String FILE = "Project_3/src/Mesonet.txt";
	
	public static String stationsViaHammingDistance(String station, int hammingDistance)
	{
		String outputStations = "";
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(FILE));
			
			for(int i = 0; i < 3; i++)
			{
				br.readLine();
			}
			
			
			while(br.ready())
			{
				String line = br.readLine();
				
				String currentStation = line.split(" ")[1];
				
				
				if(findHammingDist(station, currentStation) == hammingDistance)
				{
					outputStations += currentStation + "\n";
				}
			}
			
		}
		catch (IOException e)
		{
			System.out.println("Unable to open file");
			e.printStackTrace();
		}
		
		
		return outputStations;
	}
	
	public static int findNumStationsAtDistance(String station, int hammingDistance)
	{
		int counter = 0;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(FILE));
			
			for(int i = 0; i < 3; i++)
			{
				br.readLine();
			}
			
			
			while(br.ready())
			{
				String line = br.readLine();
				
				String currentStation = line.split(" ")[1];
				
				
				if(findHammingDist(station, currentStation) == hammingDistance)
				{
					counter++;
				}
			}
			
		}
		catch (IOException e)
		{
			System.out.println("Unable to open file");
			e.printStackTrace();
		}
		
		return counter;
	}
	
	private static int findHammingDist(String st1, String st2)
	{
		int hammingDist = 0;
		
		if(st1.length() != st2.length())
		{
			return -1;
		}
		
		for(int i = 0; i < st1.length(); i++)
		{
			//if the character at [i] of each string isnt equal then hamming dist is increased
			if(!(st1.substring(i, i+1).equals(st2.substring(i, i+1))))
			{
				hammingDist++;
			}
		}
		
		return hammingDist;
	}
	
	

}
