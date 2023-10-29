/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.pkg2.pkg1;

/**
 *
 * @author lauriceniabuque
 */
public class Soda implements Cloneable, IVendingItems{
    
    //properties
    protected String name= "";
    protected double price; 

    //getters and setters
    public void SetName(String name) {
        this.name = name;
    }
    @Override
    public String GetName(){
    return name;}
    
    public void SetPrice(double price) {
        this.price = price;
    }
    @Override
    public double GetPrice(){
       return price; 
    }
    
    //Constructors
    public Soda(){}
    public Soda(String name, double price) {
        SetName(name);
        SetPrice(price);
   
        }
    
   /**
    * 
    * @return
    * @throws CloneNotSupportedException 
    */
    public Soda clone() throws CloneNotSupportedException{
        return (Soda) super.clone();
    }    

}
