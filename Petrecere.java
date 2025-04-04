package backtracking;

public class Petrecere {

    public static int[][] invitati;
    public static int[] v;

    public static void main(String[] args) {
        invitati = new int[5][5];
        invitati[0][0]=0;invitati[0][1]=1;invitati[0][2]=0;invitati[0][3]=1;invitati[0][4]=0;
        invitati[1][0]=1;invitati[1][1]=0;invitati[1][2]=1;invitati[1][3]=0;invitati[1][4]=1;
        invitati[2][0]=0;invitati[2][1]=1;invitati[2][2]=0;invitati[2][3]=0;invitati[2][4]=1;
        invitati[3][0]=1;invitati[3][1]=1;invitati[3][2]=1;invitati[3][3]=0;invitati[3][4]=1;
        invitati[4][0]=0;invitati[4][1]=0;invitati[4][2]=1;invitati[4][3]=1;invitati[4][4]=0;
        v = new int[invitati.length];
        BK(0);
    }

    static void BK(int k) {
        for (int i = 0; i < invitati.length; i++) {
            v[k] = i; // Încercăm invitatul i la poziția k
            if (valid(k)) { // Dacă alegerea este validă
                if (solutie(k)) afisare(k); // Dacă este și o soluție, o afișăm
                else BK(k + 1); // Altfel, continuăm cu următorul invitat
            }
            // Nu este necesar să "ștergem" valoarea lui v[k] pentru că va fi suprascrisă la următoarea iterație
        }
    }


    public static boolean solutie(int k)  //verificam daca am reusit sa gasim o solutie
    {
        //am obtinut o permutare, adica
        //am reusit sa depunem in vector "n" invitati
        if (k == invitati[0].length - 1)
            return true;
        else return false;
    }

    public static boolean valid(int k) //verificam conditiile de continuare
    {
        //prima conditie: toti invitatii asezati pana acum la masa sa fie diferiti de cel curent
        for (int i = 0; i < k; i++) {
            if (v[i] == v[k])
                return false;
        }
        //a doua conditie: invitatul curent sa se simpatizeze cu precedentul
        for (int i = 0; i < k - 1; i++) {
            if (invitati[v[i]][v[i + 1]] == 0) //daca nu se simpatizeaza, nu e valida varianta de pana acum
                return false;
        }
        //a treia conditie: daca este ultimul asezat la masa, trebuie sa simpatizeze cu primul
        if (k == invitati[0].length - 1 && invitati[v[0]][v[k]] == 0)
            return false;
        //daca toate conditiile au fost indeplinite, inseamna ca varianta de pana acum este valida
        //si are sanse de continuare
        return true;
    }

    public static void afisare(int k) {
        //afisez vectorul de rezultate
        System.out.println("");
        for (int i = 0; i <= k; i++) {
            System.out.print("" + v[i] + "  ");
        }
    }

}
