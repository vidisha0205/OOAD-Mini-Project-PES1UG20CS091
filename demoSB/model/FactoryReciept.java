package com.springboot.demo.demoSB.model;
import java.util.Date;
import com.springboot.demo.demoSB.model.AbstractInvoice;
import com.springboot.demo.demoSB.model.Product;
class FactoryReciept extends AbstractInvoice 
{
    String FactoryName;
    String FactoryAddress;
    Product Prod;
    
    FactoryReciept(String FName,String FAddress,Product p)
    {
        this.FactoryName = FName;
        this.FactoryAddress = FAddress;
        this.Prod = p;
    }
    void printInvoice()
    {
    	Date DateofManufacture = new Date();
        System.out.println("Invoice from Factory:\n");
        System.out.println("Product Name\tDate of Arrival\tAmount\tFactory Name\tFactory Address\n");
        System.out.println(Prod.getName()+"\t"+DateofManufacture+"\t"+Prod.getquantity()+"\t"+FactoryName+"\t"+FactoryAddress);
    }
   
}