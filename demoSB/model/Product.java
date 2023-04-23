package com.springboot.demo.demoSB.model;
import java.util.ArrayList;


public class Product {

	private String Name;


	private int quantity;

	private int cost;
	public static ArrayList<Product> ProductList = new ArrayList<Product>();
	public String getName()
	{
		return Name;
	}
	public int getcost()
	{
		return cost;
	}
	public int getquantity()
	{
		return quantity;
	}
	public void setname(String name)
	{
		 this.Name=name;
		 //ProductList.add(this);
	}
	public void setcost(int cost)
	{
		this.cost=cost;
		ProductList.add(this);
		
	}public void setquant(int quant)
	{
		this.quantity=quant;
		
	}
	public static int getCost(String k)
	{
		for(Product p:ProductList)
		{
			if(p.Name.equals(k))
			{
				return p.cost;
			}
		}
		return 0;
	}
	
}
