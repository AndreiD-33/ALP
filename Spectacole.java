package Greedy;

import java.util.ArrayList;

public class Spectacole {
    public static void main(String[] args) {
        Spectacol[] spectacole = new Spectacol[5];
        spectacole[0] = new Spectacol(12.3, 16.3);
        spectacole[1] = new Spectacol(15, 18);
        spectacole[2] = new Spectacol(10, 18.3);
        spectacole[3]=new Spectacol(18,20.45);
        spectacole[4]=new Spectacol(12.15,13);
        ArrayList<Spectacol> rezultat=getSpectacoleDeRulat(spectacole);
       /* for(Spectacol s:rezultat)
            System.out.println(s.oraInceput+"..."+s.oraSfarsit);*/
        for(int i=0;i<rezultat.size();i++)
            System.out.println(rezultat.get(i).oraInceput+"...."+rezultat.get(i).oraSfarsit);
    }

    static ArrayList<Spectacol> getSpectacoleDeRulat(Spectacol[] v){
        sort(v);
        ArrayList<Spectacol> deR=new ArrayList<>();
        deR.add(v[0]);
        for(int i=1;i<v.length;i++){
            if(v[i].oraInceput>=deR.get(deR.size()-1).oraSfarsit)
                deR.add(v[i]);
        }
        return deR;
    }
    static void sort(Spectacol[] spectacole){
        for(int i=0;i<spectacole.length;i++){
            for(int j=0;j<spectacole.length-1;j++){
                if(spectacole[j].oraSfarsit>spectacole[j+1].oraSfarsit)
                {
                    Spectacol temp=spectacole[j];
                    spectacole[j]=spectacole[j+1];
                    spectacole[j+1]=temp;
                }
            }
        }
    }
    static class Spectacol{
        double oraInceput;
        double oraSfarsit;

        public Spectacol(double oraInceput, double oraSfarsit) {
            this.oraInceput = oraInceput;
            this.oraSfarsit = oraSfarsit;
        }
    }

}
