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
public class MiscellaneousVendingMachine<E extends IVendingItems> implements IVendingMachine<E> {                   //source1 : https://stackoverflow.com/questions/18769429/java-interface-generic-type   //source2: https://stackoverflow.com/questions/2770264/what-is-the-difference-between-e-extends-number-and-number
    
    //Slots 
    protected Queue<E> SlotA = new LinkedList();
    protected Queue<E> SlotB= new LinkedList();
    protected Queue<E> SlotC= new LinkedList();
  
    //Getters
    @Override
    public Queue<E> GetSlotA(){
         return SlotA;
    }
    
    @Override
    public Queue<E> GetSlotB() {
         return SlotB;
    }

    @Override
    public Queue<E> GetSlotC() {
          return SlotC;
    }
    
    // A queue version of setters :)
    public void AddtoSlotA(E item, int numberOfItemsToAdd ) {
        List<E> itemsToAdd = new ArrayList<>(Collections.nCopies(numberOfItemsToAdd, item));   //source 1: https://www.benchresources.net/creating-arraylist-using-ncopies-method-of-collections-class-in-java/  //source2:https://www.javatpoint.com/java-concurrentlinkedqueue-addall-method
        SlotA.addAll(itemsToAdd);
    }
    
    public void AddtoSlotB(E item, int numberOfItemsToAdd) {
        List<E> itemsToAdd = new ArrayList<>(Collections.nCopies(numberOfItemsToAdd, item));   
        SlotB.addAll(itemsToAdd);
    }
    public void AddtoSlotC(E item, int numberOfItemsToAdd) {
        List<E> itemsToAdd = new ArrayList<>(Collections.nCopies(numberOfItemsToAdd, item));   
        SlotC.addAll(itemsToAdd);
    }
    
    @Override
    public void Transaction(Queue<E> items) {
       TakeMoney(0.0, items);
       System.out.println("Transaction Completed. You have purchased a " + items.element().GetName() + " for the amount of " + items.element().GetPrice() + " USD"); 
       System.out.println("You may continue shopping or choose to quit. ");
       System.out.println("--------------------------------------------------------------------------------- ");
 }

    @Override
    public void TakeMoney(double money, Queue<E> items) {
       System.out.println("Please insert the payment.");
       Scanner input = new Scanner(System.in);
       double Money = input.nextDouble()+ money;
     
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
    public void ReturnMoney(double amount, Queue<E> items) {
      double  change = amount - items.element().GetPrice();
        System.out.println(String.format("""
                           Processing change...You inserted %1$s USD
                           Your change is %2$s USD
        """, amount, change));                               // String interpolation: https://www.geeksforgeeks.org/java-program-to-illustrate-string-interpolation/    
        VendItem(items);
    }
    

    @Override
    public E VendItem(Queue<E> items) {
         E item = items.remove();
         return item;
 }

    @Override
    public void DisplayContents() {                                 //implements string interpolation
         System.out.println(String.format("""
           A: %1$s (%2$s) - %3$s
           B: %4$s (%5$s) - %6$s
           C: %7$s (%8$s) - %9$s""", SlotA.element().GetName(), SlotA.size(), SlotA.element().GetPrice(), SlotB.element().GetName(),SlotB.size(), SlotB.element().GetPrice(), SlotC.element().GetName(), SlotB.size(),SlotC.element().GetPrice() ));       
 } 
    @Override
    public String GetMachineInfo() {
       String  MachineType = "Miscellaneous Vendine Machine.";
       return MachineType;
       
    }


    
    
}
