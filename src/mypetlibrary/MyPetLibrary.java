package mypetlibrary;

import java.util.*;


public class MyPetLibrary {
	

	
	// I referenced this to get start of making an Arraylist of Objects:
	// https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
	
	
	public static void main(String[] args) {
		
		boolean exitnow = false;

	    	
	    	System.out.println("Pet Database Program.\n");
	    	ArrayList<PetLibrary> petlist = new ArrayList<PetLibrary>();
	    	
	    	// Use these to seed the list to make testing faster
	 	   	petlist.add(new PetLibrary("boomer", 2));
	 	   	petlist.add(new PetLibrary("fifi", 2));
	 	   	petlist.add(new PetLibrary("bubba", 5));
	 	   	
	 	   do {
				
	 			displayMenu();
	 			
	 	        Scanner sc = new Scanner(System.in); 
	 	     
	 	        // String input 
	 	        String choice = sc.nextLine(); 
	 			
	 	 			
	 			switch (choice) {
	 			  case "1":
	 			    displayPets(petlist);
	 			    break;
	 			  case "2":
	 			    addPets(petlist);
	 			    break;
	 			  case "3":
	 			    updatePetById(petlist);
	 			    break;
	 			  case "4":
	 				removePetById(petlist);
	 			    break;
	 			//case "5":
		 		//	System.out.println("searchbyname");
	 				//searchPetsByName(petlist);
	 			//    break;
	 			//  case "6":
		 		//	System.out.println("searchpetsbyage");
	 				//searchPetsByAge(petlist);
	 			//    break;
	 			  case "7":
	 			    System.out.println("\nGoodbye!");
	 			    //(pets, datafile);
	 			    exitnow=true;
	 			    break;
	 			}
	 		} while (!exitnow);
	 				
     
	 	   	//for(PetLibrary str: petlist){
	 	   		//System.out.println(java.util.Arrays.toString(str));
	 	   		//System.out.println(Arrays.deepToString(str));
	 	    //		System.out.println("Name: " + str.name + " Age: " + str.age);
	 	   	//}   
	}
	
	

	public static void displayMenu() {
		System.out.println("\nWhat would you like to do?");
		System.out.println(" 1) View all pets");
		System.out.println(" 2) Add more pets");
		System.out.println(" 3) Update an existing pet (doesn't enforce error checking that add does)");
		System.out.println(" 4) Remove an existing pet");
		//System.out.println(" 5) Search pets by name");
		//System.out.println(" 6) Search pets by age");
		System.out.println(" 7) Exit program");
		System.out.println("Your choice: ");
	}
	
	
	
    // displayPets, allows users to display list of pets we are tracking
    public static void displayPets(ArrayList<PetLibrary> mypets) {
    	String name = "";
    	String age = "";
    	String border="+------------------------+";
    	
    	
    	displayHeader();
						
		// TODO 
		// There has to be a better way to do this, but this is what I have so far,  
		// can work on it in future releases.	
		// rows
		int numberofpets = mypets.size();
   		//System.out.println("numpets :" + numberofpets);

		int i=0;
 	   	for(PetLibrary str: mypets){
		    displayPet(i,str.name,str.age);
 	   		i++;
 	   	}   
        displayFooter(numberofpets);
    }
    
    
    // addPets, allows user to add pet name and age to arraylist
    public static void addPets(ArrayList<PetLibrary> mypets) {
    	
    	// TODO, Have to work on formatting,  I have newlines in diff places to make it pretty.
    	System.out.println("\n\n");
    	
    	String name="";
    	String age="";
    	int intage=0;
    	int petsadded=0;
    	
    	do { 
    		
    		//if number of pets in array reaches five, dont allow any more to be added
    		if (mypets.size() >= 5) {
    	        System.out.println("Error: database is full.\n");
    	        break;
    		}
    		
	    	System.out.println("add pet (name age):");
	        Scanner scanner = new Scanner(System.in);
	        name="";
	        age="0";
	        intage=0;
	        
	        // get new pet from user 
	        String mynewpet = scanner.nextLine(); 
	        // chop up mynewpet to get name and age as separate values
	        // split off of space char.
	        // TODO,  add more validation logic to make user enter data in correct format.
	        //  I found the split reference here: https://www.geeksforgeeks.org/split-string-java-examples/
	        String[] arrayofpetdata = mynewpet.split(" ", 2);
	                
	        name=arrayofpetdata[0];
	              
        	//System.out.println("name : (" + name + ")" ); 

	        // 'done' is keyword to stop entering pets
	        if (name.equals("done")) {
	        	System.out.println("done entering pets\n");
	        	break;
	        }
	        

	        // need better logic, I know there is a way to encapsulate all this validation logic into its own method
	        // and you just call it to make this code cleaner.
	        // AND........ if the validation logic is separate, then it can be reused for the updatePetById() too.
	        try {
	        	age = arrayofpetdata[1];
        	
	        	
	        	// This catches if age isnt a valid int.
	        	try {
	        		intage = Integer.parseInt(age);
	        	} catch (NumberFormatException error) {
		        	System.out.println(" Must enter  'name age' ");
	        		System.out.println("Error: (" + age + ") is not a valid age.");	
	        	}
	        	
	        	// Validate age requirements
	        	if (intage < 0 || intage > 20) {
		        	System.out.println(" Must enter  'name age'  [age range: (0..20)] ");
	        		System.out.println("Error: " + intage + " is not a valid age.");	
	        		continue;
	        	}
	        	
	        // This out of bounds will catch if there are aren't 2 elements in the array.
	        } catch (IndexOutOfBoundsException error) {
	        	System.out.println(" Must enter  'name age' ");
        		System.out.println("Error: (" + mynewpet + ") is not a valid input.");	
	        	continue;       	
	        } 
  	
	        // if name is empty, which also catches if the first char is a space
	        if (name.equals("")) {
	        	System.out.println("Error: " + mynewpet + " is not a valid input\n");
	        	continue;
	        }

	        // I referenced a number of places concerning Arraylist, but this was the last one that really got me going
	        // https://www.javacodeexamples.com/java-arraylist-of-arrays-example/1003
    	    
	        // add new value to arraylist
	 	   	mypets.add(new PetLibrary(name,intage));
	    	petsadded++;
	    	
    	} while (true);
    	System.out.println(petsadded + " pets added.\n");
    }
    
    
    // updatePetById - allow user to update an existing pet
    public static void updatePetById(ArrayList<PetLibrary> mypets) {
       	
    	displayPets(mypets);
    	System.out.println("Enter ID of pet you want to update:");
        Scanner scanner = new Scanner(System.in); 
        // get id of pet to update from user 
        String idtoupdate = scanner.nextLine(); 
        
        
    	System.out.println("Enter new name and new age:");
        // get updated pet info from user 
        String updatedpet = scanner.nextLine(); 
        
        // chop up updatedpet to get name and age as separate values
        // split off of space char.
        // TODO,  add more validation logic to make user enter data in correct format.
        //  I found the split reference here: https://www.geeksforgeeks.org/split-string-java-examples/
        String[] arrayofupdateddata = updatedpet.split(" ", 2);
                
        // TODO - error checking.
        String newname=arrayofupdateddata[0];
        String newage=arrayofupdateddata[1];
    	
        int id = Integer.parseInt(idtoupdate);
        int intage = Integer.parseInt(newage);

            
        // save pet that is to be updated so we can display it
        PetLibrary pet = mypets.get(id);

        // update values at location id
 	   	mypets.set(id, new PetLibrary(newname, intage));
    	
 	   	System.out.println("\n" + pet.name + " " + pet.age + " changed to: " + updatedpet);

    }
    
    // removePetById - allow user to remove a pet
    public static void removePetById(ArrayList<PetLibrary> mypets) {
        
    	int id=-1;
    	displayPets(mypets);
    	System.out.println("Enter ID of pet you want to remove:");
        Scanner scanner = new Scanner(System.in); 
        // get id of pet to update from user 
        String idtoremove = scanner.nextLine();   
        
        try {
        id = Integer.parseInt(idtoremove);
        } catch (NumberFormatException error) {
        	System.out.println(idtoremove  + "  is not a valid integer\n");
            return;
        }
               
        
        try {
        	// save pet to be removed
        	PetLibrary pet = mypets.get(id);
            // remove entry at location id
        	mypets.remove(id);
        	System.out.println(pet.name + " has been removed");
        } catch (IndexOutOfBoundsException error) {
        	System.out.println("ID (" + id + ") does not exist\n");
            return;		
        }

    	

    }    

    public static void displayPet(int id, String name, int age) {	   	
        System.out.printf("|%3.3s | %-10.10s | %4.4s |\n", id, name, age);
    }
   
    public static void displayHeader() {	
    	
    	String border="+------------------------+";
    	
		System.out.println("\n" + border);
        System.out.printf("|%3.3s | %-10.10s | %4.4s |\n", "ID", "NAME", "AGE");
		System.out.println(border);
    }
    
    public static void displayFooter(int rows) {	
    	
    	String border="+------------------------+";
    	
		System.out.println(border);
		System.out.println(rows + " rows in set\n");
    }


}