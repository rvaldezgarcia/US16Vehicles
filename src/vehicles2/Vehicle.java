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
    
    double gallonsOfGas;
    private int milesPerGallons;

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
    
    
}
