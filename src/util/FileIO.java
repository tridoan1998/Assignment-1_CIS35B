package util;
import java.io.*;
import java.util.*;
import model.*;

public class FileIO {
	
	//Put Car lower case 
	public Automotive buildAutomotiveObject(String filename, Automotive Car)
	{
		try {
		FileReader file = new FileReader(filename);
		BufferedReader buff = new BufferedReader(file);
		boolean eof = false;
		int counter = 0;	
		int index2 = 0;
		int index3 = 0;
		int index4 = 0;

		while(!eof)
		{
			counter++;
			String line = buff.readLine();
			 if (line == null)
			 {
				 eof = true;
			 }

			 //get optionset name
			 else if(counter == 1 || counter == 5 || counter == 9|| counter == 13 || counter == 17)
			 {
				 Car.setNameForOptionSet(line, index2);
				 index2++;
			 }
			 
			 //get array size of options
			 else if(counter == 2 || counter ==6 || counter == 10 || counter == 14 || counter == 18)
			 {
				 if(counter == 2)
				 {
					 int i = Integer.parseInt(line);
						Car.createOption(i, 0);
				 }
				 else if (counter == 6)
				 {
					 int i = Integer.parseInt(line);
						Car.createOption(i, 1);
				 }
				 else if (counter == 10)
				 {
					 int i = Integer.parseInt(line);
						Car.createOption(i, 2);
				 }
				 else if (counter == 14)
				 {
					 int i = Integer.parseInt(line);
						Car.createOption(i, 3);
				 }
				 else if (counter == 18)
				 {
					 int i = Integer.parseInt(line);
						Car.createOption(i, 4);
				 }
			 }
			 
			 //get option name
			 else if(counter == 3 || counter == 7 || counter == 11 || counter == 15 || counter == 19)
			 {
				 int temp = 0;
				 StringTokenizer stringtoken = new StringTokenizer(line, ",");
				 while(stringtoken.hasMoreTokens())
				 {
					String str = stringtoken.nextToken();
					Car.setNameForOption(str, index3, temp);
					 temp++;
				 }
				index3++;
			 }
			 
			 //get option price 
			 else if(counter == 4 || counter == 8 || counter == 12 || counter == 16 || counter == 20)
			 {
				 int temp = 0;
				 StringTokenizer stringtoken = new StringTokenizer(line, ",");
				 while(stringtoken.hasMoreTokens())
				 {
					 String str = stringtoken.nextToken();
					 float i = Float.parseFloat(str);
					 Car.setPriceForOption(i, index4, temp);
					 temp++;
				 }
				 index4++;
			 }
		}
		file.close();
		buff.close();

		}catch(ArrayIndexOutOfBoundsException e)
		{
            System.out.println("Error нн " + e.toString());
        }
		catch(NullPointerException e)
		{
            System.out.println("Error нн " + e.toString());
        }
		catch(IOException e)
		{
            System.out.println("Error нн " + e.toString());
        }
		return null;
	}
	
	//archive the object using Serialization
	public void Serialize(Automotive Car)
	{
		try {
		String filename = "file.ser";
	        FileOutputStream file = new FileOutputStream(filename); 
	        ObjectOutputStream out = new ObjectOutputStream(file); 
	        out.writeObject(Car);           
	        out.close(); 
	        file.close();
		}catch(IOException e)
		{
			System.out.println("IOException is caught!");
		}
	}
	
	public void Derialize(String filename, Automotive Car)
	{
	       try
	        {    
	    	    FileInputStream file = new FileInputStream(filename); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	            // Method for deserialization of object 
	            Car = (Automotive) in.readObject(); 
	            in.close(); 
	            file.close(); 
	            System.out.println("Object has been deserialized ");
	        } 	          
	        catch(IOException ex) 
	        { 
	            System.out.println("IOException is caught"); 
	        } 
	        catch(ClassNotFoundException ex) 
	        { 
	            System.out.println("ClassNotFoundException is caught"); 
	        } 
	}
}
