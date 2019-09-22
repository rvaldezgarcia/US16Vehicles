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
    private int milesPerGallons;
    private int odometer;

    public Vehicle() {
    
    }
    
    public void go(int distance) {
        
        // compute gallons consumed
        double gallonsConsumed = distance / milesPerGallons;
        
        // substract gallonsConsumed from gallons of gas
        gallonsOfGas -= gallonsConsumed;
        
        // increase the odometer.
        setOdometer(getOdometer() + distance);
    }
    
    public double getGallonsOfGas() {
        return this.gallonsOfGas;
    }
    public void setGallonsOfGas(double gallonsOfGas) {
        this.gallonsOfGas = gallonsOfGas;
    }
    
    /**
     * @return the milesPerGallons
     */
    public int getMilesPerGallons() {
        return milesPerGallons;
    }

    /**
     * @param milesPerGallons the milesPerGallons to set
     */
    public void setMilesPerGallons(int milesPerGallons) {
        this.milesPerGallons = milesPerGallons;
    }
    
    public String toString() {
    
    return "Gallons of Gas: " + gallonsOfGas + " Odometer: " + getOdometer();
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
}
