package by.epam.tat.cherevach.module3.lecture2.task2.comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Random;

public class OperationsForMap {

	HashMap<Integer, Integer> myHashMap = new HashMap<Integer, Integer>();
	TreeMap<Integer, Integer> myTreeMap = new TreeMap<Integer, Integer>();

	Random randomElement = new Random();
	Long beginFirst, endFirst;
	Long beginLast, endLast;

	public Long getTimeForAddToMap(Map<Integer, Integer> map, int size) {
		beginFirst = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			map.put(randomElement.nextInt(50000), randomElement.nextInt(50000));
		}
		endFirst = System.currentTimeMillis();
		Long result = endFirst - beginFirst;

		return result;
	};

	public Long getTimeForSearch(Map<Integer, Integer> map, int size,
			int searchElement) {
		beginFirst = System.currentTimeMillis();

		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		for (Map.Entry<Integer, Integer> elementSet : set) {
			if (elementSet.getValue().equals(searchElement)) {
								break;
			}
		}
	
		endFirst = System.currentTimeMillis();
		Long result = endFirst - beginFirst;

		return result;
	}

	public Long getTimeForRemoveMap(Map<Integer, Integer> map, int size) {
		beginFirst = System.currentTimeMillis();
		map.clear();
		endFirst = System.currentTimeMillis();
		Long result = endFirst - beginFirst;

		return result;
	}
}
