/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicles2;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gamer
 */
public class Driver {

    static int[][]trips = new int[100][2];
    static int tripCounter = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        promptUser();
    }

    public static void promptUser() {

        Vehicle myVehicle;
        int createAnother;

        // This ArrayList will contain all the vehicles that we create.
        ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();

        do {

            myVehicle = new Vehicle();

            // prompt user
            String strGallonsOfGas
                    = JOptionPane.showInputDialog("Enter gallons of gas");

            // convert the String return to a double.
            double dblGallonsOfGas
                    = Double.parseDouble(strGallonsOfGas);

            myVehicle.setGallonsOfGas(dblGallonsOfGas);

            try {

                int intMilesPerGallon = promptForInteger("Enter miles per gallon", 0, 100);
                myVehicle.setMilesPerGallon(intMilesPerGallon);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Unable to acquire valid data. Program terminating.");
                // System.exit(0); crash
                return;
            }            

            try {
                
                int intOdometer = promptForInteger("Enter odomoter", 0, 1000000);
                myVehicle.setOdometer(intOdometer);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "Unable to acquire valid data. Program terminating.");
                // System.exit(0); crash
                return;
            }
            
            // Once I have create a vehicle, store it in our collection.
            allVehicles.add(myVehicle);

            // prompt the user to create another vehicle
            createAnother = JOptionPane.showConfirmDialog(
                    null,
                    "Do you want to create another vehicle?",
                    "Create another vehicle",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            // if the user chooses yes, prompt for another vehicle. Otherwis, do not loop again.
        } while (createAnother == JOptionPane.YES_OPTION);

        promptForTrips();

        // iterate over all of the vehicles in our collection, and run them the given distance
        /* for( int i = 0; i < allVehicles.size(); i++ ) {
        
        final Vehicle thisVehicles = allVehicles.get(i);
    } */
        for (Vehicle thisVehicle : allVehicles) {

            
            for( int i = 0; i < tripCounter; i++) {
            
                // print the current state of the vehicle
                System.out.println("Before: " + thisVehicle.toString());

                if(thisVehicle.getGallonsOfGas() <= 0) {
                    System.out.println("Out of gas!");
                    break;
                }
                
                // move the vehicle.
                thisVehicle.go(trips[i][0]);

                // print the current state of the vehicle
                System.out.println("After: ");
                System.out.println(thisVehicle.toString());
                
                double reinbursementTotal = (trips[i][1] * trips[i][0])/100.0;
                System.out.println("Reinbursement total: " + reinbursementTotal + " At " + trips[i][1] + " cents per mile.");
            }                       
        }

    }

    public static void promptForTrips() throws HeadlessException, NumberFormatException {

        int createAnother;

        do {
            // prompt the user for a trip distance
            final String strDistanceTravelled = JOptionPane.showInputDialog("Enter distance to travel");
            final int intDistance = Integer.parseInt(strDistanceTravelled);
            
            // store that trip distance into an array
            trips[ tripCounter ][0]  = intDistance;
            
            final String strReinbursementRate = JOptionPane.showInputDialog("Enter reinbursement rate per mile.");
            // final int intDistance = Integer.parseInt(strDistanceTravelled);
            trips[ tripCounter ][1]  = Integer.parseInt(strReinbursementRate);
            
            // Add one to the trip counter to increase our total number of trips entered.
            tripCounter++;

            // prompt the user to create another vehicle
            createAnother = JOptionPane.showConfirmDialog(
                    null,
                    "Do you want to create trip?",
                    "Create another trip",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            // if the user chooses yes, prompt for another vehicle. Otherwis, do not loop again.
        } while (createAnother == JOptionPane.YES_OPTION);

        return;
    }

    /**
     * Prompt and return an integer: validate that it is withing a given range.
     *
     * @param message The message to show when prompting the user.
     * @param low The lowest possible acceptable value for this integer.
     * @param high The highest possible acceptable value for this integer.
     * @return The validated integer.
     * @throws NumberFormatException When the non-numeric data are entered.
     * @throws HeadlessException
     */
    public static int promptForInteger(String message, int low, int high) throws NumberFormatException, HeadlessException, Exception {
        
        String strInput;
        int intInput = 0;
        
        while(true) {
                    
            // prompt for input 
            strInput = JOptionPane.showInputDialog(message);

            try {
                intInput = Integer.parseInt(strInput);
                break;
            } catch(NumberFormatException e) {

                // this block will specifically handle only NumberFormatException.
                System.out.println("Inavlid number.");
                int tryAgain = JOptionPane.showConfirmDialog(null, "You did not enter a valid number. Do you want to try again?", "Invalid Input", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
                
                if(tryAgain == JOptionPane.NO_OPTION) {
                    // we are here, because the user does not want to keep trying.
                    throw new Exception("The user has exceeded the number of attempts for valid data.");
                }
            }        
        }

        while (!(intInput >= low && intInput <= high)) {
            String errorMessage = "The number you have entered is not in the valid range. Low: " + low + " High: " + high + ". Please try again.";
            strInput = JOptionPane.showInputDialog(errorMessage);
            intInput = Integer.parseInt(strInput);
        }

        // returns the validated number
        return intInput;
    }
}
