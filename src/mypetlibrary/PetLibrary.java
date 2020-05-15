package mypetlibrary;

import java.io.Console;   
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PetLibrary {
	
	PetLibrary() {
	boolean exitnow = false;
    
    final ArrayList<String[]> pets = new ArrayList<String[]>();
    
    // TODO 
    // Seeding the list, have to remember to remove before submitting
	//pets.add(new String[] {"kitty", "8"});
	//pets.add(new String[] {"bruno", "7"});

    
	do {
			
		displayMenu();
		
        Scanner sc = new Scanner(System.in); 
     
        // String input 
        String choice = sc.nextLine(); 
		
 			
		switch (choice) {
		  case "1":
		    displayPets(pets);
		    break;
		  case "2":
		    addPets(pets);
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
		System.out.println("\nWhat would you like to do?");
		System.out.println(" 1) View all pets");
		System.out.println(" 2) Add more pets");
		System.out.println(" 3) Update an existing pet");
		System.out.println(" 4) Remove an existing pet");
		System.out.println(" 5) Search pets by name");
		System.out.println(" 6) Search pets by age");
		System.out.println(" 7) Exit program");
		System.out.println("Your choice: ");
    }
    
    
    public final void displayPets(ArrayList<String[]> mypets) {
    	//int numberofpets = mypets.length;
    	String name = "";
    	String age = "";
    	String border="+------------------------+";
    	
    	
    	
		System.out.println("\n" + border);
        System.out.printf("|%3.3s | %-10.10s | %4.4s |\n", "ID", "NAME", "AGE");
		System.out.println(border);
			
			
		// TODO 
		// There has to be a better way to do this, but this is what I have so far,  
		// can work on it in future releases.	
		int numberofpets = mypets.size();
        for( int i = 0; i < numberofpets; i++ ) {
	        name=mypets.get(i)[0];
	        age=mypets.get(i)[1];
	        System.out.printf("|%3.3s | %-10.10s | %4.4s |\n", i, name, age);
        }

		System.out.println(border);
		System.out.println(numberofpets + " rows in set\n");
    }
    
    
    /* addPets, allows user to add pet name and age to arraylist */
    public final void addPets(ArrayList<String[]> mypets) {
    	
    	System.out.println("\n\n");
    	
    	String name="";
    	String age="";
    	int petsadded=0;
    	
    	do { 
	    	System.out.println("add pet (name age):");
	        Scanner sc = new Scanner(System.in); 
	        
	        // get new pet from user 
	        String mynewpet = sc.nextLine();
	        
	        // chop up mynewpet to get name and age as separate values
	        // split off of space char.
	        // TODO,  add validation logic to make user enter data in correct format.
	        String[] arrayofpetdata = mynewpet.split(" ", 2);
	                
	        name=arrayofpetdata[0];
	        
	        // 'done' is keyword to stop entering pets
	        if (name.equals("done")) {
	        	break;
	        }

	        // need better validation logic, this just eeps it from puking
	        try {
		         age = arrayofpetdata[1];
	        } catch (IndexOutOfBoundsException error) {
	        	System.out.println("must enter  'name age' ");
	        	System.out.println("come back here and try again\n\n");
	        	break;       	
	        } catch (Exception | Error exception) {
	        	System.out.println("must enter  'name age' ");
	        	System.out.println("come back here and try again\n\n");
	        	break;
	        }
  	
    	    // add new value to arraylist
	    	mypets.add(new String[] {name, age});
	    	petsadded++;
	    	
    	} while (true);
    		System.out.println(petsadded + " pets added.\n");

    }

}


