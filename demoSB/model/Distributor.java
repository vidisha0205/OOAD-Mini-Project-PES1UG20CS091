package com.springboot.demo.demoSB.model;
import java.util.ArrayList;
import com.springboot.demo.demoSB.model.Product;
import com.springboot.demo.demoSB.model.Factory;
public class Distributor {
	public String Disname;
	static ArrayList<Product> DProdctList = Product.ProductList;
	private static Distributor DIS = null;

    private Distributor(String name) {
    	this.Disname=name;
    }
    public static Distributor getDistributor() //Called by Supplier in SendRawMaterials
    {
    	if(DIS==null)
    	{
    		DIS = new Distributor("PES");
    	}
    	else 
    	{
    		return DIS;
    	}
    	return DIS;
    }
    public ArrayList<Product> getDProductList()
    {
    	return DProdctList;
    }

    public int SendProduct(String prodname)
    {
    	for(Product r:DProdctList )
    	{
			String tempname =r.getName();
    		if(tempname.equals(prodname))
    		{
    			r.setquant(r.getquantity()-1);
    			System.out.println("THE PRODUCT IS AVAILABLE WITH THE DISTRIBUTOR AND AMOUNT TO BE PAID IS  " + r.getcost());
    			return 2;
    		}
    	}
    	System.out.println("THE PRODUCT IS NOT AVAILABLE WITH THE DISTRIBUTOR");
    	System.out.println("DISTRIBUTOR SENDING REQUEST TO FACTORY.");
    	Factory f = Factory.getFactory();
    	Product p = f.ManufactureProducts(prodname,10);
    	AbstractInvoice FR = f.receiveReceipt(p);
    	FR.printInvoice();
    	Product.ProductList.add(p);
    	DProdctList = Product.ProductList;
    	return 3;
    }
}
