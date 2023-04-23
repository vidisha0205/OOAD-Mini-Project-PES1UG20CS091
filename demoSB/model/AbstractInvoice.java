package com.springboot.demo.demoSB.model;
import java.util.Date;
abstract class AbstractInvoice 
{
    String Name;
    Date DateofArrival;
    int Amount;
    abstract void printInvoice();
};
