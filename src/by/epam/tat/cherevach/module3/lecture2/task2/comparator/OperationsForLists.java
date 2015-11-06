package by.epam.tat.cherevach.module3.lecture2.task2.comparator;

import java.util.*;

public class OperationsForLists {

	List<Integer> myArrayList = new ArrayList<Integer>();
	LinkedList<Integer> myLinkedList = new LinkedList<Integer>();

	Random randomElement = new Random();
	Long beginFirst, endFirst;
	Long beginLast, endLast;

	public Long getTimeForAddToList(List<Integer> list, int size) {
		beginFirst = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			list.add(randomElement.nextInt(50000));
		}
		endFirst = System.currentTimeMillis();
		Long result = endFirst - beginFirst;

		return result;
	}

	public Long getTimeForSearch(List<Integer> list, int size, int searchElement) {
		beginFirst = System.currentTimeMillis();
		for (Integer elementList : list) {
			if (elementList.equals(searchElement)) {
			break;
			}
		}
	
		endFirst = System.currentTimeMillis();
		Long result = endFirst - beginFirst;

		return result;
	}

	public Long getTimeForRemoveList(List<Integer> list, int size) {
		beginFirst = System.currentTimeMillis();
		list.removeAll(list);
		endFirst = System.currentTimeMillis();
		Long result = endFirst - beginFirst;
		
		return result;
	}
}