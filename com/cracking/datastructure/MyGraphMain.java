package com.cracking.datastructure;

import java.util.LinkedList;
import java.util.Queue;

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
		GraphNode a = new GraphNode(1);
		GraphNode b = new GraphNode(2);
		
		System.out.println(isConnected(a, b, mg2));
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
	
}
