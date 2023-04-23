package com.springboot.demo.demoSB.model;
import java.util.ArrayList;



import com.springboot.demo.demoSB.model.Retailer;
import java.lang.Math;


public class Customer {
	
	private String CustomerName;
	
	private String Reviews;
	
	private String productname;
	
	public ArrayList<Retailer> r = Retailer.getList();
	public Retailer x;
	public void setReviews(String review)
	{
		this.Reviews = review;
	}
	public void setCustomerName(String cusname)
	{
		this.CustomerName = cusname;
	}
	public void setproductname(String prodname)
	{
		this.productname = prodname;
	}
	
	public String getCustomerName()
	{
		return this.CustomerName;
	}

	public String getproductname()
	{
		return this.productname;
	}
	public String getcustretname()
	{
		int max = r.size()-1;
		int min = 0;
		int ind = (int)Math.random() * (max - min + 1) + min ; 
		x = r.get(ind);
		String y = x.getretname();
		 return y;
	}
	public void RequestProductsfromRetailer( )
	{
		x = r.get(0);
		int y = x.RequestProductsfromDistributor(productname);
		if (y==1) {System.out.println("PRODUCT OBTAINED FORM RETAILER");}
		else if (y==2) {System.out.println("PRODUCT OBTAINED FORM DISTRIBUTOR");}
		else {}
	
	}
}
