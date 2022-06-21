package com.aurionpro.test;

import java.lang.reflect.*;

import com.aurionpro.model.*;

public class ReflectionTest {

	public static void main(String[] args) {
		try {
		String name;
		name = args[0];
		
		//Class cls = Class.forName(name);
		Reflection obj = new Reflection();
		
		obj.getMethods(Class.forName(name));
		obj.getFields(Class.forName(name));
		}	
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
			
		
	}

}
