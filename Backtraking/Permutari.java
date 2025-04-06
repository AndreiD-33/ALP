package backtracking;

public class Permutari {
    static int[] v;
    static int n;
    public static void main(String[] args) {
        n=4; v=new int[n];
        BK(0);
    }
    static void BK(int k)
    {
        int i;
        for(i=0;i<n;i++)
        {
            v[k]=i;
            if(valid(k))
            {
                if(solutie(k))
                    afisare();
                else
                    BK(k+1);
            }
        }
    }
    static void afisare()
    {
        System.out.println();
        for(int i=0;i<v.length;i++)
            System.out.print(" " + v[i]);
    }
    static boolean solutie(int k)
    {
        if(k==n-1)
            return true;
        else
            return false;
    }
    static boolean valid(int k)
    {
        for(int i=0;i<k;i++)
            if(v[i]==v[k])
                return false;
        return true;
    }
}
