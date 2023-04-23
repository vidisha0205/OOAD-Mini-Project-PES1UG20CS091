package com.springboot.demo.demoSB.model;
import java.util.Date;
import com.springboot.demo.demoSB.model.AbstractInvoice;
public class RetailerInvoice extends AbstractInvoice 
{
    String CustomerName;
    String Product;

    public RetailerInvoice(String CName, String Pname)
    {
        this.CustomerName = CName;
        this.Product = Pname;
    }
    public void printInvoice()
    {
    	Date DateofArrival = new Date();
        System.out.println("Invoice for Customer:\n");
        System.out.println("Date of Arrival\t\tCustomer Name\tCustomer's Product\n");
        System.out.println(DateofArrival+"\t"+"\t"+CustomerName+"\t"+Product);
    }
}
