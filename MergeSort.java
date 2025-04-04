package Sortari;

import java.util.Arrays;

public class MergeSort {
    static void Sort(int[]v,int s, int d)
    {
        if(s<d)
        {
            int m=(s+d)/2;
            Sort(v,s,m);
            Sort(v,m+1,d);
            Merge(v,s,m,d);
        }
    }
    static void Merge(int[]v, int s, int m,int d)
    {
        int n1=(m-s)+1;
        int n2=d-m;
        int[]S=new int[n1];
        int[]D=new int[n2];
        for(int i=0;i<n1;i++)
            S[i]=v[s+i];
        for(int j=0; j<n2;j++)
            D[j]=v[m+1+j];
        int i=0;
        int j=0;
        int k=s;
        while(i<n1&&j<n2)
        {
            if(S[i]<D[j])
            {
                v[k]=S[i];
                i++;
            }
            else
            {
                v[k]=D[j];
                j++;
            }
            k++;
        }
        while(i<n1)
        {
            v[k]=S[i];
            i++;
            k++;
        }
        while(j<n2)
        {
            v[k]=D[j];
            j++;
            k++;
        }

    }

    public static void main(String[] args) {
        int[] v = {8, -2, 70, 6, 0, -4, 9};
        Sort(v,0,v.length-1);
        System.out.println(Arrays.toString(v));
    }
}
