package com.springboot.demo.demoSB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class RawMaterial {

	private String supplierName;
	

    private String Name;

    private int Quantity;

    public RawMaterial() {
       
    }
    public void setsupplierName(String name)
    {
    	this.supplierName = name;
    }
    @Column
    public String getsupplierName()
    {
    	return this.supplierName;
    }
    
    public void setName(String name) //called by Supplier
    {
    	 this.Name = name;
    }
	
    public void setQuantity(int quantity) //called by Supplier
    {
    	this.Quantity = quantity;
    }
	@Id
	@Column
    public String getName() {
        return Name;
    }
	@Column
    public int getQuantity() {
        return Quantity;
    }
}