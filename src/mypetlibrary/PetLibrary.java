package mypetlibrary;

import java.io.Console; 
  
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


// Got this from here: https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
// There were getters and setters, but dont know what to do with them, (and I read in a few places that you dont need getters and setters,
//  So I need to learn more..

public class PetLibrary {
	
	String name;
	int age;
	private boolean exitnow = false;

	public 	PetLibrary(String name, int age) {
		this.name = name;
		this.age = age;
	}
}