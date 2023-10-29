/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.pkg2.pkg1;


import java.util.Queue;

/**
 *
 * @author lauriceniabuque
 */
public interface IVendingMachine<E>{
    
    //Performs the transaction that happens from the collection of the money until vending item. Confirms if successful. 
    void Transaction(Queue<E> items);
    
    // Accepts the amount of money from the user
    void TakeMoney(double amount, Queue<E> items);
    
    // Returns the amount of money to the user
    void ReturnMoney(double amount, Queue<E> items);
    
    // Spits out an item based on the vending slot chosen by the user
    E VendItem(Queue<E> items);
    
    // Displays what kind of vending machine it is
    String GetMachineInfo();
    
    // Shows the item name and price for each Slot of the machine
    void DisplayContents();
    
    // Get slots 
    Queue<E> GetSlotA();
    Queue<E> GetSlotB();
    Queue<E> GetSlotC();
    
    
}
