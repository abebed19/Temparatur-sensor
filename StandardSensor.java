/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author aaron
 */
public class StandardSensor implements Sensor {
    private int sensorOn;
    
    public StandardSensor(int value){
        this.sensorOn = value;
        
        
    }

    @Override
    public boolean isOn() {
      if(this.sensorOn == 0){
          return false;
      }
      return true;
    }

    @Override
    public void setOn() {
        
     }

    @Override
    public void setOff() {
        
     }

    @Override
    public int read() {
        return this.sensorOn;
    }
}
