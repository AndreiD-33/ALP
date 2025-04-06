package Sortari;
import java.util.Arrays;
public class QuickSort
{
    static void Sort(int[]v,int s, int d)
    {
        if(s<d)
        {
            int part= partitie(v,s,d);
            Sort(v,s,part-1);
            Sort(v,part+1,d);
        }
    }
    static int partitie(int []v, int s, int d)
    {
        int pivot=v[d];
        int i=s-1;
        for(int j=s;j<d;j++)
        {
            if(v[j]<pivot)
            {
                i++;
                int temp=v[j];
                v[j]=v[i];
                v[i]=temp;
            }
        }
        int temp =v[d];
        v[d]=v[i+1];
        v[i+1]=temp;
        return i+1;
    }

    public static void main(String[] args) {
        int[] v = {0, 77, -5, -4, -3, 0, 2, 100};
        Sort(v, 0, v.length - 1);
        System.out.println(Arrays.toString(v));
    }
}
