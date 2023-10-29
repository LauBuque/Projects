/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.pkg2.pkg1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author lauriceniabuque
 */
public class CandyVendingMachine implements IVendingMachine<Candy> { 
    
     //Slots 
    protected Queue<Candy> SlotA= new LinkedList();
    protected Queue<Candy> SlotB= new LinkedList();
    protected Queue<Candy> SlotC= new LinkedList();
    
     //Getters
    @Override
    public Queue<Candy> GetSlotA(){
        return SlotA;
    }
    @Override
    public Queue<Candy> GetSlotB(){
        return SlotB;
    }
    @Override
    public Queue<Candy> GetSlotC(){
        return SlotC;
    }
    
     // A queue version of setters :)
    public void AddtoSlotA(Candy candy, int numberOfItemsToAdd ) {
        List<Candy> itemsToAdd = new ArrayList<>(Collections.nCopies(numberOfItemsToAdd, candy));   //source 1: https://www.benchresources.net/creating-arraylist-using-ncopies-method-of-collections-class-in-java/  //source2:https://www.javatpoint.com/java-concurrentlinkedqueue-addall-method
        SlotA.addAll(itemsToAdd);
    }
    
    public void AddtoSlotB(Candy candy, int numberOfItemsToAdd) {
        List<Candy> itemsToAdd = new ArrayList<>(Collections.nCopies(numberOfItemsToAdd, candy));   //source 1: https://www.benchresources.net/creating-arraylist-using-ncopies-method-of-collections-class-in-java/  //source2:https://www.javatpoint.com/java-concurrentlinkedqueue-addall-method
        SlotB.addAll(itemsToAdd);
    }
    public void AddtoSlotC(Candy candy, int numberOfItemsToAdd) {
        List<Candy> itemsToAdd = new ArrayList<>(Collections.nCopies(numberOfItemsToAdd, candy));   //source 1: https://www.benchresources.net/creating-arraylist-using-ncopies-method-of-collections-class-in-java/  //source2:https://www.javatpoint.com/java-concurrentlinkedqueue-addall-method
        SlotC.addAll(itemsToAdd);
    }

@Override
    public void TakeMoney(double money,Queue<Candy> items) {
     System.out.println("Please insert the payment.");
     Scanner input = new Scanner(System.in);
     double Money = input.nextDouble()+money;
     
     //if money entered is more than the price, return money
    if(Money >= items.element().GetPrice()){
           ReturnMoney(Money, items); }
    else {                                   //if less, ask for more or give option to quit
        System.out.println("""
            The Funds you inserted are insufficient to complete the transaction. Would you like to :
                1. Add more funds?
                2. Cancel the transaction and quit? """ );
      int Choice = input.nextInt();
       switch(Choice) {
            case 1:
                TakeMoney(Money, items); 
                break;
            case 2:
                System.out.println("Cancelled request. Machine returning money...");  
                System.exit(0);
            default:
                System.out.println("You have chosen an invalid option. Please choose option 1 or 2.");  
        }          
    }                
 }

    @Override
    //return extra money
    public void ReturnMoney(double amount, Queue<Candy> items) {
        double  change = amount - items.element().price;
        System.out.println(String.format("""
                           Processing change...You inserted %1$s USD
                           Your change is %2$s USD
        """, amount, change));                               // String interpolation: https://www.geeksforgeeks.org/java-program-to-illustrate-string-interpolation/    
        VendItem(items);
    }

   @Override 
   //spit item
    public Candy VendItem(Queue<Candy> items) {
     Candy item = items.remove();
     return item;
 }


    @Override
    //display items in the vending machine
    public void DisplayContents() {   
  
            System.out.println(String.format("""
           A: %1$s (%2$s) - %3$s
           B: %4$s (%5$s) - %6$s
           C: %7$s (%8$s) - %9$s""", SlotA.element().GetName(), SlotA.size(), SlotA.element().GetPrice(), SlotB.element().GetName(),SlotB.size(), SlotB.element().GetPrice(), SlotC.element().GetName(), SlotB.size(),SlotC.element().GetPrice() ));       
 }

    @Override
    //performs transaction and confirms if successful
    public void Transaction(Queue<Candy> items) {   
       TakeMoney(0.0, items);
       System.out.println("Transaction Completed. You have purchased a " + items.element().GetName() + " for the amount of " + items.element().GetPrice() + " USD"); 
       System.out.println("You may continue shopping or choose to quit. ");
       System.out.println("--------------------------------------------------------------------------------- ");
 }
     @Override
    public String GetMachineInfo() {
       String  MachineType = "Candy Vendine Machine.";
       return MachineType;
       
    }
    //Constructor
    CandyVendingMachine(){};
 }
