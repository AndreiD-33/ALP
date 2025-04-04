package Sortari;

import java.util.Arrays;

public class BubbleSort
{
    public static void main(String[] args)
    {
        int[] v= {17,5,25,8,-2};
        bubbleS(v);
        System.out.println(Arrays.toString(v));
    }
    static void bubbleS(int[] v)
    {
        for(int i=1;i<v.length;i++)
        {
            for(int j=0;j<v.length-1;j++)
                if(v[j]>v[j+1])
                {
                    int temp=v[j];
                    v[j]=v[j+1];
                    v[j+1]=temp;
                }
        }
    }
}

