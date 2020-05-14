package mypetlibrary;

import java.io.Console;   
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner;


public class PetLibrary {
	
	PetLibrary() {
	boolean exitnow = false;
    
	do {
			
		displayMenu();
		
        Scanner sc = new Scanner(System.in); 
     
        // String input 
        String choice = sc.nextLine(); 
		
 			
		switch (choice) {
		  case "1":
		    System.out.println("View");
		    displayPets();
		    break;
		  case "2":
		    System.out.println("add");
		    break;
		  case "3":
		    System.out.println("update");
		    break;
		  case "4":
		    System.out.println("remove");
		    break;
		  case "5":
		    System.out.println("searchbyname");
		    break;
		  case "6":
		    System.out.println("searchbyage");
		    break;
		  case "7":
		    System.out.println("\nGoodbye!");
		    exitnow=true;
		    break;
		}
	} while (!exitnow);
	
		
	}
	
	
    public final void displayMenu() {
		System.out.println("What would you like to do?");
		System.out.println(" 1) View all pets");
		System.out.println(" 2) Add more pets");
		System.out.println(" 3) Update an existing pet");
		System.out.println(" 4) Remove an existing pet");
		System.out.println(" 5) Search pets by name");
		System.out.println(" 6) Search pets by age");
		System.out.println(" 7) Exit program");
		System.out.println("Your choice: ");
    }
    
    public final void displayPets() {
    	int number = 0;
		System.out.println("+-------------------------+");
		System.out.println("| ID | NAME         | AGE |");
		System.out.println("+-------------------------+");
		System.out.println("all my pets");
		System.out.println("+-------------------------+");
		System.out.println(number + " rows in set\n");
    }

}


