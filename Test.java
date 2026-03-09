/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author aaron
 */
public class Test {
    public static void main(String... args) throws FileNotFoundException{
        
        PrintWriter writer =new PrintWriter("AbyeTsom.txt");
        writer.println("Abye tsom is the one we can study more about jesus");
        writer.println("We are fasting as he himself fasts");
        writer.println("The number of exact days we fast are 40 only");
        writer.close();
        
    }
    
}
