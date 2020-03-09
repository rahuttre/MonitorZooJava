/*
 * Name: Ryan Hutton
 * Assignment: Final Project Option 2: Zoo Monitoring System
 * Course: IT 145 - Foundations of Application Development
 * Institution: Southern New Hampshire University
 * Date: 21 April 2019
 */

/* 
 * Program Summary: This is the final project for the course.  The requirements
 * for this project was to develop a monitoring system to report the status of 
 * zoo animals or habitats read from multiple files.  The main execution is 
 * controlled by a simple switch statement based on the user input.  Next, 
 * functions, launchAnimals() and launchHabitat are called, which declare instances
 * of ReadAnimal and ReadHabitat to open the files, "animals.txt" and "habitat.txt".
 * Lastly, if a concern is identified in either an animal or a habitat, a dialog box is opened.
*/

package monitorzoo;

import java.util.Scanner; // Scanner used to read lines in each file and get user input.
import java.io.IOException; // Handle exceptions incase files fail to open.
import javax.swing.JOptionPane; // This is imported to launch the dialog box.

public class MonitorZoo {

    public static void launchAnimals() throws IOException {

        ReadAnimal subMenu = new ReadAnimal(); // Opens "animals.txt" file upon declaration to read "Details on" menu
        ReadAnimal animalSpec = new ReadAnimal(); // Opens "animals.txt" file upon declaration to read animal specification
        String readLine = ""; // Read each line in the subMenu
        String readLine2 = ""; // Read each line in the animalSpec portion
        String detailsOn = ""; // Collects the user input of the animal chosen
        String animalLine = ""; // Outputs the line in file of the type of animal
        String nameLine = ""; // Outputs the line in file of the name of animal
        String ageLine = ""; // Outputs the line in file of the age of animal
        String healthLine = ""; // Outputs the line in file of the health of animal
        String feedLine = ""; // Outputs the line in file of the feed of the animal
        String concern = ""; // Collects the concern message and passes that to the dialog box.
        // String convertCase = ""; // Converts the case of detailsOn to match user input
        Scanner scnr2 = null; // Read user input
        int step = 0; // Step counter to iterate the file for a few lines in the animalSpec
        
        // subMenu calls a function hasInput() created by this author to begin loop
        // Outputs "Details on" menu
        while(subMenu.hasInput()){
            readLine = subMenu.readLine();
            if (readLine.contains("Details on")) {
                System.out.println(readLine);
            }
        }
        
        System.out.println("\nSelect Animal to monitor:");
        scnr2 = new Scanner(System.in);
        detailsOn = scnr2.nextLine();
        // convertCase = detailsOn.toLowerCase();
        
        // Reads the entire file with another ReadAnimal object
        while (animalSpec.hasInput()){
            readLine2 = animalSpec.readLine();
            
            // Finds line in file that matches the user input and outputs it
            if(readLine2.contains("Animal - ") && readLine2.contains(detailsOn)){
                animalLine = readLine2;
                System.out.println(animalLine);
                
                // Once line in file matches user input, read the remaining information on that specific animal.
                // Loop iterates over the next 4 lines to read and output the animal data, controlled by the step counter.
                while (animalSpec.hasInput() && step < 4){
                    readLine2 = animalSpec.readLine();
                    
                    // Launch concern dialog box here if five asterisks are found in file.
                    if(readLine2.contains("*****")){
                        concern = readLine2.replace("*****", "");
                        JOptionPane.showMessageDialog(null, concern, "Concern", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(readLine2.contains("Name")){
                    nameLine = readLine2;
                    System.out.println(nameLine);
                    }
                    if(readLine2.contains("Age")){
                        ageLine = readLine2;
                        System.out.println(ageLine);
                    }
                    if(readLine2.contains("Health")){
                        healthLine = readLine2;
                        System.out.println(healthLine);                
                    }
                    if(readLine2.contains("Feeding")){
                        feedLine = readLine2;
                        System.out.println(feedLine);                
                        System.out.println();
                    }
                    
                    step++;
                }
            }       
        }

        // Close both files by calling a ReadAnimal function, closeFile(), which
        // accesses the FileInputStream close() method.
        subMenu.closeFile();
        animalSpec.closeFile();
    }
    
    public static void launchHabitat() throws IOException {

        ReadHabitat subMenu = new ReadHabitat(); // Opens "habitats.txt" file upon declaration to read "Details on" menu
        ReadHabitat habitatSpec = new ReadHabitat(); // Opens "habitats.txt" file upon declaration to read animal specification
        String readLine = ""; // Read each line in the subMenu
        String readLine2 = ""; // Read each line in the habitatSpec portion
        String detailsOn = ""; // Collects the user input of the habitat chosen
        String habitatLine = ""; // Outputs the line in file of the type of habitat
        String temperature = ""; // Outputs the line in file of the temperature condition
        String foodSource = ""; // Outputs the line in file of the food source
        String cleanliness = ""; // Outputs the line in file of the cleanliness condition
        String concern = ""; // Collects the concern message and passes that to the dialog box.
        Scanner scnr2 = null; // Read user input
        int step = 0; // Step counter to iterate the file for a few lines in the habitatSpec
        
        // subMenu calls a function hasInput() created by this author to begin loop
        // Outputs "Details on" menu
        while(subMenu.hasInput()){
            readLine = subMenu.readLine();
            if (readLine.contains("Details on")) {
                System.out.println(readLine);
            }
        }
        
        System.out.println("\nSelect Habitat to monitor:");
        scnr2 = new Scanner(System.in);
        detailsOn = scnr2.nextLine();

        // Reads the entire file with another ReadHabitat object
        while (habitatSpec.hasInput()){
            readLine2 = habitatSpec.readLine();
            
            // Finds line in file that matches the user input and outputs it
            if(readLine2.contains("Habitat - ") && readLine2.contains(detailsOn)){
                habitatLine = readLine2;
                System.out.println(habitatLine);
                
                // Once line in file matches user input, read the remaining information on that specific habitat.
                // Loop iterates over the next 4 lines to read and output the habitat data, controlled by the step counter.
                while (habitatSpec.hasInput() && step < 4){
                    readLine2 = habitatSpec.readLine();
                    
                    // Launch concern dialog box here if five asterisks are found in file.
                    if(readLine2.contains("*****")){
                        concern = readLine2.replace("*****", "");
                        JOptionPane.showMessageDialog(null, concern, "Concern", JOptionPane.INFORMATION_MESSAGE);
                    }
                    if(readLine2.contains("Temperature")){
                    temperature = readLine2;
                    System.out.println(temperature);
                    }
                    if(readLine2.contains("Food source")){
                        foodSource = readLine2;
                        System.out.println(foodSource);
                    }
                    if(readLine2.contains("Cleanliness")){
                        cleanliness = readLine2;
                        System.out.println(cleanliness);                
                    }
                    
                    step++;
                }
            }       
        }
        
        // Close both files by calling a ReadHabitat function, closeFile(), which
        // accesses the FileInputStream close() method.
        subMenu.closeFile();
        habitatSpec.closeFile();
    }
    
    // Main function that controls the main execution of the program.  Methods,
    // launchAnimals() and launchHabitat() are called based on user input.  Main
    // also checks for valid input or quits the program.
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        String mainOption = "";
        boolean quit = false;
        
        System.out.println("Welcome to the Zoo monitoring system.");
        System.out.println("Select item to examine: (A)nimal, (H)abitat, or (Q)uit ");
        mainOption = scnr.nextLine();
                    
            switch(mainOption){
                case "A":
                case "a":
                    launchAnimals();
                    break;
                
                case "H":
                case "h":
                    launchHabitat();
                    break;
                
                case "Q":
                case "q":
                    System.out.println("Exiting program...");
                    quit = true;
                    break;
                
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        }
    }
            
    

