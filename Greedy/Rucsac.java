package Greedy;

public class Rucsac {
    public static void main(String[] args){
        int[] greutati={12,2,1,4,1};
        int[] valori={4,2,1,10,2};
        Lingou[] rezultat=getLingouriCastigatoare(greutati,valori,15);
        double castig=0;
        for(int i=0;i<rezultat.length;i++) {
            System.out.println("greutate " + rezultat[i].greutate  + " valoare " +
                    rezultat[i].valoare + " castig " + rezultat[i].castig);
            castig+=rezultat[i].valoare;
        }
        System.out.println("castig total "+castig);

    }

    static Lingou[] getLingouriCastigatoare(int[] greut,int[] val, int capacitateRucsac)
    {
        Lingou[] deLucru=new Lingou[greut.length];
        for(int i=0;i<greut.length;i++)
            deLucru[i]=new Lingou(greut[i],val[i]);
        Lingou[] deR=new Lingou[greut.length];
        sort(deLucru);
        for(int i=0;i<deLucru.length;i++) {
            if (deLucru[i].greutate <= capacitateRucsac) {
                deR[i] = deLucru[i];
                capacitateRucsac -= deR[i].greutate;
            }
            else {
                double valUnitaraKgLingou=deLucru[i].valoare/deLucru[i].greutate;
                Lingou lingouFractionat=new Lingou(capacitateRucsac, capacitateRucsac*valUnitaraKgLingou);
                deR[i]=lingouFractionat;
                capacitateRucsac-=deR[i].greutate;
            }
        }
        return deR;

    }
    static void sort(Lingou[] lingouri){
        for(int i=0;i<lingouri.length;i++)
            for(int j=0;j<lingouri.length-1;j++)
                if(lingouri[j].castig<lingouri[j+1].castig)
                {
                    Lingou temp=lingouri[j];
                    lingouri[j]=lingouri[j+1];
                    lingouri[j+1]=temp;
                }
    }
    static class Lingou{
        double greutate;
        double valoare;
        double castig;

        public Lingou(double g, double v) {
            greutate = g;
            valoare = v;
            if(g>0)
                castig=v/g;
        }
    }
}
