package CodProba2.Subiecte;

import net.datastructures.*;

import java.util.Iterator;

public class S7Ex1 {
    public static void main(String[] args) {
        Integer[]tablou={24,11,25,14,32,35,8,5,40,17,35,10};
        ArrayStack<Integer>stiva= new ArrayStack<>();
        LinkedPositionalList<Integer>lista=new LinkedPositionalList<>();
        for(int i=0;i<tablou.length;i++){
            if(tablou[i]%2!=0){
            stiva.push(tablou[i]);}}
        for(int i=0;i<tablou.length;i++){
            if(tablou[i]%2==0){
                lista.addLast(tablou[i]);}}
        System.out.println(stiva);
        Map<Integer,Integer>rez= reuniune(stiva,lista);
        for(Entry<Integer,Integer>entry:rez.entrySet()){
            System.out.println("Cheie: " + entry.getKey() + ", Valoare: " + entry.getValue());
        }

    }
    public static Map<Integer,Integer>reuniune(ArrayStack<Integer>s, LinkedPositionalList<Integer>l){
        ArrayList<Integer>lstLista= new ArrayList<>();
        ArrayList<Integer>lstStiva= new ArrayList<>();
        Iterator<Integer>iterator=l.iterator();
        while (iterator.hasNext())
            lstLista.add(lstLista.size(),iterator.next());
        while (!s.isEmpty())
            lstStiva.add(lstStiva.size(),s.pop());
        Map<Integer,Integer>rezultat= new UnsortedTableMap<>();
        for(Integer element:lstStiva)
            if(rezultat.get(element)==null)
                rezultat.put(element,element/3);
        for(Integer element:lstLista)
            if(rezultat.get(element)==null)
                rezultat.put(element,element/3);
        return rezultat;

    }
}
