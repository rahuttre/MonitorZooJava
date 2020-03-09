/*
 * Name: Ryan Hutton
 * Assignment: Final Project Option 2: Zoo Monitoring System
 * Course: IT 145 - Foundations of Application Development
 * Institution: Southern New Hampshire University
 * Date: 21 April 2019
 */

/* 
 * Program Summary: This is the class, ReadAnimal that supplmentes the MonitorZoo
 * main program.  The purpose of this class is to open the file with constructors
 * and apply accesor/mutator methods to access the file information and/or functionality.
 * Due to the nature of file handling, an IOException is established to handle cases where
 * the file fails to open. 
*/

package monitorzoo;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadAnimal  {
    private FileInputStream animalFile = null;
    private Scanner inFS = null;
    
    // Constructor that opens file "animals.txt" upon this object's declaration.  
    // Passes the FileInputStream animalFile into a new Scanner object for reading.
    public ReadAnimal()throws IOException{
        animalFile = new FileInputStream("animals.txt"); 
        inFS = new Scanner(animalFile);
    }
    
    // Constructor that opens file "animals.txt" upon this object's declaration.  
    // Assigns the argument aFile to the private variable animalFile to open the 
    // file.  Passes the FileInputStream animalFile into a new Scanner 
    // object for reading.
    public ReadAnimal(FileInputStream aFile)throws IOException{
        animalFile = aFile;
        animalFile = new FileInputStream("animals.txt");  
        inFS = new Scanner(animalFile);
    }
    
    public void closeFile() throws IOException {
        animalFile.close();
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
 