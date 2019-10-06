/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicles2;

import javax.swing.JOptionPane;

/**
 *
 * @author gamer
 */
public class Driver {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        promptUser();
    }
    
    public static void promptUser() {               
        
        // create a variable of type vehicle.
        Vehicle myVehicle = new Vehicle();                               
        
        // prompt user
        String strGallonsOfGas = JOptionPane.showInputDialog("Enter gallons of gas");
        
        // convert the String returned to a double.
        double dblGallonsOfGas = Double.parseDouble(strGallonsOfGas);
        
        myVehicle.setGallonsOfGas(dblGallonsOfGas);
        
        String strMilesPerGallon = JOptionPane.showInputDialog("Enter miles per gallon?");  
        int intMilesPerGallon = Integer.parseInt(strMilesPerGallon);               
        
        myVehicle.setMilesPerGallon(intMilesPerGallon);
        
        final String strOdometer = JOptionPane.showInputDialog("Enter odometer");
        final int intOdometer = Integer.parseInt(strOdometer);
        
        myVehicle.setOdometer(intOdometer);
                        
        final String strDistanceTravelled = JOptionPane.showInputDialog("Enter distance to travel.");        
        final int intDistance = Integer.parseInt(strDistanceTravelled);                       
        
        // print the current state of the vehicle
        System.out.println( "My Vehicle: " + myVehicle.toString());
        
        // move the vehicle
        myVehicle.go(intDistance);
        
        // print the current state of the vehicle
        System.out.println("My Vehicle, after move: " + myVehicle.toString());
        
        // create a new object - your vehicle
        Vehicle yourVehicle = new Vehicle(25, 25, 25000);
        
        System.out.println("Your Vehicle: " + yourVehicle);
        
        yourVehicle.go(intDistance);
        
        System.out.println("Your Vehicle, after move: " + yourVehicle);
        
        System.out.println("My Vehicle, after move: " + myVehicle.toString());
    }
}