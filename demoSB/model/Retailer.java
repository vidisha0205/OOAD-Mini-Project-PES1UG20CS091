package com.springboot.demo.demoSB.model;
import com.springboot.demo.demoSB.model.Product ;
import com.springboot.demo.demoSB.model.Distributor;
import java.util.ArrayList;
public class Retailer 
{
	private static ArrayList<Retailer> RetailerList = null;
	private String retname;
	private String licnum;
	private String userid;
	private String password;
	private String phoneno;
	static ArrayList<Product> Products = new ArrayList<Product>();
	static Distributor obj = Distributor.getDistributor();
	static ArrayList<Product> ProductsAvailable = obj.getDProductList();
	public static ArrayList<Retailer> getList()
	{
		if(RetailerList==null)
		{
			RetailerList = new ArrayList<Retailer>();
		}
		else 
		{
			return RetailerList;
		}
		return RetailerList;
	}
	
	public String getretname()
	{
		return this.retname;
	}
	public String getuserid()
	{	
		return this.userid;	
	}
//	public String getlicnum()
//	{
//		return this.licnum;
//	}
	public String getpassword()
	{
		return this.password;
	}
//	public String getphoneno()
//	{
//		return this.phoneno;
//	}
	public void setretname(String rname)
	{
		this.retname=rname;
		
	}
	public void setuserid(String uid)
	{
		this.userid=uid;
		
	}
	public void setlicnum(String lnum)
	{
		this.licnum=lnum;
		
	}
	public void setpassword(String password)
	{
		this.password=password;
		
	}
	public void setphoneno(String phno)
	{
		this.phoneno=phno;
		
	}
	
	public static int login(String userid, String pword)
    {
    	for(Retailer r: RetailerList)
    	{
    		System.out.println(r.userid);
    		if(r.userid.equals(userid))
    		{
    			if(r.password.equals(pword))
    			{
    				return 1;
    			}
    			else
    			{
    				return 0;
    			}
    		}
    	}
    	return 1;
    }
	public int RequestProductsfromDistributor(String prodname)
	{
		for(Product r: ProductsAvailable)
    	{
			String tempname =r.getName();
    		if(tempname.equals(prodname))
    		{
    			r.setquant(r.getquantity()-1);
    			System.out.println("THE PRODUCT IS AVAILABLE WITH THE RETAILER AND AMOUNT TO BE PAID IS  " + r.getcost());
    			return 1;
    		}
    	}
    	int n = obj.SendProduct(prodname);	
    	return n;
	}
	public void to()
	{
		System.out.println("Here2: Retailer details: "+this.getuserid()+" "+this.getpassword()+" \n");
	}
	
}
