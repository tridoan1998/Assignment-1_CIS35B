package model;
import java.io.*;
import java.util.*;

import driver.*;
import util.*;
import model.OptionSet.Option;

//creation of a component - group of classes with access from a single outermost object - in this case Automotive 



//all properties will be private
//methods in Option and OptionSet will be protected.

public class Automotive {
	private String name;
	private OptionSet opset[];  //color 
	private float baseprice;
	
	//don't need default constructor because no model should be zero
	
	//constructor to initinize object 
	public Automotive(int size, String n, float b)
	 {
		 this.opset = new OptionSet[size];
		 for(int i=0;i<opset.length;i++)
			 opset[i] = new OptionSet();  
		 this.name = n; 
		 this.baseprice = b;
	 }
	
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
	
	public void createOption(int size, int index)
	{
		//create empty Option class based on the size and add those option just created to the OptionSet class
		Option [] opt = new Option[size];
			for(int i = 0 ; i <opt.length; i++)
			{
				opt[i]= opset[index].new Option();
			}
			
			opset[index].setOpt(opt);

	//still could not create the right length for each option in optionset		
		//for(int i = 0; i < opset.length;i++)
			//opset[i].setOpt(opt);
	}
	
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
	
	
	public void deleteOptionSet(int index)
	{
		getOpset()[index] = null;
	}
	
	public void deleteOption(int index1, int index2)
	{
		getOpset()[index1].getOpt()[index2] = null;
	}
	
	
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
	
	public int findOption(String name, int index)
	{	
		OptionSet.Option [] options = opset[index].getOpt();
		for(int i = 0; i < options.length; i++) {
			if(options[i] != null) {
				if(options[i].getName().contentEquals(name)) {
					return i+1;
				}
			}
		}
		return -1;
	}
	
	public void updateOptionSetName(String newname, int index)
	{
		this.opset[index].setName(newname);
	}
	public void updateOptionName(String name, int index1, int index2)
	{
		this.opset[index1].getOpt()[index2].setName(name);
	}
	public void updateOptionPrice(float newprice, int index1, int index2)
	{
		this.opset[index1].getOpt()[index2].setPrice(newprice);
	}
}