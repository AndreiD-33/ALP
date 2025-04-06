package Greedy;

import java.util.ArrayList;

public class Investitor {
    public static void main(String[] args){
        Actiune[] actiuni=new Actiune[3];
        actiuni[0]=new Actiune(10,20,2);
        actiuni[1]=new Actiune(12,50,3);
        actiuni[2]=new Actiune(78,12,4);
        ArrayList<Actiune> rezultat=getActiuni(actiuni,200);
        for(int i=0;i<rezultat.size();i++)
            System.out.println("raport "+rezultat.get(i).raport);
    }

    static ArrayList<Actiune> getActiuni(Actiune[] actiuniInvestitor, double suma) {
        sort(actiuniInvestitor);
        ArrayList<Actiune> rezultat = new ArrayList<>();
        for (Actiune actiune : actiuniInvestitor) {
            double costTotal = actiune.cost * actiune.nrMaxim;
            if (costTotal <= suma) {
                rezultat.add(new Actiune(actiune.cost, actiune.dividend, actiune.nrMaxim));
                suma -= costTotal;
            } else {

                int nrAchizitionat = (int) (suma / actiune.cost);
                if (nrAchizitionat > 0) {
                    Actiune actiunePartiala = new Actiune(actiune.cost, actiune.dividend, nrAchizitionat);
                    rezultat.add(actiunePartiala);
                    suma -= nrAchizitionat * actiune.cost;
                }
                break;
            }
        }
        return rezultat;
    }
    static void sort(Actiune[] v){
        for(int i=0;i<v.length;i++){
            for(int j=0;j<v.length-1;j++){
                if(v[j].raport<v[j+1].raport){
                    Actiune temp=v[j];
                    v[j]=v[j+1];
                    v[j+1]=temp;
                }
            }
        }
    }

    static class Actiune {
        double cost;
        double dividend;
        int nrMaxim;
        double raport;
        int nrAchizitionat;

        public Actiune(double cost, double dividend, int nr) {
            this.cost = cost;
            this.dividend = dividend;
            this.nrMaxim = nr;
            this.raport = this.dividend / this.cost;
            this.nrAchizitionat = nr;
        }
    }
}


