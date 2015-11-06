package by.epam.tat.cherevach.module3.lecture2.task2.comparator;

import java.util.*;

public class ComparatorRunner {

	private static Scanner scanner;

	public static void main(String[] args) {
		boolean repeat = true;
		
		while (repeat) {
			System.out.println("\nFor ArrayList vs LinkedList comparison, please enter '1'");
			System.out.println("For HashSet vs TreeSet comparison, please enter '2'");
			System.out.println("For HashMap vs TreeMap comparison, please enter '3'");
			System.out.println("To exit, please enter '0'");

			scanner = new Scanner(System.in);
			int action = scanner.nextInt();

			switch (action) {
			case 0:
				repeat = false;
				System.out.println("See you soon!");
				break;

			case 1:
				ArrayListVsLinkedList myList = new ArrayListVsLinkedList ();
				myList.comparatorArrayListAndLinkedList();
				break;

			case 2:
				HashSetVsTreeSet mySet = new HashSetVsTreeSet();
				mySet.comparatorHashSetAndTreeSet();
				break;

			case 3:
				HashMapVsTreeMap myMap = new HashMapVsTreeMap();
				myMap.comparatorHashMapAndTreeMap();
				break;

			default:
				System.out.println("Unexpected value, please try again");
				break;

			}
		}
	}
}
