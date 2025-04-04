package Cautari;

public class binar_recursiv {
        public static void main(String[] args){
            int[] v = {2, 4, 5, 6, 9, 10};
            System.out.println(divideRecursiv(v,5,0,v.length-1));
        }
        static int divideRecursiv(int[] v, int e, int s,int d){
            while(s<=d){
                int m=(s+d)/2;
                if(v[m]==e)
                    return m;
                if(v[m]>e)
                    return divideRecursiv(v, e,s,m-1);
                else return divideRecursiv(v,e,m+1,d);
            }
            return -1;
        }
    }


