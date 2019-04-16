package wrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Application {
	public static void main(String[] args) {
		
		// This will show the equality of Integers when promotions occurs
//		for (int i = 0; i < 500; ++i) {
//			Integer a = new Integer(i);
//			Integer b = new Integer(i);
//			
//			if (a != b) {
//				System.out.println(i);
//				break;
//			}
//			
//			//System.out.println(a == b);			
//		}
//		
//		
		int[] arr = {5,6,3, 6,7, 5, 5};
		System.out.println(solveWithSet(arr));
		System.out.println(solveWithMap(arr));
		System.out.println(solveWithSpice(arr));
	}
	
	public static int solveWithSet(int[] arr) {
		Set<Integer> sockSet = new HashSet<Integer>();
		Integer match = 0;
		for(int sock: arr) {
			if (sockSet.contains(sock)) {
				++match;
				sockSet.remove(sock);
			} else {
				sockSet.add(sock);
			}
		}
		return match;
	}
	
	
	public static int solveWithMap(int[] arr) {
		Map<Integer, Integer> sockmap = new HashMap<Integer, Integer>();
		int match = 0;
		for (int sock: arr) {
			if (sockmap.containsKey(sock)) {
				sockmap.put(sock, sockmap.get(sock) + 1);
			} else {
				sockmap.put(sock, 1);
			}
		}
		
		for(int countOfSocks: sockmap.values()) {
			match += countOfSocks / 2;
		}
		
		return match;
	}
	
	public static int solveWithSpice(int[] arr) {
		Map<Integer, Integer> sockmap = new HashMap<Integer, Integer>();
		int match = 0;
		for (int sock: arr) {
			Integer didExist = sockmap.putIfAbsent(sock, 1);
			
			if (didExist != null) {
				sockmap.computeIfPresent(sock, (Integer key, Integer value) -> {
					 return value + 1;
				});
			}
		}
		
		for (Integer value: sockmap.values()) {
			match += value / 2;
		}
		
		return match;
	}
}












