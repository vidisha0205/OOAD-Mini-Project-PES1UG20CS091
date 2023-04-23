package com.springboot.demo.demoSB.model;
import java.util.*;
import com.springboot.demo.demoSB.model.AbstractInvoice;
import com.springboot.demo.demoSB.model.FactoryReciept;
import com.springboot.demo.demoSB.model.RetailerInvoice;
import com.springboot.demo.demoSB.model.SupplierInvoice;
import com.springboot.demo.demoSB.model.RawMaterial;
import com.springboot.demo.demoSB.model.Supplier;
import com.springboot.demo.demoSB.model.Warehouse;

public class Factory {
	public static String FactoryName="SB Factory";
	public static String Faddress= "Banashankari,Bengaluru,560085";
	private static ArrayList<RawMaterial> RM = new ArrayList<RawMaterial>();
	private static Factory OneFactory ;
	private Factory()
	{
		
	}
	 public static ArrayList<RawMaterial> getRawMaterials()
	    {
	    	return RM;
	    }
	public static Factory getFactory() 
	{
		if(OneFactory==null)
		{
			OneFactory = new Factory();
		}
		else 
		{
			return OneFactory;
		}
		return OneFactory;
	}
	
	public int ProductionCost(){
        int sum = 0;
        for(RawMaterial rm : RM)
        {
        	sum = sum + rm.getQuantity()*23*500/16 + 1280;
        }
        RM = new ArrayList<RawMaterial>();
        return sum;
        
    }

    public void receiveRawMaterials() {
    	OutsourcingManager OM = OutsourcingManager.getOutsourcingManager();
    	OM.sendRawMaterialsToFactory();
        
    }
    public static void setRawMaterials(ArrayList<RawMaterial> rm)
    {
    	RM = rm;
    }

    public  AbstractInvoice receiveReceipt(Product p) {
        AbstractInvoice inv = new FactoryReciept(FactoryName, Faddress, p);
        return inv;
    }
    
    public Product ManufactureProducts(String product,int quantity) {
    	this.receiveRawMaterials();
        Product p1 = new Product();
        p1.setname(product);
        p1.setquant(quantity);
        if(product.equals("Drawer"))
        {
        	p1.setcost(5500);
        }
        else if(product.equals("Table"))
        {
        	p1.setcost(8000);
        }
        else if(product.equals("Chair"))
        {
        	p1.setcost(6500);
        }
        else if(product.equals("Cupboard"))
        {
        	p1.setcost(15000);
        }
        else if(product.equals("Sofa"))
        {
        	p1.setcost(50000);
        }
        else if(product.equals("Mattress"))
        {
        	p1.setcost(52100);
        }
        else if(product.equals("Pillow"))
        {
        	p1.setcost(900);
        }
        return p1;
    }
    
}
