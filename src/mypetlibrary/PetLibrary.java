package mypetlibrary;

import java.io.Console; 
  
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PetLibrary {
	
	PetLibrary() {
	boolean exitnow = false;
    
    final ArrayList<String[]> pets = new ArrayList<String[]>();
    
    // Seeding the list for testing purposes
	// pets.add(new String[] {"fido", "8"});
	// pets.add(new String[] {"bruno", "7"});

    
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
		    System.out.println("\nupdate\n");
		    break;
		  case "4":
		    System.out.println("\nremove\n");
		    break;
		  case "5":
		    System.out.println("\nsearchbyname\n");
			searchPetsByName(pets);
		    break;
		  case "6":
			searchPetsByAge(pets);
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
    
    // displayPets, allows users to display list of pets we are tracking
    public final void displayPets(ArrayList<String[]> mypets) {
    	String name = "";
    	String age = "";
    	String border="+------------------------+";
    	
    	
    	displayHeader();
						
		// TODO 
		// There has to be a better way to do this, but this is what I have so far,  
		// can work on it in future releases.	
		// rows
		int numberofpets = mypets.size();
        for( int i = 0; i < numberofpets; i++ ) {
	        name=mypets.get(i)[0];
	        age=mypets.get(i)[1];
	        displayPet(i,name,age);
        }

        displayFooter(numberofpets);
    }
    
    
    // TODO,  one place I am breaking requirements...
    // AGE is NOT an INT, but a string.
    
    // I found and used this stackoverflow post and laughed at this comment:
    // https://stackoverflow.com/questions/18033287/arraylist-containing-integers-and-strings
    //      "Dude this as per requirement stuff stinks of homework! - MightyPork Aug 3 '13 at 13:35"
    
    // That probably means an arraylist isn't the correct datatype I should use, 
    // but I'm not going to change it today.. ;)
    
    // addPets, allows user to add pet name and age to arraylist
    public final void addPets(ArrayList<String[]> mypets) {
    	
    	// TODO, Have to work on formatting,  I have newlines in diff places to make it pretty.
    	System.out.println("\n\n");
    	
    	String name="";
    	String age="";
    	int petsadded=0;
    	
    	do { 
	    	System.out.println("add pet (name age):");
	        Scanner scanner = new Scanner(System.in); 
	        
	        // get new pet from user 
	        String mynewpet = scanner.nextLine(); 
	        // chop up mynewpet to get name and age as separate values
	        // split off of space char.
	        // TODO,  add more validation logic to make user enter data in correct format.
	        //  I found the split reference here: https://www.geeksforgeeks.org/split-string-java-examples/
	        String[] arrayofpetdata = mynewpet.split(" ", 2);
	                
	        name=arrayofpetdata[0];
	        
	        // 'done' is keyword to stop entering pets
	        if (name.equals("done")) {
	        	break;
	        }

	        // need better validation logic, this just keeps it from puking
	        try {
		         age = arrayofpetdata[1];
	        } catch (IndexOutOfBoundsException error) {
	        	System.out.println("     Must enter  'name age' ");
	        	System.out.println("     Come back in here and try again\n\n");
	        	break;       	
	        }
  	
	        // I referenced a number of places concerning Arraylist, but this was the last one that really got me going
	        // https://www.javacodeexamples.com/java-arraylist-of-arrays-example/1003
    	    
	        // add new value to arraylist
	    	mypets.add(new String[] {name, age});
	    	petsadded++;
	    	
    	} while (true);
    	System.out.println(petsadded + " pets added.\n");
    }
    
    // searchPetsByName, allows user to search for pets matching name
    public final void searchPetsByName(ArrayList<String[]> mypets) {
    	
    	String name;
    	String age;
    	
   	    int matchedpets = 0;
		int numberofpets = mypets.size();   	    	
    	
    	System.out.println("Enter a name to search:");
        Scanner scanner = new Scanner(System.in); 
        // get name to search for from user 
        String searchforname = scanner.nextLine(); 

	  	displayHeader();

        for( int i = 0; i < numberofpets; i++ ) {
	        name=mypets.get(i)[0];
	        age=mypets.get(i)[1];        

            if(name.equalsIgnoreCase(searchforname)) {
            	matchedpets++;        	
    	        displayPet(i,name,age);
	        }
        }
    	displayFooter(matchedpets);
    }
    
    // searchPetsByAge, allows user to search for pets matching name
    public final void searchPetsByAge(ArrayList<String[]> mypets) {
    	
    	String name;
    	String age;
    	
   	    int matchedpets = 0;
		int numberofpets = mypets.size();   	    	
    	
    	System.out.println("Enter age to search:");
        Scanner scanner = new Scanner(System.in); 
        // get age of pet to search for from user 
        String searchforage = scanner.nextLine(); 

	  	displayHeader();

        for( int i = 0; i < numberofpets; i++ ) {
	        name=mypets.get(i)[0];
	        age=mypets.get(i)[1];        

            if(age.equals(searchforage)) {
            	matchedpets++;        	
    	        displayPet(i,name,age);
	        }
        }
    	displayFooter(matchedpets);
    }

    
    public final void displayPet(int id, String name, String age) {	   	
        System.out.printf("|%3.3s | %-10.10s | %4.4s |\n", id, name, age);
    }

    
    public final void displayHeader() {	
    	
    	String border="+------------------------+";
    	
		System.out.println("\n" + border);
        System.out.printf("|%3.3s | %-10.10s | %4.4s |\n", "ID", "NAME", "AGE");
		System.out.println(border);
    }
    
    public final void displayFooter(int rows) {	
    	
    	String border="+------------------------+";
    	
		System.out.println(border);
		System.out.println(rows + " rows in set\n");

    }



}


