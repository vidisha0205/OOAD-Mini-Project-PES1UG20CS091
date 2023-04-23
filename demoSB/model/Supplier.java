package com.springboot.demo.demoSB.model;
import java.util.ArrayList;
import com.springboot.demo.demoSB.model.RawMaterial;
import com.springboot.demo.demoSB.model.SupplierInvoice;
import com.springboot.demo.demoSB.model.Warehouse;
public class Supplier{
    private String supplierName;
    private String Password;
    public static ArrayList<Supplier> SupplierList = new ArrayList<Supplier>();

    public String getSupplierName() {
        return this.supplierName;
    }
    public String getSupplierPassword() {
        return this.Password;
    }
    

    public void setsupplierName(String Name) {
        this.supplierName = Name;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public static Supplier getSupplier(String Name)
    {
    	for(Supplier s: SupplierList)
    	{
    		if(s.supplierName.equals(Name))
    		{
    			return s;
    		}
    	}
    	return null;
    }
//    public static void removeLast()
//    {
//    	SupplierList.remove(SupplierList.size()-1);
//    }
    
//    public void to()
//    {
//    	System.out.println(this.supplierName+" "+this.Password);
//    }
    public static int login(String name, String pword)
    {
    	for(Supplier s: SupplierList)
    	{
    		if(s.supplierName.equals(name))
    		{
    			if(s.Password.equals(pword)) //correct password
    			{
    				return 1;
    			}
    			else //incorrect password
    			{
    				return 0;
    			}
    		}
    	}
    	return -1; //supplier not found
    }
    public SupplierInvoice SendRawMaterials(String name, int quantity)
    {
    	RawMaterial rm = new RawMaterial();
    	rm.setName(name);
    	rm.setQuantity(quantity);
    	Warehouse WH = Warehouse.getWarehouse();
    	WH.addSupplier(this);
    	WH.addRawMaterial(rm);
    	SupplierInvoice  SI = WH.generateInvoice();
    	System.out.println("Raw Materials sent");
    	return SI;
    	
    	
    }
    
}
