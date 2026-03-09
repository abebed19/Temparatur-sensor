# Temparatur-sensor


All the classes should be placed inside the application package.

We have the following interface at our disposal:

public interface Sensor {
    boolean isOn();    // returns true if the sensor is on
    void setOn();      // sets the sensor on
    void setOff();     // sets the sensor off
    int read();        // returns the value of the sensor if it's on
                       // if the sensor is not on, throw an IllegalStateException
}
Standard sensor
Create a class called StandardSensor that implements the interface Sensor.

A standard sensor is always on. Calling the methods setOn and setOff have no effect. The StandardSensor must have a constructor that takes one integer parameter. The method call read returns the number that was given to the constructor.

An example:

public static void main(String[] args) {
    StandardSensor ten = new StandardSensor(10);
    StandardSensor minusFive = new StandardSensor(-5);

    System.out.println(ten.read());
    System.out.println(minusFive.read());

    System.out.println(ten.isOn());
    ten.setOff();
    System.out.println(ten.isOn());
}
Sample output
10
-5
true
true

TemperatureSensor
Create a class TemperatureSensor that implements the Sensor interface.

At first a temperature sensor is off. When the method read is called and the sensor is on, the sensor randomly chooses an integer in the range -30...30 and returns it. If the sensor is off, the method read throws an IllegalStateException.

Use the ready-made Java class Random to choose the random number. You'll get an integer in the range 0...60 by calling new Random().nextInt(61); — to get a random integer in the range -30...30 you'll have to subtract a suitable number from the random number in the range 0...60.

Average sensor
Create a class called AverageSensor that implements the interface Sensor.

An average sensor includes multiple sensors. In addition to the methods defined in the Sensor interface, the AverageSensor has the method public void addSensor(Sensor toAdd) that can be used to add a new sensor for the average sensor to control.

An AverageSensor is on when all its sensors are on. When setOn is called, all the sensors must be set on. When setOff is called, at least one of the sensors must be set off. It's also acceptable to set off all the sensors.

The method read of AverageSensor returns the average of the read methods of its sensors (since the return value is int, the number is rounded down as is the case with integer division). If this method is called while the AverageSensor is off, or if no sensors have been added to it, the method should throw an IllegalStateException.

Here follows an example program that uses the sensors (NB: the constructors of both TemperatureSensor and AverageSensor are non-parameterized):

public static void main(String[] args) {
    Sensor kumpula = new TemperatureSensor();
    kumpula.setOn();
    System.out.println("temperature in Kumpula " + kumpula.read() + " degrees Celsius");

    Sensor kaisaniemi = new TemperatureSensor();
    Sensor helsinkiVantaaAirport = new TemperatureSensor();

    AverageSensor helsinkiRegion = new AverageSensor();
    helsinkiRegion.addSensor(kumpula);
    helsinkiRegion.addSensor(kaisaniemi);
    helsinkiRegion.addSensor(helsinkiVantaaAirport);

    helsinkiRegion.setOn();
    System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");
}
The print statements below depend on which temperatures are randomly returned:

Sample output
temperature in Kumpula 11 degrees Celsius
temperature in Helsinki region 8 degrees Celsius

All readings
Add to the class AverageSensor the method public List<Integer> readings(). The method should return the results of all the executed readings that the average sensor has done as a list. Here is an example:

public static void main(String[] args) {
    Sensor kumpula = new TemperatureSensor();
    Sensor kaisaniemi = new TemperatureSensor();
    Sensor helsinkiVantaaAirport = new TemperatureSensor();

    AverageSensor helsinkiRegion = new AverageSensor();
    helsinkiRegion.addSensor(kumpula);
    helsinkiRegion.addSensor(kaisaniemi);
    helsinkiRegion.addSensor(helsinkiVantaaAirport);

    helsinkiRegion.setOn();
    System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");
    System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");
    System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");

    System.out.println("readings: " + helsinkiRegion.readings());
}
Again, the exact print statements depend on the randomized readings:

Sample output
temperature in Helsinki region -10 degrees Celsius
temperature in Helsinki region -4 degrees Celsius
temperature in Helsinki region 5 degrees Celsius

readings: [-10, -4, 5]

, let's take a look at writing data to files. The PrintWriter class offers the functionality to write to files. The constructor of the PrintWriter class receives as its parameter a string that represents the location of the target file.

PrintWriter writer = new PrintWriter("file.txt");
writer.println("Hello file!"); //writes the string "Hello file!" and line change to the file
writer.println("More text");
writer.print("And a little extra"); // writes the string "And a little extra" to the file without a line change
writer.close(); //closes the file and ensures that the written text is saved to the file
