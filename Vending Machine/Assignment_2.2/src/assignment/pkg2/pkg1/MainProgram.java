/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment.pkg2.pkg1;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author lauriceniabuque
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         // Populate Candy Machine
        CandyVendingMachine CandyVendingMachine = new CandyVendingMachine();
        CandyVendingMachine.AddtoSlotA(new Candy("Kitkat", 30), 5);
        CandyVendingMachine.AddtoSlotB(new Candy("Cadbury", 40), 5);
        CandyVendingMachine.AddtoSlotC(new Candy("Twix", 10), 5);
        
        
         // Populate Soda Machine
        SodaVendingMachine SodaVendingMachine = new SodaVendingMachine();
        SodaVendingMachine.AddtoSlotA(new Soda("Coca-Cola", 60), 5);
        SodaVendingMachine.AddtoSlotB(new Soda("Sprite", 40), 5);
        SodaVendingMachine.AddtoSlotC(new Soda("Fanta", 10), 5);
        
        
        // Populate Miscellaneous Machine
        MiscellaneousVendingMachine MiscellaneousVendingMachine = new MiscellaneousVendingMachine();
        MiscellaneousVendingMachine.AddtoSlotA(new Candy("Kitkat", 30), 5);
        MiscellaneousVendingMachine.AddtoSlotB(new Soda("Coca-Cola", 30), 5);
        MiscellaneousVendingMachine.AddtoSlotC(new StarWarsCharacters("Darth Vader", 30), 5);
       
         
       
        Main_Menu(CandyVendingMachine,SodaVendingMachine,MiscellaneousVendingMachine  );
    }
    
    static void Main_Menu(CandyVendingMachine CandyMachine, SodaVendingMachine SodaMachine,MiscellaneousVendingMachine MiscellaneousMachine){
     
       while (true) {          
        //display options
        System.out.println("""
                           
                           Welcome! Choose your preferred Vending Machine or quit. 
                           1. Candy Vending Machine
                           2. Soda Vending Machine
                           3. Miscellaneous Vending Machine
                           4. Quit
                           """);
        //Get input of option
        Scanner Menu = new Scanner(System.in);
        int MenuChoice = Menu.nextInt();
    
        //what happens when a menu option is chosen
        switch (MenuChoice) {
            case 1:
               Second_Menu(CandyMachine);
                break;
            case 2:
               Second_Menu(SodaMachine);
                break;
            case 3:
               Second_Menu(MiscellaneousMachine);
                break;
            case 4:
                System.out.println("Looking forward to serving you in the future!");
                System.exit(0);
            default:
                System.out.println("You have chosen an invalid option. Please choose option 1 or 2.");
   
        }
        
       }
    }
    
   
    static <E> void Second_Menu(IVendingMachine <E> Machine){
     
       while (true) {
       
        //display options
        System.out.println("You chose a " + Machine.GetMachineInfo() + " Please choose from the following options on the menu:");
        Machine.DisplayContents();
        System.out.println("D: quit");
        
       
        //Get input of option
        Scanner Menu = new Scanner(System.in);
        char MenuChoice = Menu.next().charAt(0);          //source: http://www.beginwithjava.com/java/decisions/switch-statement.html
        
        //what happens when a menu option is chosen
        switch (MenuChoice) {
            case 'A':
                Machine.Transaction(Machine.GetSlotA());
                break;
            case 'B':
                Machine.Transaction(Machine.GetSlotB());
                break;
            case 'C':
                Machine.Transaction(Machine.GetSlotC());
                break;
            case 'D':
               System.out.println("Looking forward to serving you in the future!");
               System.exit(0);
            default:
                System.out.println("You have chosen an invalid option. Please choose option A, B, C or D.");
   
        }
        
       }
    }
    
   
}
    