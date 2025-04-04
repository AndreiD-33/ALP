package backtracking;

public class Dame {
    public static void main(String[] args){
        N=4;
        v=new int[N];
        BK(0);
    }
    static int N;
    static int[] v;
    static void BK(int k){
        for(int i=0;i<N;i++) {
            v[k] = i;
            if (validare(k))
                if (solutie(k))
                    afisare();
                else BK(k+1);
        }
    }

    static boolean validare(int k){
        for(int i=0;i<k;i++)
            if(Math.abs(v[i]-v[k])==k-i||v[k]==v[i])
                return false;
        return true;
    }

    static boolean solutie(int k)
    {
        if(k==N-1)
            return true;
        return false;
    }

    static void afisare(){
        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if (v[j] == i)
                    System.out.print("D ");
                else System.out.print("- ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
