package com.dh.sort.graph;

import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class Graph001 {
	// 有向有权图的邻接表表示
	private LinkedList<Edge> adj[]; // 邻接表

	@SuppressWarnings("unused")
	private int v; // 顶点个数

	public Graph001(int v) {
		this.v = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			this.adj[i] = new LinkedList<>();
		}
	}

	public void addEdge(int s, int t, int w) { // 添加一条边
		this.adj[s].add(new Edge(s, t, w));
	}

	@SuppressWarnings("unused")
	private class Edge {

		public int sid; // 边的起始顶点编号

		public int tid; // 边的终止顶点编号

		public int w; // 权重

		public Edge(int sid, int tid, int w) {
			this.sid = sid;
			this.tid = tid;
			this.w = w;
		}

	}

	// 下面这个类是为了 dijkstra 实现用的
	@SuppressWarnings("unused")
	private class Vertex {

		public int id; // 顶点编号 ID

		public int dist; // 从起始顶点到这个顶点的距离

		public Vertex(int id, int dist) {
			this.id = id;
			this.dist = dist;
		}
	}

}
