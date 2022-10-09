package com.cracking.datastructure;

public class GraphNode {
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
		result = prime * result + data;
		result = prime * result + edge;
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
		if (data != other.data)
			return false;
		if (edge != other.edge)
			return false;
		return true;
	}


	
	
}
