package com.aurionpro.test;


import java.util.Arrays;
import java.util.List;

import com.aurionpro.model.CustomLinkedList;

public class CustomLinkedListTest {

	
	public static void main(String[] args) {
		CustomLinkedList list = new CustomLinkedList();
		
		System.out.println("-------Inserting normally-------");
		list.insert(20);
		list.insertHead(10);
		list.insert(30);
		list.insert(40);
		list.display();
		System.out.println("----------------------------------------");
		
		System.out.println("-----Inserting node at given index -----");
		list.insertNodeAt(3, 50);
		list.display();
		
		System.out.println("-----Removing particular value-----");
		list.remove(50);
		list.display();
		System.out.println("----------------------------------------");
		
		System.out.println("-----Removing node of given index-----");
		list.removeNodeAt(2);
		list.display();
		System.out.println("----------------------------------------");
		
//		List<CustomLinkedList> arrayList = Arrays.asList(list);
//		for(CustomLinkedList item:arrayList) {
//			System.out.println(item.);
//		}
	}

}
