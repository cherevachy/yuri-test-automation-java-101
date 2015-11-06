package by.epam.tat.cherevach.module3.lecture2.task2.comparator;

import java.util.TreeSet;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class OperationsForSets {

	HashSet<Integer> myHashSet = new HashSet<Integer>();
	TreeSet<Integer> myTreeSet = new TreeSet<Integer>();

	Random randomElement = new Random();
	Long beginFirst, endFirst;
	Long beginLast, endLast;

	public Long getTimeForAddToSet(Set<Integer> set, int size) {
		beginFirst = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			set.add(randomElement.nextInt(50000));
		}
		endFirst = System.currentTimeMillis();
		Long result = endFirst - beginFirst;

		return result;
	}

	public Long getTimeForSearch(Set<Integer> set, int size, int searchElement) {
		beginFirst = System.currentTimeMillis();
		for (Integer elementSet : set) {
			if (elementSet.equals(searchElement)) {
							break;
			}
		}

		endFirst = System.currentTimeMillis();
		Long result = endFirst - beginFirst;

		return result;
	}

	public Long getTimeForRemoveSet(Set<Integer> set, int size) {
		beginFirst = System.currentTimeMillis();
		set.removeAll(set);
		endFirst = System.currentTimeMillis();
		Long result = endFirst - beginFirst;
		
		return result;
	}
}
