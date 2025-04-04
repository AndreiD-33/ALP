package Recursivitate;

public class Hanoi
{
    public static void main(String[] args){
        try
        {
            afiseazaMutariDinJochanoi(4,'A','C','B');
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    static void afiseazaMutariDinJochanoi (int n, char from, char to, char aux) throws Exception {
        if(n<1)
            throw new Exception("nu pot sa joc hanoi daca nu am discuri");
        if(n==1)
            System.out.println("mutam discul "+n+" de pe tija "+from+" pe tija "+to);
        else{
            afiseazaMutariDinJochanoi(n-1,from,aux,to);
            System.out.println("mutam discul "+n+" de pe tija "+from+" pe tija "+to);
            afiseazaMutariDinJochanoi(n-1,aux,to,from);
        }
    }
}

