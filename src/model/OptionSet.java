package model;

import util.*;


public class OptionSet {
	private Option opt [];
	private String name;
	  
	
	  protected OptionSet()
	  {
		  
	  }
	  
	  protected OptionSet(String n, int size)  
	  {
		  opt = new Option[size];
		  for(int i=0; i < opt.length; i++)    
			  opt[i] = new Option();
				  
		  name = n;
	  }
	  
	  public class Option 
	  {  
		  private String name;
		  private float price;
		  
		  
		  protected Option()
		  {
			  
		  }
		  protected Option(String n, float p)
		  {
			  name = n;
			  price = p;
		  }

		  protected String getName() {
			  return name;
		  }

		  protected void setName(String name) {
			this.name = name;
		}

		  protected float getPrice() {
			return price;
		}

		  protected void setPrice(float price) {
			this.price = price;
		}
 
		  protected void print()
		{
			
		}
	  }


	  protected Option [] getOpt() {
		  return this.opt;
	  }
	  
	  protected void setOpt(Option[] opt) {
		this.opt = opt;
	}

	  protected String getName() {
		return name;
	}

	  protected void setName(String name) {
		this.name = name;
	}
	


	  
	  
}