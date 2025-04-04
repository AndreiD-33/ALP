package Cautari;

public class secventiala_ordonata {
        public static void main(String[] args){
            int[] v = {2, 4, 5, 6, 9, 10};
            System.out.println(linearSearchInSorted(v,5));
        }
        public static int linearSearchInSorted(int[] v, int cheie)
        {
            int i=0;
            while (i<v.length && v[i]<=cheie)
            {
                i++;
            }
            if(i==0 || v[i-1]!=cheie)
                return -1;
            else
                return i-1;
        }

    }


