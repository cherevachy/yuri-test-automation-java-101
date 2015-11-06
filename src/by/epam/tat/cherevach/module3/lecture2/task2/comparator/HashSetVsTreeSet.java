package by.epam.tat.cherevach.module3.lecture2.task2.comparator;

import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class HashSetVsTreeSet {

	public void comparatorHashSetAndTreeSet() {

		OperationsForSets comparatorHT = new OperationsForSets();
		String fasterTsText = "TreeSet is faster ";
		String fasterHsText = "HashSet is faster ";
		String timeTsText = "ms. for TreeSet: ";
		String timeHsText = "ms. for HashSet: ";
		String addingText = "at adding an element, time elapsed: ";
		String searchingText = "at searching for the element, time elapsed: ";
		String deletingText = "at deleting the list, time elapsed: ";
		
		int size = 75000;
		HashSet<Integer> myHashSet = new HashSet<Integer>();
		TreeSet<Integer> myTreeSet = new TreeSet<Integer>();

		Long hashSet = comparatorHT.getTimeForAddToSet(myHashSet, size);
		Long treeSet = comparatorHT.getTimeForAddToSet(myTreeSet, size);
		if (hashSet > treeSet) {
			System.out.println(fasterTsText + addingText + treeSet + timeHsText + hashSet + "ms");
		} 
		else {
			System.out.println(fasterHsText + addingText + hashSet + timeTsText + treeSet + "ms");
		}

		System.out.println("Enter some value for TreeSet and HashSet to search for:");
		Scanner inputValue = new Scanner(System.in);
		int searchForNumber = inputValue.nextInt();
	
		hashSet = comparatorHT.getTimeForSearch(myHashSet, size,
				searchForNumber);
		
		treeSet = comparatorHT.getTimeForSearch(myTreeSet, size,
				searchForNumber);
			
		if (hashSet > treeSet) {
			System.out.println(fasterTsText + searchingText + treeSet + timeHsText + hashSet + "ms");
		} 
		else {
			System.out.println(fasterHsText + searchingText + hashSet + timeTsText + treeSet + "ms");
		}

		hashSet = comparatorHT.getTimeForRemoveSet(myHashSet, size);
		treeSet = comparatorHT.getTimeForRemoveSet(myTreeSet, size);
		if (hashSet > treeSet) {
			System.out.println(fasterTsText + deletingText + treeSet + timeHsText + hashSet + "ms");
		} 
		else {
			System.out.println(fasterHsText + deletingText + hashSet + timeTsText + treeSet + "ms");
		}
	}
}