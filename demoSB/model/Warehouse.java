package com.springboot.demo.demoSB.model;
import java.util.Date;
import java.util.ArrayList;
import com.springboot.demo.demoSB.model.RawMaterial;
import com.springboot.demo.demoSB.model.Supplier;


public class Warehouse {
    private ArrayList<Supplier> supplierList;
    private static ArrayList<RawMaterial> rawMaterialList;
    private double preprocessedCosts = 0;
    private static Warehouse WH = null;
    public static String name = "DAVA Warehouse";
    private Warehouse() {
       supplierList = new ArrayList<>();
       rawMaterialList = new ArrayList<>();
    }
    public static ArrayList<RawMaterial> getRawMaterials()
    {
    	return rawMaterialList;
    }
    public static Warehouse getWarehouse() //Called by Supplier in SendRawMaterials
    {
    	if(WH==null)
    	{
    		WH = new Warehouse();
    	}
    	else 
    	{
    		return WH;
    	}
    	return WH;
    }

    public void addSupplier(Supplier supplier)  //Called by WH in SendRawMaterials
    
    {
        supplierList.add(supplier);
    }

    public void addRawMaterial(RawMaterial rawMaterial) { //Called by WH in SendRawMaterials
        rawMaterialList.add(rawMaterial);
    }

    public SupplierInvoice generateInvoice() { //Called by WH in SendRawMaterials
    	Supplier s = supplierList.get(supplierList.size() - 1);
    	RawMaterial rm = rawMaterialList.get(rawMaterialList.size()-1);
        SupplierInvoice supplierInvoice = new SupplierInvoice(s.getSupplierName(), rm);
        return supplierInvoice;
    }

    public double preprocessingCost(RawMaterial rawMaterial) {
    	preprocessedCosts = preprocessedCosts + rawMaterial.getQuantity() * 100 + 23*19 +59*23;
        return rawMaterial.getQuantity() * 100 + 23*19 +59*23;
    }
    public double getpreprocessCost()
    {
    	return preprocessedCosts;
    }
}

