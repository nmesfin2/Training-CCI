package com.cracking.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyGraph {
	class GraphNode{
		private int data;
		private boolean isVisited;
		private int edge;
		
		public GraphNode(int val) {
			// TODO Auto-generated constructor stub
			this.data = val;
			this.isVisited = false;
			this.edge = 0;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public boolean isVisited() {
			return isVisited;
		}

		public void setVisited(boolean isVisited) {
			this.isVisited = isVisited;
		}

		public int getEdge() {
			return edge;
		}

		public void setEdge(int edge) {
			this.edge = edge;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + data;
			result = prime * result + edge;
			result = prime * result + (isVisited ? 1231 : 1237);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GraphNode other = (GraphNode) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (data != other.data)
				return false;
			if (edge != other.edge)
				return false;
			if (isVisited != other.isVisited)
				return false;
			return true;
		}

		private MyGraph getEnclosingInstance() {
			return MyGraph.this;
		}
		
		
		
	}

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
				System.out.print(k.data + " ");
			}
			System.out.println();
			
		}
		
	}
}
