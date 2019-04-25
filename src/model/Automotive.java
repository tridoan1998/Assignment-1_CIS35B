package model;
import java.io.*;

import model.OptionSet.*;

public class Automotive implements Serializable{
	//stop the serializable class does not declare
    private static final long serialVersionUID = 1L;
    
	private String name;
	private OptionSet opset[];
	private float baseprice;
	
	//don't need default constructor because no model should be zero
	
	//constructor to initialize object 
	public Automotive(int size, String n, float b)
	 {
		 this.opset = new OptionSet[size];
		 for(int i=0;i<opset.length;i++)
			 opset[i] = new OptionSet();  
		 this.name = n; 
		 this.baseprice = b;
	 }
	
	
	//Getter and Setter 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OptionSet[] getOpset() {
		return opset;
	}
	public void setOpset(OptionSet[] opset) {
		this.opset = opset;
	}
	public float getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(float baseprice) {
		this.baseprice = baseprice;
	}
	
	/*
	 * Function: to create Option array within each OptionSet array
	 * Parameter: int size of the Option array, and index of the OptionSet
	 * Return: void, an Option array created under the given OptionSet
	 */
	public void createOption(int size, int index)
	{
		//create empty Option class based on the size and add those option just created to the OptionSet class
		Option [] opt = new Option[size];
			for(int i = 0 ; i <opt.length; i++)
			{
				opt[i]= opset[index].new Option();
			}
			opset[index].setOpt(opt);
	}
	
	//Getter and Setter for OptionSet and Option
	public void setNameForOptionSet(String name, int index)
	{
		getOpset()[index].setName(name);
	}
	
	public String getNameForOptionSet(int index)
	{
		return getOpset()[index].getName();
	}
	
	public void setNameForOption(String name, int index2, int temp)
	{
		getOpset()[index2].getOpt()[temp].setName(name);
	}
	
	public String getNameForOption(int index1, int index2)
	{
		return getOpset()[index1].getOpt()[index2].getName();
	}
	
	public void setPriceForOption(float name, int index1, int index2)
	{
		getOpset()[index1].getOpt()[index2].setPrice(name);
	}
	
	public float getPriceForOption(int index1, int index2)
	{
		return getOpset()[index1].getOpt()[index2].getPrice();
	}
	
	
	/*
	 * Function: print out all the Option in every OptionSet in the Car object
	 * Parameter: none
	 * Return type: void  
	 */
	public void print()
	{
		System.out.println(getName() + "   $"+  getBaseprice());
		System.out.println("-------------------OPTION SET---------------------------------");
		for(int i = 0; i < getOpset().length;i++)
		{
			if(getOpset()[i] == null)
				continue;
			else 
				System.out.println(getNameForOptionSet(i));
		}
				
		System.out.println("-----------------OPTION--------------------------------");
		for(int i = 0; i < getOpset().length; i++)
		{
			if(getOpset()[i] == null)
			{
				continue;
			}
			else 
			{
				
				for(int j = 0; j < getOpset()[i].getOpt().length; j++)
				{
					if(getOpset()[i].getOpt()[j] == null)
					{
						continue;
					}
					else 
					{
						System.out.println(getNameForOption(i, j));
						System.out.println("$" + getPriceForOption(i, j));
					}
				}
				System.out.println();
			}
		}
	}
	
	
	/*
	 * Function: delete one OptionSet and set it to null
	 * Parameter: index of the OptionSet array
	 * Return: void
	 */
	public void deleteOptionSet(int index)
	{
		getOpset()[index] = null;
	}
	
	/*
	 * Function: delete one of the option under given OptionSet
	 * Parameter: index of OptionSet and Option want to delete
	 *  Return: void
	 */
	public void deleteOption(int index1, int index2)
	{
		getOpset()[index1].getOpt()[index2] = null;
	}
	
	
	/*
	 * Function: Find the OptionSet in the Car object
	 * Parameter: a String to search for it in the OptionSet
	 * Return: the index of the OptionSet array hold the String value 
	 */
	public int findOptionSet(String name)
	{
		for(int i = 0; i < opset.length; i++) 
		{
			if(opset[i] != null) {
				if(opset[i].getName().contentEquals(name)) 
				{
					return i+1;
				}
			}
		}
		return -1;
	}
	
	/*
	 *Function: find if one Option existed in the Option array 
	 *Parameter: a String of Option to search for and the index of the OptionSet array
	 *Return: the index of where that Option is at in the given OptionSet array   
	 */
	public int findOption(String name, int index)
	{	
		index--;
		OptionSet.Option [] options = opset[index].getOpt();
		for(int i = 0; i < options.length; i++) 
		{
			if(options[i] != null) 
			{
				if(options[i].getName().contentEquals(name)) 
				{
					return i+1;
				}
			}
		}
		return -1;
	}
	
	/*
	 * Function: update the OptionSet name to a new name
	 * Parameter: a String and an index 
	 * Return: void, name of the OptionSet should be updated
	 */
	public void updateOptionSetName(String newname, int index)
	{
		this.opset[index].setName(newname);
	}
	
	/*
	 * Function: update Option Name to a new one
	 * Parameter: a String for new name, index of the OptionSet and index of Option
	 * Return: void 
	 */
	public void updateOptionName(String name, int index1, int index2)
	{
		this.opset[index1].getOpt()[index2].setName(name);
	}
	
	/*
	 * Function: update Option Price with a new price 
	 * Parameter: float new price to update, index of OptionSet and index of Option 
	 * Return: void 
	 */
	public void updateOptionPrice(float newprice, int index1, int index2)
	{
		this.opset[index1].getOpt()[index2].setPrice(newprice);
	}
}