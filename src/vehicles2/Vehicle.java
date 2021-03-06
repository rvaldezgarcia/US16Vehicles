/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicles2;

/**
 *
 * @author gamer
 */
public class Vehicle {
    
    private double gallonsOfGas;
    private int milesPerGallon;
    private int odometer;
    private static double licensePlateFee;

    public void go(int distance) {
        // compute gallons consumed
        double gallonsConsumed = distance/milesPerGallon;
        // subtract gallons consumed from gallons of gas
        gallonsOfGas = gallonsOfGas - gallonsConsumed;
        
        // increase the odometer
        setOdometer(getOdometer() + distance);
    } 
    
    public void go(String distance) {
        int intDistance = Integer.parseInt(distance);
        go(intDistance);
    }
    
    /**
     * @return the gallonsOfGas
     */
    public double getGallonsOfGas() {
        return gallonsOfGas;
    }

    /**
     * @param gallonsOfGas the gallonsOfGas to set
     */
    public void setGallonsOfGas(double gallonsOfGas) {
        this.gallonsOfGas = gallonsOfGas;
    }

    /**
     * @return the milesPerGallon
     */
    public int getMilesPerGallon() {
        return milesPerGallon;
    }

    /**
     * @param milesPerGallon the milesPerGallon to set
     */
    public void setMilesPerGallon(int milesPerGallon) {
        this.milesPerGallon = milesPerGallon;
    }

    /**
     * @return the odometer
     */
    public int getOdometer() {
        return odometer;
    }

    /**
     * @param odometer the odometer to set
     */
    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
    
    public String toString() {
        return "Gallons of Gas: " + gallonsOfGas + " Odometer: " + getOdometer();
    }   

    /**
     * @return the licensePlateFee
     */
    public static double getLicensePlateFee() {
        return licensePlateFee;
    }

    /**
     * @param aLicensePlateFee the licensePlateFee to set
     */
    public static void setLicensePlateFee(double aLicensePlateFee) {
        licensePlateFee = aLicensePlateFee;
    }
}
