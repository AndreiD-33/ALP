package CodProba2;

import net.datastructures.*;

import java.util.Comparator;

public class GRAFURI {
    public static void main(String[] args) {
        String[] elementeStiva = {"SIA1", "SDBIS1", "IE3", "SIA2", "SIA1", "IE1"};
        Graph<String, Integer> graf = new AdjacencyMapGraph<>(true);
        Map<String, Vertex<String>> mapa = new UnsortedTableMap<>();
        for (int i = 0; i < elementeStiva.length; i++) {
            Vertex<String> v = graf.insertVertex(elementeStiva[i]);
            mapa.put(elementeStiva[i], v);
        }
        graf.insertEdge(mapa.get("SIA1"), mapa.get("SDBIS1"), 1);
        graf.insertEdge(mapa.get("SDBIS1"), mapa.get("IE3"), 1);
        graf.insertEdge(mapa.get("IE3"), mapa.get("SIA2"), 1);
        graf.insertEdge(mapa.get("SIA2"), mapa.get("SIA1"), 1);
        graf.insertEdge(mapa.get("SIA1"), mapa.get("IE1"), 1);
        graf.insertEdge(mapa.get("SIA2"), mapa.get("SDBIS1"), 1);
        graf.insertEdge(mapa.get("IE3"), mapa.get("IE1"), 1);
        graf.insertEdge(mapa.get("IE1"), mapa.get("SIA2"), 1);

        Vertex<String> varf = getVarf(graf, "SIA2");
        Map<Vertex<String>, Integer> kn = new UnsortedTableMap<>();
        Map<Vertex<String>, Edge<Integer>> fr = new UnsortedTableMap<>();

        DFS(graf, varf, kn, fr, 0, 3);
        for (Vertex<String> v : kn.keySet())
            System.out.println(v.getElement() + " , " + kn.get(v));

        BFS(graf, varf, kn, fr, 3);
        for (Vertex<String> v : kn.keySet())
            System.out.println("BFS.............." + v.getElement() + " , " + kn.get(v));

        Map<Vertex<String>, Integer> tabelaDrumMinim = minPath(graf, varf);
        for(Vertex<String> destinatie : tabelaDrumMinim.keySet())
          System.out.print(destinatie.getElement()+" " + tabelaDrumMinim.get(destinatie)+ " , ");

    }

    public static Vertex<String> getVarf(Graph<String, Integer> g, String eticheta) {
        Vertex<String> rezultat = null;
        for (Vertex<String> v : g.vertices())
            if (v.getElement().equals(eticheta))
                rezultat = v;
        return rezultat;
    }

    static void DFS(Graph<String, Integer> g, Vertex<String> u, Map<Vertex<String>, Integer> known,
                    Map<Vertex<String>, Edge<Integer>> forest, int depth, int maxDepth) {
        if (depth >= maxDepth) return;
        known.put(u, depth);
        for (Edge<Integer> e : g.outgoingEdges(u)) {
            Vertex<String> v = g.opposite(u, e);
            if (known.get(v) == null) {
                forest.put(v, e);
                DFS(g, v, known, forest, depth + 1, maxDepth);
            } else {
                known.put(v, known.get(v) + 1);
            }
        }
    }
    static void BFS(Graph<String, Integer> g, Vertex<String> u, Map<Vertex<String>, Integer> known,
                    Map<Vertex<String>, Edge<Integer>> forest, int maxDepth) {
        known.put(u, 0);
        LinkedPositionalList<Vertex<String>> level = new LinkedPositionalList<>();
        level.addLast(u);
        int depth = 0;
        while (!level.isEmpty() && depth < maxDepth) {
            LinkedPositionalList<Vertex<String>> nextLevel = new LinkedPositionalList<>();
            for (Vertex<String> node : level) {
                for (Edge<Integer> e : g.outgoingEdges(node)) {
                    Vertex<String> v = g.opposite(node, e);
                    if (known.get(v) == null) {
                        known.put(v, depth + 1);
                        nextLevel.addLast(v);
                        forest.put(v, e);
                    }}}
            level = nextLevel;
            depth++;
        }
    }
    static class ComparatorPQ implements Comparator<Vertex<String>> {
        Map<Vertex<String>, Integer> d;
        public ComparatorPQ(Map<Vertex<String>, Integer> d) {
            this.d = d;
        }
        @Override
        public int compare(Vertex<String> v1, Vertex<String> v2) {
            return d.get(v1).compareTo(d.get(v2));
        }
    }

    public static Map<Vertex<String>, Integer> minPath(Graph<String, Integer> g, Vertex<String> src) {
        Map<Vertex<String>, Integer> d = new UnsortedTableMap<>();
        Map<Vertex<String>, Integer> cloud = new UnsortedTableMap<>();
        PriorityQueue<Vertex<String>, Integer> pq = new UnsortedPriorityQueue<>(new ComparatorPQ(d));
        for (Vertex<String> v : g.vertices()) {
            if (v == src)
                d.put(v, 0);
            else
                d.put(v, Integer.MAX_VALUE);
            pq.insert(v, null);
        }
        while (!pq.isEmpty()) {
            Vertex<String> u = pq.removeMin().getKey();
            int du = d.get(u);
            cloud.put(u, du);
            for (Edge<Integer> e : g.outgoingEdges(u)) {
                Vertex<String> v = g.opposite(u, e);
                if (cloud.get(v) == null) {
                    int wgt = e.getElement();
                    if (d.get(u) + wgt < d.get(v)) {
                        d.put(v, d.get(u) + wgt);
                    }}}}
        return cloud;
    }

}
