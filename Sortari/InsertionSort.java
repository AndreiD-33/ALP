package Sortari;

import java.util.Arrays;

public class InsertionSort
{
    public static void main(String[] args)
    {
        int[] v={2,-2,8,90,56};
        insertion(v);
        System.out.println(Arrays.toString(v));
    }
    static void insertion(int [] v)
    {
        for(int i=1;i<v.length;i++)
        {
            int elementCurent=v[i];
            int pozitieCurenta=i-1;
            while(pozitieCurenta>=0 && elementCurent<v[pozitieCurenta])
            {
                v[pozitieCurenta+1]=v[pozitieCurenta];
                pozitieCurenta--;
            }
            v[pozitieCurenta+1]=elementCurent;
        }
    }

}
