package CodProba2.Subiecte;

import CodProba2.GRAFURI;
import net.datastructures.*;

import java.util.Arrays;
import java.util.Comparator;

public class S7Ex2 {
    public static void main(String[] args) {
        Integer[]elementeStiva={35, 17, 5, 25, 11};
        Graph<Integer,Integer>graf= new AdjacencyMapGraph<>(true);
        Map<Integer,Vertex<Integer>> mapa=new UnsortedTableMap<>();
        for(int i=0;i<elementeStiva.length;i++){
            Vertex<Integer> v=graf.insertVertex(elementeStiva[i]);
                    mapa.put(elementeStiva[i],v);
        }
        graf.insertEdge(mapa.get(35),mapa.get(17),1);
        graf.insertEdge(mapa.get(17),mapa.get(5),1);
        graf.insertEdge(mapa.get(5),mapa.get(25),1);
        graf.insertEdge(mapa.get(25),mapa.get(11),1);
Vertex<Integer>varf=getVarf(graf,35);
        Map<Vertex<Integer>, Integer> tabelaDrumMinim = minPath(graf, varf);
        for(Vertex<Integer> destinatie : tabelaDrumMinim.keySet())
            System.out.print(destinatie.getElement()+" " + tabelaDrumMinim.get(destinatie)+ " , ");
    }
    public static Vertex<Integer>getVarf(Graph<Integer,Integer>g,Integer eticheta){
        Vertex<Integer>rez=null;
        for(Vertex<Integer>v:g.vertices())
            if(v.getElement().equals(eticheta)){
                rez=v;}
        return rez;
    }
    private static Vertex<Integer> find(Map<Vertex<Integer>, Integer> map) {
        Vertex<Integer> keyMin = null;
        Integer minValue = Integer.MAX_VALUE;
        for (Vertex<Integer> k : map.keySet()) {
            if (map.get(k) < minValue) {
                minValue = map.get(k);
                keyMin = k;
            }}
        return keyMin;}

    public static Map<Vertex<Integer>, Integer> minPath(Graph<Integer, Integer> g, Vertex<Integer> src) {
        Map<Vertex<Integer>, Integer> cloud = new UnsortedTableMap<>();
        Map<Vertex<Integer>, Integer> pq = new UnsortedTableMap<>();
        for (Vertex<Integer> v : g.vertices()) {
            if (v == src)
                pq.put(v, 0);
            else pq.put(v, Integer.MAX_VALUE);}
        while (!pq.isEmpty()) {
            Vertex<Integer> u = find(pq);
            int du = pq.get(u); pq.remove(u);
            cloud.put(u, du);
            for (Edge<Integer> e : g.outgoingEdges(u)) {
                Vertex<Integer> v = g.opposite(u, e);
                if (cloud.get(v) == null) {
                    int wgt = e.getElement();
                    if (du + wgt < pq.get(v)) {
                        pq.put(v, du + wgt);
                    } } } }
        return cloud; }
}

