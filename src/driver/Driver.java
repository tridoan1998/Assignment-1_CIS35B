/*
Name: Tri Doan
Assignment: Lab 1
Due Date: 04/23/2019
Turn in Date: 04/23/2019
 */

package driver;
import model.*;
import util.*;

public class Driver {

	public static void main(String[] args) {
		try {
			Automotive Car = new Automotive(5, "Focus Wagon ZTW", 18455);
			FileIO File = new FileIO();
			String filename = "C:\\Users\\Tri Doan\\eclipse-workspace\\Assignment 1_CIS35B\\src\\data.txt";
			File.buildAutomotiveObject(filename, Car);		
			//Car.print();
			Car.deleteOptionSet(0);
			Car.deleteOption(1,0);
			System.out.println(Car.findOptionSet("Transmission"));
			System.out.println(Car.findOption("ABS", 2));			
			Car.updateOptionSetName("BodyKit", 1);
			Car.updateOptionName("Present Testing",3, 1);
			Car.updateOptionPrice(214, 2,2);
			System.out.println("---------------------------------------------");
			//Car.print();
			Automotive Car2 = new Automotive(5, "Focus Wagon ZTW", 18455);
			File.Serialize(Car);
			File.Serialize(Car2);
			File.Derialize("file.ser", Car2);
			Car2.print();
		}catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("No array index existed!");
		}
	}
}


//					TEST RUN #1


// 					TEST RUN #2