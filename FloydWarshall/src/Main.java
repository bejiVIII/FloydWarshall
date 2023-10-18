import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	static String [][] v = new String[6][6];

	public static void getInput()
	{
		try
		{
			Scanner sc = new Scanner(new BufferedReader(new FileReader("input.txt")));
		    while(sc.hasNextLine())
		    {
		    	
		    	for (int i=0; i < v.length; i++)
		    	{
		    		String[] line = sc.nextLine().trim().split(" ");
		    		
		            for (int j=0; j < line.length; j++)
		            {	
		            	
		            	if(line[j].equals("ꝏ"))
		            	{
		            		v[i][j] = String.valueOf(Double.POSITIVE_INFINITY);
		            	}
		            	else
		            	{
		            		v[i][j] = line[j];
		            	}
		            }
		        }
		    }
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void writeOutput()
	{
		double altDist = 0.0;
		try
		{
			FileWriter fw = new FileWriter("output.txt");	
			
			for(int k = 0; k < 6; k++)
			{
				fw.append("T" + (k + 1) + "(V): \n");
				
				for(int i = 0; i < 6; i++)
				{
					for(int j = 0; j < 6; j++)
					{
						if(v[i][k] == "Infinity")
						{
							altDist = Double.POSITIVE_INFINITY + Double.parseDouble(v[k][j]);
						}
						else if(v[k][j] == "Infinity")
						{
							altDist = Double.parseDouble(v[i][k]) + Double.POSITIVE_INFINITY; 
						}
						else if(v[i][k] == "Infinity" && v[k][j] == "Infinity")
						{
							altDist = Double.POSITIVE_INFINITY + Double.POSITIVE_INFINITY; // which is double.positive_infinity
						}
						else
						{
							altDist = Double.parseDouble(v[i][k]) + Double.parseDouble(v[k][j]);
						}
						if(Double.parseDouble(v[i][j]) > altDist)
						{
							
							v[i][j] = String.valueOf((int)altDist);
							//p[i][j]...
						}
						
						
						if(v[i][j].equals("Infinity"))
						{
							fw.append("ꝏ");
						}
						else
						{
							fw.append(v[i][j]);
						}
						
						fw.append(" ");
					}
					fw.append("\n");
				}
				fw.append("\n");
			}
			
			fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
			
	public static void main(String[] args)
	{	
		getInput();
		writeOutput();
	}
}
