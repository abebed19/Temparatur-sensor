/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author aaron
 */
public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> history; // To store the history of averages

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.history = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    @Override
    public boolean isOn() {
        // Returns true only if the list isn't empty AND all sensors are on
        return !sensors.isEmpty() && sensors.stream().allMatch(Sensor::isOn);
    }

    @Override
    public void setOn() {
        sensors.forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        // Turning the average sensor off usually turns off all sub-sensors
        sensors.forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        // Must be ON and have sensors to read
        if (!this.isOn() || this.sensors.isEmpty()) {
            throw new IllegalStateException("Sensor is off or no sensors added.");
        }

        int average = (int) this.sensors.stream()
                .mapToInt(s -> s.read())
                .average()
                .orElse(0);

        this.history.add(average); // SAVE the average to history
        return average;
    }

    public List<Integer> readings() {
        // Return the history of averages calculated so far
        return this.history;
    }
}