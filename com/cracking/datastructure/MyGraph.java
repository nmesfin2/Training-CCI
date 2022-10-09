package com.cracking.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyGraph {
	private Map<GraphNode, ArrayList<GraphNode>> myGraph;
	
	public MyGraph() {
		// TODO Auto-generated constructor stub
		myGraph = new HashMap<>();
	}
	
	
	
	public Map<GraphNode, ArrayList<GraphNode>> getMyGraph() {
		return myGraph;
	}



	public void setMyGraph(Map<GraphNode, ArrayList<GraphNode>> myGraph) {
		this.myGraph = myGraph;
	}



	public void addGraphNode(int val) {
		GraphNode n = new GraphNode(val);
		ArrayList <GraphNode> s = new ArrayList<>();
		myGraph.putIfAbsent(n, s);
	}
	
	public void addEdge(int firstNode, int secondNode, int edge) {
		GraphNode fNode = new GraphNode(firstNode);
		GraphNode sNode = new GraphNode(secondNode);
		
		myGraph.get(fNode).add(sNode);
	}
	
	public void dfsSearch(GraphNode gn) {
		if(gn == null) {
			return;
		}
		
		System.out.print(gn.getData() + " ");
		gn.setVisited(true);
		
		for(GraphNode g : this.getMyGraph().get(gn)) {
			if(!g.isVisited()) {
				dfsSearch(g);
			}
		}
	}
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
		
		
		for(GraphNode key: mg.getMyGraph().keySet()) {
			System.out.println("Node " +key.getData());
			

			for(GraphNode k : mg.getMyGraph().get(key)) {
				System.out.print(k.getData() + " ");
			}
			System.out.println();
			
		}
		
		System.out.println("---------------------dfs-----------------------------");
//		GraphNode g = new GraphNode(2);
//		mg.dfsSearch(g);
		GraphNode g2 = new GraphNode(1);
		mg.dfsSearch(g2);
	}
}
