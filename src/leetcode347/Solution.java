package leetcode347;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>(k);
		SortedMap<Integer, Integer> hitCount = new TreeMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int key = nums[i];
			if (hitCount.containsKey(key)) {
				int count = hitCount.get(key);
				count++;
				hitCount.put(key, count);
			} else {
				hitCount.put(key, 1);
			}
		}
		int[][] tmp = new int[k][2];
		// LinkedList<Integer,Integer> tmp = new LinkedList<Integer,Integer>();
		for (Integer key : hitCount.keySet()) {
			int count = hitCount.get(key);
			for (int i = 0; i < k; i++) {
				int value = tmp[i][1];
				if (count >= value) {
					insertPariAtIndex(tmp, key, count, i);
					break;
				} else {
					continue;
				}
			}
		}
		
		for(int i=0;i<k;i++){
			result.add(i,tmp[i][0]);
		}
		return result;
	}

	public static void insertPariAtIndex(int[][] resultSet, int key, int count, int index) {
		int length = resultSet.length;
		for (int i = length - 1; i >= 0 ; i--) {
			if(index == i){
				resultSet[index][0] = key;
				resultSet[index][1] = count;
				break;
			}
			resultSet[i][0] = resultSet[i-1][0];
			resultSet[i][1] = resultSet[i-1][1];
		}
	}

	public static void main(String args[]) {
		Solution s = new Solution();
		int[] input = { 1, 2, 3, 1, 1, 3 };
		for (int i : s.topKFrequent(input, 2)) {
			System.out.print(i+" ");
		}
	}
}