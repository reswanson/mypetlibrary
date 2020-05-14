package mypetlibrary;

import java.io.Console;   
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PetLibrary {
	
	PetLibrary() {
	boolean exitnow = false;
	//String[] pets = {};
	//String[] pets = {"Fido", "mangy", "dog", "meowmeow"};
    String[][] pets = { {"Kitty", "8"}, {"Bruno", "7"} };
    
    //ArrayList<String><String> pets = new ArrayList<String><String>();
    //pets.add({"Kitty", "8"});
    //pets.add({"Bruno", "7"});


    
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
		    System.out.println("add");
		    addPets();
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
    
    
    public final void displayPets(String[][] mypets) {
    	int numberofpets = mypets.length;
    	String name = "";
    	String age = "";
    	
		System.out.println("\n+-------------------------+");
		System.out.println("| ID | NAME         | AGE |");
		System.out.println("+-------------------------+");
			
			
		// TODO 
		// There is a better way to do this, but this is what I have
		// so far,  can make it better in a future release.
	    for (int i = 0; i < mypets.length; ++i) {
	        name=mypets[i][0];
	        age=mypets[i][1];
	        System.out.printf("|%3.3s | %-12s | %3.3s |\n", i, name, age);
	    }
	       	   	

		System.out.println("+-------------------------+");
		System.out.println(numberofpets + " rows in set\n");
    }
    
    public final void addPets() {
    	
    	System.out.println("\n\n");
    	System.out.println("add pet (name age):");
        Scanner sc = new Scanner(System.in); 
        
        // String input 
        String mynewpet = sc.nextLine();
        // new to chop of mynewpet to get name and age as separate values
        // split off of space char.
        String[] arrayofpetdata = mynewpet.split(" ", 2);
        
        
        final String name=arrayofpetdata[0];
        final String age=arrayofpetdata[1];
        System.out.printf("name: " + name + " age: " + age);

        
        
        
        final ArrayList<String[]> localpets = new ArrayList<String[]>();
        //action.add(new String[2]);

    	//ArrayList<String>[] localpets = new ArrayList<String>();
    	
    	String[] arr1 = { "bubba", "8" };
    	String[] arr2 = { "babba", "7" };
    	
/*        aListArrays.add(new String[]{"element1"});
        aListArrays.add(new String[]{"element1", "element2"});
        aListArrays.add(new String[]{"element1", "element2", "element3"});
*/


		// localpets.add(name, age);

    	localpets.add(new String[] {name, age});
    	//localpets.add(age);
    	// printing list of String arrays in the ArrayList
    	// from here: https://stackoverflow.com/questions/3642205/java-arraylist-of-arrays
        for( int i = 0; i < localpets.size(); i++ ) {
            for( int j = 0; j < localpets.get(i).length; j++ )
                System.out.printf(" $ " + localpets.get(i)[j]);

            System.out.println();
        }

        
        System.out.println("0808080808080808080");
        System.out.println(mynewpet);
        System.out.println("0808080808080808080");


    	
    	//String[] pets = {"Fido", "mangy", "dog", "meowmeow"};
    	//for (int i = 0; i < pets.length; i++) {
    	//  System.out.println(pets[i]);
    //	}
    	System.out.println("\n\n");

    }

}


