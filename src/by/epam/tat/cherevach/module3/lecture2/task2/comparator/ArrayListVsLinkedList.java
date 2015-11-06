package by.epam.tat.cherevach.module3.lecture2.task2.comparator;

	import java.util.*;

	public class ArrayListVsLinkedList {
		public void comparatorArrayListAndLinkedList() {

			OperationsForLists comparatAL = new OperationsForLists();
			String fasterAlText = "ArrayList is faster ";
			String fasterLlText = "LinkedList is faster ";
			String timeAlText = "ms. for ArrayList: ";
			String timeLlText = "ms. for LinkedList: ";
			String addingText = "at adding an element, time elapsed: ";
			String searchingText = "at searching for the element, time elapsed: ";
			String deletingText = "at deleting the list, time elapsed: ";
			
			int size = 75000;
			ArrayList<Integer> myArrayList = new ArrayList<Integer>();
			LinkedList<Integer> myLinkedList = new LinkedList<Integer>();

			Long arrList = comparatAL.getTimeForAddToList(myArrayList, size);
			Long linkList = comparatAL.getTimeForAddToList(myLinkedList, size);
			if (arrList > linkList) {
				System.out.println(fasterLlText + addingText + linkList + timeAlText + arrList + "ms");
			} 
			else {
				System.out.println(fasterAlText + addingText + arrList + timeLlText + linkList + "ms");
			}

			System.out.println("Enter some value for ArrayList and LinkedList to search for: ");
			Scanner inputValue = new Scanner(System.in);
			int searchForNumber = inputValue.nextInt();
		
			arrList = comparatAL.getTimeForSearch(myArrayList, size,
					searchForNumber);
		
			linkList = comparatAL.getTimeForSearch(myLinkedList, size,
					searchForNumber);
			if (arrList > linkList) {
				System.out.println(fasterLlText + searchingText + linkList + timeAlText	+ arrList + "ms");
			} 
			else {
				System.out.println(fasterAlText + searchingText	+ arrList + timeLlText + linkList  + "ms");
			}

			arrList = comparatAL.getTimeForRemoveList(myArrayList, size);
			linkList = comparatAL.getTimeForRemoveList(myLinkedList, size);
			if (arrList > linkList) {
				System.out.println(fasterLlText + deletingText + linkList + timeAlText	+ arrList + "ms");
			} 
			else {
				System.out.println(fasterAlText + deletingText + arrList + timeLlText + linkList + "ms");
			}

		}
	}