package com.abc;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph2 {
  private LinkedList<Integer> adjLists[];
  private int v;

  // Graph creation
  Graph2(int vertices) {
    adjLists = new LinkedList[vertices];
   // visited = new boolean[vertices];
v=vertices;
    for (int i = 0; i < vertices; i++)
      adjLists[i] = new LinkedList<Integer>();
  }

  // Add edges
  void addEdge(int src, int dest) {
    adjLists[src].add(dest);
  }
  // DFS algorithm
  void DFSutil(int i,boolean visited[]) {
	    visited[i] = true;
	    System.out.print(i + " ");

	    Iterator<Integer> ite = adjLists[i].listIterator();
	    while (ite.hasNext()) {
	      int adj = ite.next();
	      if (!visited[adj]) 
	    	  DFSutil(adj,visited);
	    }
  }
	    void DFS() {
		    boolean visited[]= new boolean[v];

		    for(int j=0;j<v;j++) {
		    	if (visited[j] == false)
		    	 DFSutil(j,visited);
		    	    	 
		    }
	  }
  

 
 
  

  public static void main(String args[]) {
    Graph2 g = new Graph2(7);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 7);
    g.addEdge(2, 4);
    g.addEdge(2, 5);
    g.addEdge(1, 6);
    

    System.out.println("Following is Depth First Traversal");

    //g.DFS(2);
    g.DFS();
  }
}
