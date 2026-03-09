/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author aaron
 */
public class TemperatureSensor implements Sensor {
    private boolean isOn; // Tracks if the sensor is powered

    public TemperatureSensor() {
        this.isOn = false; // Starts OFF as requested
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void setOn() {
        this.isOn = true;
    }

    @Override
    public void setOff() {
        this.isOn = false;
    }

    @Override
    public int read() {
        // First, check the STATE. If off, throw the error.
        if (!this.isOn) {
            throw new IllegalStateException("Sensor is off");
        }
        
        // Only if it is ON do we generate the number
        return new Random().nextInt(61) - 30;
    }
}