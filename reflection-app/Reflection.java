package com.aurionpro.model;

import java.lang.reflect.*;

public class Reflection {
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static void getMethods(Class className) {
		Method[] methods = className.getDeclaredMethods();
		System.out.println(ANSI_GREEN_BACKGROUND + "Methods of " +className+ ANSI_RESET);
		for(Method m : methods) {
			String names = m.getName();
			System.out.println(names);
		}
	}
	
	public static void getFields(Class className){
		Field[] field = className.getDeclaredFields();
		System.out.println(ANSI_GREEN_BACKGROUND + "\nFields of " +className+ ANSI_RESET);
		for(Field f : field) {
			System.out.println("Name: " + f.getName());
			System.out.println("Type: " + f.getType());
			int mod = f.getModifiers();
			System.out.println("Modifier: " +Modifier.toString(mod));
			System.out.println("-------------------");
			
		}
	}

}
