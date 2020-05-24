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


public class PetLibrary {
	
	String name;
	int age;
	private boolean exitnow = false;

	public 	PetLibrary(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
    public String getPetname() {
        return name;
    }
    public void setPetname(String name) {
    	this.name = name;
    } 
    public int getPetage() {
    	return age;
    }
    public void setPetage(int age) {
    	this.age = age;
    }	
}