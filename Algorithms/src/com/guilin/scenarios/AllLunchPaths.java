package com.guilin.scenarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


/*
 * I assume Peggy's house is one node, Sam's house is another one node
 * 
 * Notes:
 * The start point will always be Peggy's house
 * The end point will always be Sam's house
 * 
 * Algorithm: find all possible paths from Peggy's house to Sam's house (Graph Search + DFS), this may be optimized by DP by memorizing each node whether it is traversed or not
 * 1) start from Peggy's house as first node for initiating a path
 * 2) add next node that can be walked from the first node (Peggy's house), then delete this record (make sure it will choose another path starting from Peggy's house at next round)
 * 3) continue adding next node that can be walked from last node which is added at last round
 * 4) after the path is built, check whether the last node is Sam's house; if yes, remember all nodes at the path; if no, discard this path;
 * 5) repeat step 1 to step 4 until all the starting points (Peggy's house) are deleted
 * 6) store nodes for all paths which last node is Sam's house
 * 7) remove the duplicated nodes and print out
 * 
 */
public class AllLunchPaths {

	public static void main(String[] args) {
		
		// Build Sample Map that we already have - can be read from std or files too
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "a1 b1");
		map.put("2", "a2 b1");
		map.put("3", "a2 b2");
		map.put("4", "a2 b3");
		map.put("5", "b1 c1");
		map.put("6", "b2 c2");
		map.put("7", "b2 c3");
		map.put("8", "b3 c3");
		
		//Build avoid points - can be read from std or files too
		ArrayList<String> avoidPoints = new ArrayList<String>();
		avoidPoints.add("b2");
		
		//Peggy's start point (start Point in graph)
		String startPoint = "a2";
		
		//Sam's start points (end Point in graph)
		String endPoint = "c3";
		
		AllLunchPaths allLunchPaths = new AllLunchPaths();
		HashSet<String> results = allLunchPaths.startRunning(map, avoidPoints, startPoint, endPoint);
		
		//Print out
		for (String lunchLocation : results){
			System.out.print(lunchLocation + "\t");;
		}
		
	}
	
	private HashSet<String> startRunning(Map<String, String> map,ArrayList<String> avoidPoints, String startPoint, String endPoint){
		ArrayList<String> allNodesWithDuplicates = new ArrayList<String>();
		HashSet<String> allNodesWithoutDuplicates = new HashSet<String>();
		
		//Store all the nodes
		allNodesWithDuplicates = AllLunchPaths.buildAllPathPoints(map, avoidPoints, startPoint, endPoint);
		//remove duplicates
		allNodesWithoutDuplicates = AllLunchPaths.removeDuplicateNodes(allNodesWithDuplicates);
		
		return allNodesWithoutDuplicates;
	}
	
	private static ArrayList<String> buildAllPathPoints(Map<String, String> map,ArrayList<String> avoidPoints, String startPoint, String endPoint){
		ArrayList<String> resultNodes = new ArrayList<String>();
		ArrayList<String> onePath = new ArrayList<String>();
		int index = AllLunchPaths.calculateStartingPathNumbers(map, startPoint); //whether loop map or not
		boolean firstStart = true;
		String[] twoPoints = new String[2]; // Temporally hold one line input
		
		while (index > 0 ) {
			
			onePath.add(startPoint);//Add Peggy's location as the first node
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {

				Map.Entry<String, String> pairs = (Map.Entry<String, String>) iterator.next();
				
				twoPoints = AllLunchPaths.splitString(pairs.getValue());
				
				if (!avoidPoints.contains(twoPoints[1])){
					if (twoPoints[0].equals(startPoint) && !avoidPoints.contains(twoPoints[1]) && firstStart){// add second node and delete the record
						onePath.add(twoPoints[1]);
						iterator.remove();
						firstStart = false;
					} else if (twoPoints[0].equals(onePath.get(onePath.size() - 1))) {// follow the map to build one path, and do not add the avoiding points at the same time
						onePath.add(twoPoints[1]);
					}
				}
			}
			
			if (onePath.get(onePath.size() - 1).equals(endPoint)){ // if the last point of path is Sam's house, store all nodes for this path
				for (int i = 0; i <= onePath.size() - 1; i++){
					resultNodes.add(onePath.get(i));
				}
			}
			
			onePath.clear();
			firstStart = true;
			index--;
		}
		
		return resultNodes;
	}
	
	private static HashSet<String> removeDuplicateNodes(ArrayList<String> duplicateNodes){
		HashSet<String> resultNodes = new HashSet<String>();
		resultNodes.addAll(duplicateNodes);		
		return resultNodes;
	}
	
	private static int calculateStartingPathNumbers(Map<String, String> map, String startPoint){
		int result = 0;		
		String[] twoPoints = new String[2];
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> pairs = (Map.Entry<String, String>) iterator.next();
			twoPoints = AllLunchPaths.splitString(pairs.getValue());
			if (twoPoints[0].equals(startPoint)){
				result++;
			}
		}
		return result;
	}
	
	private static String[] splitString(String str){
		String [] result = new String [2];
		result = str.split(" ");
		
		return result;
	}

}
