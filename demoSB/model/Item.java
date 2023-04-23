package com.springboot.demo.demoSB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Item {
	@Id
	@Column
	private String itemName;
	@Column
	private String CustomerName;
	@Column
	private String size;
	@Column
	private int price;
	@Column
	private String dining;
	@Column
	private int additional_costs;
	@Column
	private int Total_Cost;
	
	public void setItemName(String name)
	{
		this.itemName = name;
	}
	public void setCustomerName(String name)
	{
		this.CustomerName = name;
	}
	public void setPrice(int price)
	{
		this.price = price;
		this.setAdditional();
		this.set_Total();
	}
	public void setSize(String s)
	{
		this.size = s;
	}
	public void setDining(String dine)
	{
		this.dining = dine;
	}
	public void setAdditional()
	{
		if(this.dining.equals("Dining In"))
		{
			this.additional_costs = 100;
		}
		else
		{
			this.additional_costs = 120;
		}
	}
	
	public void set_Total()
	{
		this.Total_Cost = this.additional_costs + this.price;
	}
	
	public int get_Total()
	{
		return this.Total_Cost;
	}
	public String getItemName()
	{
		return this.itemName;
	}
	public String getCustomerName()
	{
		return this.CustomerName;
	}
	public int getPrice()
	{
		if(this.dining.equals("Dining In"))
		{
			return this.price+100;
		}
		return this.price+120;
	}
	public String getSize()
	{
		return this.size;
	}
	public String getDine()
	{
		return this.dining;
	}
	public void ToString()
	{
		System.out.println("Item "+this.itemName+" ordred by "+this.CustomerName+" costs "+ this.price+"/- \n");
	}
	
}
