package model;

import java.io.Serializable;

public class OptionSet implements Serializable{
	//stop the serializable class does not declare
    private static final long serialVersionUID = 1L;
    private Option opt [];
	private String name;
	  
	//default constructor
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
	  
	  public class Option implements Serializable
	  {  
		  //stop the serializable class does not declare
	      private static final long serialVersionUID = 1L;
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
		  
		  //Getter and Setter for Option
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
	  }

	  //Getter and setter for OptionSet
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
