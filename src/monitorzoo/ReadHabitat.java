/*
 * Name: Ryan Hutton
 * Assignment: Final Project Option 2: Zoo Monitoring System
 * Course: IT 145 - Foundations of Application Development
 * Institution: Southern New Hampshire University
 * Date: 21 April 2019
 */

/* 
 * Program Summary: This is the class, ReadHabitat that supplmentes the MonitorZoo
 * main program.  The purpose of this class is to open the file with constructors
 * and apply accesor/mutator methods to access the file information and/or functionality.
 * Due to the nature of file handling, an IOException is established to handle cases where
 * the file fails to open. 
*/

package monitorzoo;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadHabitat {
    private FileInputStream habitatFile = null;
    private Scanner inFS = null;
    
    // Constructor that opens file "habitats.txt" upon this object's declaration.  
    // Passes the FileInputStream animalFile into a new Scanner object for reading.
    public ReadHabitat()throws IOException{
        habitatFile = new FileInputStream("habitats.txt"); 
        inFS = new Scanner(habitatFile);
    }
    
    // Constructor that opens file "habitats.txt" upon this object's declaration.  
    // Assigns the argument aFile to the private variable animalFile to open the 
    // file.  Passes the FileInputStream animalFile into a new Scanner 
    // object for reading.
    public ReadHabitat(FileInputStream aFile)throws IOException{
        habitatFile = aFile;
        habitatFile = new FileInputStream("habitats.txt");  
        inFS = new Scanner(habitatFile);
    }
    
    public void closeFile() throws IOException {
        habitatFile.close();
    }
    
    public void setInput(Scanner input){
        inFS = input;
    }
    
    public Scanner getInput(){
        return inFS;
    }
    
    public String readLine(){
        return inFS.nextLine();
    }
    
    public boolean hasInput(){
        return inFS.hasNextLine();
    }
  }