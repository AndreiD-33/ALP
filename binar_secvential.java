package Cautari;

public class binar_secvential {

        public static void main(String[] args){
            int[] v = {2, 4, 5, 6, 9, 10};
            System.out.println(cautareDivideSecventiala(v,5));
        }
        static int cautareDivideSecventiala(int[] v,int e){
            int s=0;
            int d=v.length-1;
            while(s<=d){
                int m=(s+d)/2;
                if(v[m]==e)
                    return m;
                if(v[m]>e)
                    d=m;
                else s=m+1;
            }
            return -1;
        }
    }

