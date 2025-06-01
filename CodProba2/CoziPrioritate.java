package CodProba2;

import net.datastructures.*;

import java.util.HashSet;

public class CoziPrioritate {
    public static void main(String[] args) {
        String[] tablou = {"Valoare1", "Valoare2", "Valoare3", "Valoare4"};
        ArrayStack<String> stiva = new ArrayStack<>();
        ArrayQueue<String> coada = new ArrayQueue<>();

        for (int i = 0; i < 3; i++)
            stiva.push(tablou[i]);
        for (int i = tablou.length - 1; i > tablou.length - 4; i--)
            coada.enqueue(tablou[i]);

        PriorityQueue<String, Character> pq = reuniune(stiva, coada);
            while (!pq.isEmpty()) {
                System.out.println("Cheie: " + pq.min().getKey() + ", Valoare: " + pq.min().getValue());
                pq.removeMin();
            }
    }
    // INTERSECT MAPE
    public static PriorityQueue<String, Character> intersecti(ArrayStack<String> stiva, ArrayQueue<String> coada) {
        ArrayList<String> lstStiva = new ArrayList<>();
        ArrayList<String> lstCoada = new ArrayList<>();

        while (!stiva.isEmpty())
            lstStiva.add(lstStiva.size(), stiva.pop());

        while (!coada.isEmpty())
            lstCoada.add(lstCoada.size(), coada.dequeue());

        PriorityQueue<String, Character> rezultat = new SortedPriorityQueue<>();
        for (String element : lstStiva) {
            for (String element2 : lstCoada) {
                if (element.equals(element2)) {
                    rezultat.insert(element, element.charAt(element.length() - 1));
                    break;
                }}}
        return rezultat;
    }
        //DIFERENTA COADA CU PRIORITATI
        public static PriorityQueue<String, Character> diferenta(ArrayStack<String> stiva, ArrayQueue<String> coada) {
            ArrayList<String> lstStiva = new ArrayList<>();
            ArrayList<String> lstCoada = new ArrayList<>();

            while (!stiva.isEmpty())
                lstStiva.add(lstStiva.size(), stiva.pop());

            while (!coada.isEmpty())
                lstCoada.add(lstCoada.size(), coada.dequeue());

            PriorityQueue<String, Character> rezultat = new SortedPriorityQueue<>();
            for (String element : lstStiva) {
                boolean gasitInL2 = false;
                for (String item : lstCoada) {
                    if (element.equals(item)) {
                        gasitInL2 = true;
                        break;
                    }}
                if (!gasitInL2) {
                    rezultat.insert(element, element.charAt(element.length() - 1));
                }}
            return rezultat;
        }
//REUNIUNE COADA PRIORITATE
public static PriorityQueue<String, Character> reuniune(ArrayStack<String> stiva, ArrayQueue<String> coada) {
    PriorityQueue<String, Character> rezultat = new SortedPriorityQueue<>();
    HashSet<String> elementeUnice = new HashSet<>(); // Verificare duplicat

    ArrayList<String> lstStiva = new ArrayList<>();
    ArrayList<String> lstCoada = new ArrayList<>();

    while (!stiva.isEmpty())
        lstStiva.add(lstStiva.size(), stiva.pop());

    while (!coada.isEmpty())
        lstCoada.add(lstCoada.size(), coada.dequeue());

    for (String element : lstStiva) {
        if (elementeUnice.add(element)) {
            rezultat.insert(element, element.charAt(element.length() - 1));
        }}

    for (String element : lstCoada) {
        if (elementeUnice.add(element)) {
            rezultat.insert(element, element.charAt(element.length() - 1));
        }}
    return rezultat;
}
}

