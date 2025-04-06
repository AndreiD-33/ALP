package Sortari;

import java.util.Arrays;

public class SelectSort
{
    public static void main(String[] args)
    {
        int[] v={2,-2,8,90,56};
        sortareSelectie(v);
        System.out.println(Arrays.toString(v));

    }
    static void sortareSelectie(int v[])
    {
        for(int i=0;i<v.length-1;i++)
        {
            //selectam minimul din restul sirului
            //adica din sirul "din dreapta"
            int minPoz=i;
            for(int j=i+1;j<v.length;j++)
            {
                if(v[j]<v[minPoz])
                    minPoz=j;
            }
            //mutam minimul pe pozitia curenta
            if(minPoz != i)
            {
                int aux=v[minPoz];
                v[minPoz]=v[i];
                v[i]=aux;
            }
        }
    }

}
