/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicles2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gamer
 */
public class InventoryReader 
{    
    public static void main(String[] args) 
    {        
        readAndRunVehicle();
    }

    /**
     * Read vehicle data from a file, populate a Vehicle object with that data,
     * and then pass the populated vehicle to a run method.
     * @throws NumberFormatException 
     */
    private static void readAndRunVehicle() throws NumberFormatException {
        
        Vehicle inventoryVehicle = createVehicle();
         

        runVehicle(inventoryVehicle);
    }

    /**
     * Take a vehicle and run at a given distance. Print output before and after.
     * @param inventoryVehicle a pre-populated vehicle that is ready to run.
     */
    private static void runVehicle(Vehicle inventoryVehicle) {
        // System.out.println(nextLine);
        
        System.out.println("Vehicle before move: " + inventoryVehicle.toString());
        
        // move vehicle
        inventoryVehicle.go(120);
        
        System.out.println("Vehicle after move: " + inventoryVehicle.toString());        
    }

    
    /**
     * Create a vehicle, using a factory method, by reading data from a file.
     * @return the created vehicle
     * @throws NumberFormatException if we are unable to read the data properly
     */
    private static Vehicle createVehicle() throws NumberFormatException {
        // let's create a vehicle
        Vehicle inventoryVehicle = new Vehicle();
        try {
            
            String fileLocation =  File.separator + "Users" 
                    + File.separator + "gamer" + File.separator + "Documents"
                    + File.separator + "NetBeansProjects" + File.separator + "Vehicles2"
                    + File.separator + "src" + File.separator + "vehicles2" 
                    + File.separator + "inventory.txt";
                        
            // find the file with the vehicle data
            File inventoryFile = new File(fileLocation);

            // use a scanner that will read from the file
            Scanner inventoryScanner = new Scanner(inventoryFile);
            
            // read a line from the file
            String nextLine = inventoryScanner.nextLine();
            
            // split the file into parts            
            String[] vehicleComponents = nextLine.split(",");
            
            //  get the components of our vehicle
            String strOdometer = vehicleComponents[0];
            
            String strMilesPerGallon = vehicleComponents[1];
            
            String strGallonsOfGas = vehicleComponents[2];                  
            
            double dblGallonsOfGas = Double.parseDouble(strGallonsOfGas);
            inventoryVehicle.setGallonsOfGas(dblGallonsOfGas);            
            
            int intMilesPerGallon = Integer.parseInt(strMilesPerGallon);
            inventoryVehicle.setMilesPerGallon(intMilesPerGallon);            
            
            double dblOdometer = Double.parseDouble(strOdometer);
            inventoryVehicle.setGallonsOfGas(dblOdometer);
        
        }
        catch(FileNotFoundException ex) {
            // we go here if something went wrong
            Logger.getLogger(InventoryReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inventoryVehicle;        
    }
}
