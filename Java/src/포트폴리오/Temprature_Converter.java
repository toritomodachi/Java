package 포트폴리오;

import java.util.*;
public class Temprature_Converter {
    static Scanner sc = new Scanner(System.in); // Scanner Class

    // Celcius to Fahrenheit
    static double Celcius_to_Fahrenheit(double Celcius){
        double Fahrenheit = (Celcius * 9/5) + 32;
        return Fahrenheit;
    }
    // Celcius to Kelvin
    static double Celcius_to_Kelvin(double Celcius){
        double Kelvin = Celcius + 273.15;
        return Kelvin;
    }

    // Fahrenheit to Celcius
    static double Fahrenheit_to_Celcius(double Fahrenheit){
        double Celcius = (Fahrenheit - 32) * 5/9;
        return Celcius;
    }
    // Fahrenheit to Kelvin
    static double Fahrenheit_to_Kelvin(double Fahrenheit){
        double Kelvin = (Fahrenheit - 32) * 5/9 + 273.15;
        return Kelvin;
    }

    // Kelvin to Celcius
    static double Kelvin_to_Celcius(double Kelvin){
        double Celcius = Kelvin - 273.15;
        return Celcius;
    }
    // Kelvin to Fahrenheit
    static double Kelvin_to_Fahrenheit(double Kelvin){
        double Fahrenheit = (Kelvin - 273.15) * 9/5 + 32;
        return Fahrenheit;
    }

    // Read the value of temperature given by the user
    static double Input_Temperature(String Temperature){
        System.out.println("Enter the "+Temperature+" value:");
        double val = sc.nextDouble();
        return val;
    }

    // Print converted value of temperature
    static void Output_Temperature(double Value, String Temperature){
        System.out.println("The "+Temperature+" value is: "+Value);
    }

    // Driver Method
    public static void main(String args[]){
        System.out.println("Enter 1 for Celcius to Fahrenheit\nEnter 2 for Celcius to Kelvin\n"+
              "Enter 3 for Fahrenheit to Celcius\nEnter 4 for Fahrenheit to Kelvin\n"+
              "Enter 5 for Kelvin to Celcius\nEnter 6 for Kelvin to Fahrenheit\n7. Exit");
        do{
            System.out.println("\nEnter Your Temperature Choice Number: ");
            int Temprature_Choice = sc.nextInt();
            double Choice_Number = 0;
            switch(Temprature_Choice){
                case 1: Choice_Number = Input_Temperature("Celcius");
                    Output_Temperature(Celcius_to_Fahrenheit(Choice_Number), "Fahrenheit");
                    break;
                case 2: Choice_Number = Input_Temperature("Celcius");
                    Output_Temperature(Celcius_to_Kelvin(Choice_Number), "Kelvin");
                    break;
                case 3: Choice_Number = Input_Temperature("Fahrenheit");
                    Output_Temperature(Fahrenheit_to_Celcius(Choice_Number), "Celcius");
                    break;
                case 4: Choice_Number = Input_Temperature("Fahrenheit");
                    Output_Temperature(Fahrenheit_to_Kelvin(Choice_Number), "Kelvin");
                    break;
                case 5:Choice_Number = Input_Temperature("Kelvin");
                    Output_Temperature(Kelvin_to_Celcius(Choice_Number), "Celcius");
                    break;
                case 6: Choice_Number = Input_Temperature("Kelvin");
                    Output_Temperature(Kelvin_to_Fahrenheit(Choice_Number), "Fahrenheit");
                    break;
                case 7: System.exit(0);
                    break;
                default: System.out.println("Invalid Input");
            }
        }
        while(true);
    }
}

