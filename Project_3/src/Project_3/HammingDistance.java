package Project_3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HammingDistance {
	
	//Garrett: Changed path
	private final static String FILE = "src/Mesonet.txt";
	
	//returns a string of all stations [hammingDistance] away from the station provided, delimited by \n
	public static String stationsViaHammingDistance(String station, int hammingDistance)
	{
		String outputStations = "";
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(FILE));
			
			//skips the first 3 lines of the file as they aren't stations
			for(int i = 0; i < 3; i++)
			{
				br.readLine();
			}
			
			
			while(br.ready())
			{
				String line = br.readLine();
				
				//isolates the station from the line
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
			
			//skips the first 3 lines of the file as they aren't stations
			for(int i = 0; i < 3; i++)
			{
				br.readLine();
			}
			
			
			while(br.ready())
			{
				String line = br.readLine();
				
				//isolates station from the line
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

	//returns an arraylist of all the stations in given file
	public static ArrayList<String> getAllStations()
	{
		
		ArrayList<String> allStations = new ArrayList<String>();
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(FILE));
			
			//skips the first 3 lines of the file as they aren't stations
			for(int i = 0; i < 3; i++)
			{
				br.readLine();
			}
			
			
			while(br.ready())
			{
				String line = br.readLine();
				
				//isolates station from the line
				String currentStation = line.split(" ")[1];
				
				//adds station to array list
				allStations.add(currentStation);
			}
			
		}
		catch (IOException e)
		{
			System.out.println("Unable to open file");
			e.printStackTrace();
		}
		
		
		return allStations;
	}
	
	public static Map<String, ArrayList<String>> findAllStationsAtHammingDist(int hammingDistance)
	{
		Map<String, ArrayList<String>> stations = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> allStations = getAllStations();
		
		for(String x : allStations)
		{
			String[] stationsAtHammingDistArr = stationsViaHammingDistance(x, hammingDistance).split("\n");
			
			ArrayList<String> stationsAtHammDist = new ArrayList<String>();
			
			int cnt = 0;
			for(String y : stationsAtHammingDistArr)
			{
				cnt++;
				stationsAtHammDist.add(y);
			}
			
			if(cnt != 0)
			{
				stations.put(x, stationsAtHammDist);
			}
		}
		
		
		return stations;
		
		
		
	}
	
	

}
