package com.springboot.demo.demoSB.model;
import java.util.*;
import com.springboot.demo.demoSB.model.AbstractInvoice;
import com.springboot.demo.demoSB.model.FactoryReciept;
import com.springboot.demo.demoSB.model.RetailerInvoice;
import com.springboot.demo.demoSB.model.SupplierInvoice;
import com.springboot.demo.demoSB.model.RawMaterial;
import com.springboot.demo.demoSB.model.Supplier;
import com.springboot.demo.demoSB.model.Warehouse;

public class OutsourcingManager
{
	int postProductionCosts = 0;
	private static OutsourcingManager OMinstance;
	private OutsourcingManager()
	{
		
	}
	public static OutsourcingManager getOutsourcingManager()
	{
		if(OMinstance==null)
		{
			OMinstance = new OutsourcingManager();
		}
		else 
		{
			return OMinstance;
		}
		return OMinstance;
	}
	public int generateQuotations()
	{
		Warehouse WH = Warehouse.getWarehouse();
		double preProductionsCosts = WH.getpreprocessCost();
		Factory F = Factory.getFactory();
		int productionCosts = F.ProductionCost();
		int pPC = postProductionCosts(preProductionsCosts,productionCosts);
		return pPC;
		
	}
	private int postProductionCosts(double preProductionsCosts, int productionCosts)
	{
		if(productionCosts==0)
		{
			return (int)preProductionsCosts;
		}
		else 
		{
			postProductionCosts = (int) (preProductionsCosts*10 - productionCosts);
		}
		return postProductionCosts;
	}
	public void sendRawMaterialsToFactory()
	{
		ArrayList<RawMaterial> f= Factory.getRawMaterials();
		ArrayList<RawMaterial> wh = Warehouse.getRawMaterials();
		f = wh;
		Factory.setRawMaterials(f);
		System.out.println("Raw Materials sent from Warehouse to Factory.");
		
		
		
	}
	
}