package com.cracking.datastructure;

import java.util.LinkedList;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Stack;

import com.cci.interviewquestions.LInkeListQuestions.Node;

public class MyGraphMain {
	public static void main (String [] args) {
		MyGraph mg = new MyGraph();
		mg.addGraphNode(1);
		mg.addGraphNode(2);
		mg.addGraphNode(3);
		mg.addGraphNode(4);
		mg.addGraphNode(5);
		mg.addGraphNode(6);
		
		mg.addEdge(1, 2, 7);
		mg.addEdge(2, 5, 3);
		mg.addEdge(3, 6, 5);
		mg.addEdge(4, 1, 2);
		mg.addEdge(4, 3, 2);
		mg.addEdge(5, 1, 1);
		
		MyGraph mg2 = new MyGraph();
		mg2.addGraphNode(1);
		mg2.addGraphNode(2);
		mg2.addGraphNode(3);
		mg2.addGraphNode(4);
		mg2.addGraphNode(5);
		mg2.addGraphNode(6);
		  
		mg2.addEdge(1, 5, 7);
		mg2.addEdge(2, 5, 3);
		mg2.addEdge(3, 6, 5);
		mg2.addEdge(4, 1, 2);
		mg2.addEdge(4, 3, 2);
		mg2.addEdge(5, 2, 1);
		
		
		
//		for(GraphNode key: mg.getMyGraph().keySet()) {
//			System.out.println("Node " +key.getData());
//			
//
//			for(GraphNode k : mg.getMyGraph().get(key)) {
//				System.out.print(k.getData() + " ");
//			}
//			System.out.println();
//			
//		}
//		
//		System.out.println("---------------------dfs-----------------------------");
//		GraphNode g2 = new GraphNode(1);
//		mg.dfsSearch(g2);
//
//		System.out.println();
//		System.out.println("---------------------bfs-----------------------------");
//		GraphNode g = new GraphNode(1);
//		mg2.bfsSearch(g);
		
		
		// isConnected 
//		GraphNode a = new GraphNode(1);
//		GraphNode b = new GraphNode(2);
//		
//		System.out.println(isConnected(a, b, mg2));
		
		ArrayList<String> projects = new ArrayList<>();
		projects.add("a");
		projects.add("b");
		projects.add("c");
		projects.add("d");
		projects.add("e");
		projects.add("f");
		
		ArrayList<ArrayList<String>> dependencies = new ArrayList<>();
		ArrayList<String> pair = new ArrayList<>();
		pair.add(0, "a");
		pair.add(1, "d");
		dependencies.add(pair);
		ArrayList<String> pair2 = new ArrayList<>();
		pair2.add(0, "f");
		pair2.add(1, "b");
		dependencies.add(pair2);
		ArrayList<String> pair3 = new ArrayList<>();
		pair3.add(0, "b");
		pair3.add(1, "d");
		dependencies.add(pair3);
		ArrayList<String> pair4 = new ArrayList<>();
		pair4.add(0, "f");
		pair4.add(1, "a");
		dependencies.add(pair4);
		ArrayList<String> pair5 = new ArrayList<>();
		pair5.add(0, "d");
		pair5.add(1, "c");
		dependencies.add(pair5);
		
		System.out.println("--------------- build path ----------------------");
		buildOrder(projects, dependencies);
		
	}
	
	public static boolean isConnected(GraphNode from, GraphNode to, MyGraph graph) {
		Queue myQueue = new LinkedList<GraphNode>();
		if(from == null) {
			return false;
		}
		from.setVisited(true);
		myQueue.add(from);
		
		while(!myQueue.isEmpty()) {
			GraphNode n = (GraphNode) myQueue.poll();
			if(n.getData() == to.getData()) {
				System.out.println(n.getData() + " : " + to.getData());
				return true;
			}
			
			for(GraphNode child : graph.getMyGraph().get(n)) {
				System.out.println("child" + " : " + child.getData());
				if(child.isVisited() == false) {
					if(child.getData() == to.getData()) {
						return true;
					}else {
						child.setVisited(true);
						myQueue.add(child);
					}
				}
				
			}
			
		}
		return false;
	}
	
	//first common ancestor
	public void firstCommonAncestor(Node first, Node second) {
		
	}
	
	private void firstNode(Node first, Node root) {
		if(first == root) {
			return;
		}else {
			
		}
		
		
	}
	//build order 
	public static void buildOrder(ArrayList<String> projects, ArrayList<ArrayList<String>> dependencies) {
		Stack<String> stack = new Stack<>();
		Map<String, Boolean> visitedTracker = new HashMap<>();
		for(String project: projects) {
			visitedTracker.put(project, false);
		}
		for(int i = 0; i < projects.size(); i++) {
			stack = buildOrderHelp(projects.get(i), dependencies, visitedTracker, stack);		
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + ", " );
			
		}
	}
	
	// order Projects
	Stack<String> orderProjects(ArrayList<String> projects){
		Stack<String> stack = new Stack<>();
		for(String project: projects) {
			return null;
		}
		return null;
	}
	
	// dfs build
	private static Stack buildOrderHelp(String project, ArrayList<ArrayList<String>> dependencies, Map<String, Boolean> visitedTracker, Stack <String>s) {
		if(project == null) {
			return null;
		}
		visitedTracker.put(project, true);
		
		s.push(project);
		for(ArrayList<String> pair: dependencies) {
			if(pair.get(1) == project && !visitedTracker.get(pair.get(0)) && !visitedTracker.get(pair.get(1))) {
				//System.out.print(project + ", + " );
				 buildOrderHelp(pair.get(0), dependencies, visitedTracker, s);
				
			}
			
		}
		//System.out.print(project + ", ");
		return s;
	}
	
}
