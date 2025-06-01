package CodProba2;

import net.datastructures.*;

public class MAPE {
    public static void main(String[] args) {
        String[] tablou = {"Valoare1", "Valoare2", "Valoare3", "Valoare4"};
        ArrayStack<String> stiva = new ArrayStack<>();
        ArrayQueue<String> coada = new ArrayQueue<>();

        for (int i = 0; i < 3; i++)
            stiva.push(tablou[i]);
        for (int i = tablou.length - 1; i > tablou.length - 4; i--)
            coada.enqueue(tablou[i]);

        Map<String, Character> map = reuniune(stiva, coada);
        for (Entry<String, Character> entry : map.entrySet()) {
            System.out.println("Cheie: " + entry.getKey() + ", Valoare: " + entry.getValue());}
    }
    // INTERSECT MAPE
    public static Map<String, Character> intersecti(ArrayStack<String> stiva, ArrayQueue<String> coada) {
        ArrayList<String> lstStiva = new ArrayList<>();
        ArrayList<String> lstCoada = new ArrayList<>();

        while (!stiva.isEmpty())
            lstStiva.add(lstStiva.size(), stiva.pop());

        while (!coada.isEmpty())
            lstCoada.add(lstCoada.size(), coada.dequeue());

        Map<String, Character> rezultat = new UnsortedTableMap<>();
        for (String element : lstStiva) {
            for (String element2 : lstCoada) {
                if (element.equals(element2)) {
                    rezultat.put(element, element.charAt(element.length() - 1));
                    break;
                }}}
        return rezultat;
    }

    //REUNIUNE MAPE
    public static Map<String, Character> reuniune(ArrayStack<String> stiva, ArrayQueue<String> coada){
        ArrayList<String> lstStiva = new ArrayList<>();
        ArrayList<String> lstCoada = new ArrayList<>();

        while (!stiva.isEmpty())
            lstStiva.add(lstStiva.size(), stiva.pop());

        while (!coada.isEmpty())
            lstCoada.add(lstCoada.size(), coada.dequeue());

        Map<String,Character> rezultat = new UnsortedTableMap<>();
        for (String element:lstStiva)
            if (rezultat.get(element) == null)
                rezultat.put(element, element.charAt(element.length() - 1));
        for (String element:lstCoada)
            if (rezultat.get(element) == null)
                rezultat.put(element, element.charAt(element.length() - 1));

        return rezultat;
    }

    //DIFERENTA PRIMEI LISTE FATA DE A DOUA intr-o mapa
    public static Map<String, Character> diferenta(ArrayStack<String> stiva, ArrayQueue<String> coada){
        ArrayList<String> lstStiva = new ArrayList<>();
        ArrayList<String> lstCoada = new ArrayList<>();

        while (!stiva.isEmpty())
            lstStiva.add(lstStiva.size(), stiva.pop());

        while (!coada.isEmpty())
            lstCoada.add(lstCoada.size(), coada.dequeue());

        Map<String, Character> rezultat = new UnsortedTableMap<>();
        for (String element : lstStiva) {
            boolean gasitInL2 = false;
            for (String item : lstCoada) {
                if (element.equals(item)) {
                    gasitInL2 = true;
                    break;}}
            if (!gasitInL2)
                rezultat.put(element, element.charAt(element.length() - 1));}
        return rezultat;
    }


}
