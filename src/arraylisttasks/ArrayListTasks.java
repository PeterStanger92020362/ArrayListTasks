/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylisttasks;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

/**
 *
 * @author Peter
 */
public class ArrayListTasks {
    

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList shoppingList = new ArrayList();

        shoppingList.add("juice");
        shoppingList.add("bread");
        shoppingList.add("butter");
        shoppingList.add("cheese");
       
        printArrayList( shoppingList );
        
        shoppingList.add("pie crust");
        shoppingList.add("6 large eggs");
        shoppingList.add("milk");
        shoppingList.add("salt");
        shoppingList.add("black pepper");
        shoppingList.add("ham");
        shoppingList.add("cheese");
        shoppingList.add("green onions");
        
        printArrayList( shoppingList );
        
        shoppingList.remove("bread");
        shoppingList.remove("butter");
        
        printArrayList( shoppingList );
        
        
        
        ArrayList personArrayList = new ArrayList
        
        
                
        obtainRecords("PersonList.csv");
        
        
        

        
        
    }
    
    public static void printArrayList( ArrayList listToPrint ){
        System.out.println("Shopping List:");
        for ( var each : listToPrint ){
            System.out.println(each);
        }
        System.out.println("");
    }

    
    public static void obtainRecords( String path ){
        //allows to read information from the file line by line
        LineNumberReader lr = null;
        //an array to store info about one person
        String[] oneRecord = new String[3];

        Person person;
        ArrayList personArrayList = new ArrayList();

        // using try-catch for exception handling to catch
        //possible errors with i/o operations
        try {
            //FileReader reads the file's contents
            FileReader inputStream = new FileReader( path );

            lr = new LineNumberReader( inputStream );
            String str;

            //while the next line exists
            while(( str = lr.readLine() ) != null ){
               //dividing one file line by commas and assigning to array
               //EXAMPLE LINE: SMIJ15,Johnotan Smith, 80.5
               //after applying str.split(","):
               //oneRecord[0] = SMIJ15,
               //oneRecord[1] = Johnotan Smith
               //oneRecord[2] = 80.5
               oneRecord = str.split(",");
               //using Person's constructor to assign values from
               //the oneRecord array as Perons't information
               //EXAMPLE:
               //constructor: Person(String id, String name, String weight)
               //sets persons's id=SMIJ15, name = Johnotan Smith, weight = 80.5
               person = new Person(oneRecord[0], oneRecord[1], oneRecord[2]);
               personArrayList.add(person);  // adding person to the ArrayList
            }
        }
        catch(IOException ioe){
            System.out.println("IOException occured");
        }
    }
       
}
