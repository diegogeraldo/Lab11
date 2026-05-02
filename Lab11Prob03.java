/**
* File: Lab11Prob02
* Class: CSCI 1302
* Author: Diego Geraldo-Vargas
* Created on: May 1, 2026
* Last Modified: May 1, 2026
* Description: Creates a program that reads data from a file in a readable format and then copies output into file as well as new file with objects instead of strings
*/


import java.io.*;
import java.util.*;

public class Lab11Prob03 {
    public static void main(String[] args) {
        
        ArrayList<Person> peopleList = new ArrayList<>();

        try (
        		DataInputStream in = new DataInputStream(new FileInputStream("src/people.dat"));

        ){
            while (true) {
            	try {
	            	// Sets variables to the current needed in that line
	                int age = in.readInt();
	                String name = in.readUTF();
	                String address = in.readUTF();
	                int intZip = in.readInt();
	                String zip = String.valueOf(intZip);
	                double salary = in.readDouble();
	
	                Person p = new Person(age, name, address, zip, salary);
	                peopleList.add(p);

		         // Reduced redundancy in my handling.
		        } catch (EOFException e) {
		        	break;
		        } 
            }
        }
        catch (IOException e) {
	            e.printStackTrace();
	    } 
        
        Collections.sort(peopleList);

        
        // Output writer and the catcher for that.
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("src/people-salary-sorted.dat"))) {

            for (Person p : peopleList) {
                out.writeUTF(p.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Output writer and catcher using objects instead of string.
        try (ObjectOutputStream oos =
                 new ObjectOutputStream(new FileOutputStream("src/people-salary-sorted-objects.dat"))) {

            for (Person p : peopleList) {
                oos.writeObject(p);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Message to know its done.
        System.out.println("Finished processing and sorting.");
	}
}
