package com.springboot.demo.demoSB.model;
import java.util.Date;
import java.text.SimpleDateFormat;  
import com.springboot.demo.demoSB.model.AbstractInvoice;
import com.springboot.demo.demoSB.model.RawMaterial;
public class SupplierInvoice extends AbstractInvoice
{
    String supplierName;
    private RawMaterial RM;
    private Date DateofArrival; 
    private String WHName = Warehouse.name;
    SupplierInvoice(String SName, RawMaterial RM)
    {
        this.supplierName = SName;
        this.RM = RM;
        DateofArrival = new Date();
    }
    public String getWHName()
    {
    	return WHName;
    }
    public String getDate()
    {
    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
        String strDate = formatter.format(DateofArrival);  
    	return strDate;
    }
    void printInvoice()
    {
        System.out.println("Invoice for Supplier:\n");
        System.out.println("Material Name\tDate of Arrival\tAmount\tSupplier Name\n");
        System.out.println(RM.getName()+"\t"+DateofArrival+"\t"+RM.getQuantity()+"\t"+supplierName);
    }
};