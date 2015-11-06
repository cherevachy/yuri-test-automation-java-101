package by.epam.tat.cherevach.module3.lecture2.task2.comparator;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Scanner;
//


public class HashMapVsTreeMap {

	public void comparatorHashMapAndTreeMap() {

		OperationsForMap comparatorMHT = new OperationsForMap();
		String fasterTmText = "TreeMap is faster ";
		String fasterHmText = "HashMap is faster ";
		String timeTmText = "ms. for TreeMap: ";
		String timeHmText = "ms. for HashMap: ";
		String addingText = "at adding an element, time elapsed: ";
		String searchingText = "at searching for the element, time elapsed: ";
		String deletingText = "at deleting the list, time elapsed: ";
		
		int size = 75000;
		HashMap<Integer, Integer> myHashMap = new HashMap<Integer, Integer>();
		TreeMap<Integer, Integer> myTreeMap = new TreeMap<Integer, Integer>();

		Long hashMap = comparatorMHT.getTimeForAddToMap(myHashMap, size);
		Long treeMap = comparatorMHT.getTimeForAddToMap(myTreeMap, size);
		if (hashMap > treeMap) {
			System.out.println(fasterTmText + addingText + treeMap + timeHmText + hashMap + "ms");
		} 
		else {
			System.out.println(fasterHmText + addingText + hashMap + timeTmText + treeMap + "ms");
		}

		System.out.println("Enter some value for HashMap and TreeMap to search for:");
		Scanner inputValue = new Scanner(System.in);
		int searchForNumber = inputValue.nextInt();
		
		hashMap = comparatorMHT.getTimeForSearch(myHashMap, size,
				searchForNumber);
		
		treeMap = comparatorMHT.getTimeForSearch(myTreeMap, size,
				searchForNumber);
		if (hashMap > treeMap) {
			System.out.println(fasterTmText + searchingText + treeMap + timeHmText + hashMap + "ms");
		} 
		else {
			System.out.println(fasterHmText + searchingText + hashMap + timeTmText + treeMap + "ms");
		}
		hashMap = comparatorMHT.getTimeForRemoveMap(myHashMap, size);
		treeMap = comparatorMHT.getTimeForRemoveMap(myTreeMap, size);
		if (hashMap > treeMap) {
			System.out.println(fasterTmText + deletingText + treeMap + timeHmText + hashMap + "ms");
		} 
		else {
			System.out.println(fasterHmText + deletingText + hashMap + timeTmText + treeMap + "ms");
		}
	}
}