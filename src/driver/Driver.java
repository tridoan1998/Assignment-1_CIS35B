/*
Name: Tri Doan
Course: 35B
Assignment: Lab 1
Description: In this project we will build a Car Configuration Application. 
In this unit  we will develop a “reference” base object model, 
read a text file to build the reference base object model and archive it using Serialization.
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
			Car.print();
			Car.deleteOptionSet(1);
			Car.deleteOption(0,2);
			System.out.println(Car.findOptionSet("Brakes/TractionControl"));
			System.out.println(Car.findOption("Standard", 3));			
			Car.updateOptionSetName("Root Top", 4);
			Car.updateOptionName("Carbon Fiber",4, 0);
			Car.updateOptionPrice(524, 3,1);
			System.out.println("---------------------------------------------");
			File.Serialize(Car);
			File.Deserialize("file.ser", Car);
			Car.print();
		}catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("No array index existed!");
		}
	}
}


//					TEST RUN #1
/*
Focus Wagon ZTW   $18455.0
-------------------OPTION SET---------------------------------
Color
Transmission
Brakes/TractionControl
Side Impact Air Bags
Power Moonroof
-----------------OPTION--------------------------------
Fort Knox Gold Clearcoat Metallic
$0.0
Liquid Grey Clearcoat Metallic
$0.0
Infra-Red Clearcoat
$0.0
Grabber Green ClearcoatMetallic
$0.0
Sangria Red Clearcoat Metallic
$0.0
French Blue Clearcoat Metallic
$0.0
Twilight Blue Clearcoat Metallic
$0.0
CD Silver ClearcoatMetallic
$0.0
Pitch Black Clearcoat
$0.0
Cloud 9 White Clearcoat
$0.0

automatic
$0.0
manual
$-815.0

Standard
$0.0
ABS
$400.0
ABS with Advance Trac
$1625.0

present
$350.0
not present
$0.0

present
$595.0
not present
$0.0

2
-1
---------------------------------------------
Object has been deserialized 
Focus Wagon ZTW   $18455.0
-------------------OPTION SET---------------------------------
BodyKit
Brakes/TractionControl
Side Impact Air Bags
Power Moonroof
-----------------OPTION--------------------------------
manual
$-815.0

Standard
$0.0
ABS
$400.0
ABS with Advance Trac
$214.0

present
$350.0
Air Extension
$0.0

present
$595.0
not present
$0.0
 */


// 					TEST RUN #2
/*
Focus Wagon ZTW   $18455.0
-------------------OPTION SET---------------------------------
Color
Transmission
Brakes/TractionControl
Side Impact Air Bags
Power Moonroof
-----------------OPTION--------------------------------
Fort Knox Gold Clearcoat Metallic
$0.0
Liquid Grey Clearcoat Metallic
$0.0
Infra-Red Clearcoat
$0.0
Grabber Green ClearcoatMetallic
$0.0
Sangria Red Clearcoat Metallic
$0.0
French Blue Clearcoat Metallic
$0.0
Twilight Blue Clearcoat Metallic
$0.0
CD Silver ClearcoatMetallic
$0.0
Pitch Black Clearcoat
$0.0
Cloud 9 White Clearcoat
$0.0

automatic
$0.0
manual
$-815.0

Standard
$0.0
ABS
$400.0
ABS with Advance Trac
$1625.0

present
$350.0
not present
$0.0

present
$595.0
not present
$0.0

3
1
---------------------------------------------
Object has been deserialized 
Focus Wagon ZTW   $18455.0
-------------------OPTION SET---------------------------------
Color
Brakes/TractionControl
Side Impact Air Bags
Root Top
-----------------OPTION--------------------------------
Fort Knox Gold Clearcoat Metallic
$0.0
Liquid Grey Clearcoat Metallic
$0.0
Grabber Green ClearcoatMetallic
$0.0
Sangria Red Clearcoat Metallic
$0.0
French Blue Clearcoat Metallic
$0.0
Twilight Blue Clearcoat Metallic
$0.0
CD Silver ClearcoatMetallic
$0.0
Pitch Black Clearcoat
$0.0
Cloud 9 White Clearcoat
$0.0

Standard
$0.0
ABS
$400.0
ABS with Advance Trac
$1625.0

present
$350.0
not present
$524.0

Carbon Fiber
$595.0
not present
$0.0
 */