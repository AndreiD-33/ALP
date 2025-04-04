package backtracking;

public class Monede {
    static int v[], w[], z[];
    static int suma;

    public static void main(String[] args) {
        w=new int[3];w[0]=1;w[1]=2;w[2]=5;
        z=new int[3];z[0]=5;z[1]=5;z[2]=5;
        suma=10;
        v=new int[w.length];
        BK(0);
    }
    public static void BK(int k)
    {
        int i;
        for(i=0;i<=z[k];i++)
        {
            v[k]=i;
            if(valid(k)==true)
            {
                if(solutie(k)==true)
                    afisare(k);
                else
                { if (k<w.length-1)
                    BK(k+1); }
            }
        }
    }
    public static void afisare(int k)
    {
        System.out.println("");
        for(int i=0;i<=k;i++)
        { System.out.print("" + v[i] + " monede cu valoarea de " + w[i] +", "); }
        System.out.print(" fac suma de " + suma);
    }
    public static boolean valid(int k)
    {
        int sumaActuala=0;
        for(int i=0;i<k;i++)
            sumaActuala=sumaActuala+v[i]*w[i];
        if(sumaActuala<=suma && k<w.length)
            return true;
        else
            return false;
    }
    public static boolean solutie(int k)
    {
        int sumaActuala=0;
        for(int i=0;i<=k;i++)
            sumaActuala = sumaActuala + v[i]*w[i];
        if(sumaActuala==suma)
            return true;
        else
            return false;
    }
}
