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
public class Prius extends Vehicle {
 
    private int milliampHours;
    private int milesPerMah;
    
    @Override
    public void go(int distance) {
        super.go(distance);
        System.out.println("In prius, running in internal combustion mode");
    }

    /**
     * @return the milliampHours
     */
    public int getMilliampHours() {
        return milliampHours;
    }

    /**
     * @param milliampHours the milliampHours to set
     */
    public void setMilliampHours(int milliampHours) {
        this.milliampHours = milliampHours;
    }

    /**
     * @return the milesPerMah
     */
    public int getMilesPerMah() {
        return milesPerMah;
    }

    /**
     * @param milesPerMah the milesPerMah to set
     */
    public void setMilesPerMah(int milesPerMah) {
        this.milesPerMah = milesPerMah;
    }
}
