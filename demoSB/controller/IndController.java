package com.springboot.demo.demoSB.controller;

import com.springboot.demo.demoSB.model.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.demo.demoSB.repo.Repository;

@Controller
public class IndController {
	@Autowired
	private Repository RMrepo;

	
	@GetMapping(value = "/")
	public String home(){
	   return "home";
	}

	
//	@PostMapping("/register")
//	public String AddBook(@ModelAttribute Item meal, Model model) {
//		meal.ToString();
//		
//		model.addAttribute("itemName",meal.getItemName());
//		model.addAttribute("Name",meal.getCustomerName());
//		model.addAttribute("price",meal.get_Total());
//		model.addAttribute("size",meal.getSize());
//		model.addAttribute("serve",meal.getDine());
//		Item m = userrepo.save(meal);
//		return "display";
//		
//	}
	@GetMapping("/error")
    public String error() {
        return "error";
    }
	@GetMapping("/display")
	public String SupplierLogin() {
	    return "display"; //display.html page name to open it
	}
	@GetMapping("/suppliersignup")
	public String SupplierSignUp() {
	    return "suppliersignup"; //suppliersignup.html page name to open it
	}
	
	@PostMapping("/supplier-login")
	public String SupplierLoginDone(@ModelAttribute Supplier supplier, Model model) {
		//Supplier.removeLast();
		int allow = Supplier.login(supplier.getSupplierName(), supplier.getSupplierPassword());
		if(allow == 1)
		{
			model.addAttribute("supplierName",supplier.getSupplierName());
			return "rawmaterial";
			
		}
		else if(allow==0)
		{
			return "error";
		}
	    return "home"; //home.html page name to open it
	}
	@PostMapping("/send-raw-materials")
	public String sendRawMaterials(@ModelAttribute RawMaterial rm, Model model){
		Supplier supplier = Supplier.getSupplier(rm.getsupplierName());
		RawMaterial r = RMrepo.save(rm);
		if(supplier!=null)
		{
			SupplierInvoice SI = supplier.SendRawMaterials(rm.getName(), rm.getQuantity());
			model.addAttribute("supplierName",supplier.getSupplierName());
			model.addAttribute("rawMaterial",rm.getName());
			model.addAttribute("quantity",rm.getQuantity());
			model.addAttribute("Date",SI.getDate());
			model.addAttribute("WHName",SI.getWHName());
			Warehouse WH = Warehouse.getWarehouse();
			model.addAttribute("Preproc",WH.preprocessingCost(rm)+"");
			return "showInvoice";
		}
		return "supplier-name-not-found";
		
	}
	@PostMapping("/supplier-signup")
	public String SupplierSignUpDone(@ModelAttribute Supplier supplier, Model model) {
		//supplier.to();
		Supplier.SupplierList.add(supplier);
		model.addAttribute("supplierName",supplier.getSupplierName());
		model.addAttribute("Password",supplier.getSupplierPassword());
		return "home";
	    
	}
	@GetMapping("/retailersignup")
	public String RetailerSignUp() {
		return "retailer-signup";
	    
	}
	@GetMapping("/retailerlogin")
	public String Retailerlogin() {
		return "retailer-login";
	    
	}
	@PostMapping("/retailer-signup")
	public String RetailerSignUp(@ModelAttribute Retailer retailer, Model model){
		ArrayList<Retailer> rm = Retailer.getList();
		rm.add(retailer);
		retailer.to();
		return "home";
	    
	}
	@PostMapping("/retailer-login") //to be done
	public String RetailerLoginpDone(@ModelAttribute Retailer retailer, Model model) {
		int allow = Retailer.login(retailer.getuserid(), retailer.getpassword());
		if(allow == 1)
		{
			System.out.println("Correct Password\n");
			return "retailerChoice";
			
		}
		else if(allow==0)
		{
			return "error";
		}
	    return "home"; //home.html page name to open it
	
	    
	}
	@GetMapping("/Order")
	public String Order() {
		return "order";
	}
	@PostMapping("/customer-order")
	public String CustomerOrder(@ModelAttribute Customer customer, Model model) {
		customer.RequestProductsfromRetailer();
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    String strDate = formatter.format(today);  
	    int cost = Product.getCost(customer.getproductname());
		model.addAttribute("retailerName",customer.getcustretname());
		model.addAttribute("CustomerName",customer.getCustomerName());
		model.addAttribute("product",customer.getproductname());
		model.addAttribute("cost",cost);
		model.addAttribute("date",strDate);
		RetailerInvoice RI = new RetailerInvoice(customer.getCustomerName(),customer.getproductname());
		RI.printInvoice();
		return "retailerinvoice";
		
	    
	}
	@GetMapping("/Review")
	public String CustomerOrder() {
		return "review-page";
	    
	}
	@PostMapping("/customer-review")
	public String PostReviews(@ModelAttribute Customer customer, Model model) 
	{
			return "thankyou";
	}
	@GetMapping("/quotations")
	public String Quotations(Model model)
	{
		OutsourcingManager OM;
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    String strDate = formatter.format(today);
		OM = OutsourcingManager.getOutsourcingManager();
		Warehouse WH = Warehouse.getWarehouse();
		double preProductionsCosts = WH.getpreprocessCost();
		Factory F = Factory.getFactory();
		int productionCosts = F.ProductionCost();
		int quote = OM.generateQuotations();
		model.addAttribute("preprod",preProductionsCosts);
		model.addAttribute("prod",productionCosts);
		model.addAttribute("quote",quote);
		model.addAttribute("date",strDate);
		return "quotations";
	}
	@GetMapping("/shipment")
	@ModelAttribute
	public String Shipment(Model model)
	{
		Distributor d = Distributor.getDistributor();
		ArrayList<Product> DProdctList = d.getDProductList();
		ArrayList<Product> PL = new ArrayList<Product>();
		for(Product p:DProdctList)
		{
			if(PL.contains(p)==false)
			{
				PL.add(p);
			}
		}
		model.addAttribute("products", PL);
		
		return "shipment";
	}
	
}

