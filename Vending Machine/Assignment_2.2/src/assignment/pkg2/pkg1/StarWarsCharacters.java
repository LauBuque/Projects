/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.pkg2.pkg1;

/**
 *
 * @author lauriceniabuque
 */
public class StarWarsCharacters implements Cloneable, IVendingItems{
   
    //Properties  
    protected String name="";
    protected double price;
    
    // Getters and Setters
    public void SetName(String name) {
        this.name = name;
    }
    @Override
    public String GetName() {
       return name;    }
    
    public void SetPrice(double price) {
        this.price = price;
    }
    @Override
    public double GetPrice() {
        return price;
    }
    
/**
 * Constructors
 */
    StarWarsCharacters(){} //default constructor
    StarWarsCharacters(String name, int price){  
    SetName(name);
    SetPrice(price);  
    }
    
   
   /**
    * 
    * @return
    * @throws CloneNotSupportedException 
    */
    public StarWarsCharacters clone() throws CloneNotSupportedException{
        return (StarWarsCharacters) super.clone();
    }    
    
}
