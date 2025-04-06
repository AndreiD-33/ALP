package Cautari;

public class secventiala {

        public static void main(String[] args){
            int[] v={2,-20,8,7,20};
            System.out.println(linear(v,29));
        }

        public static int linear(int[] v, int c){
            for(int i=0;i<v.length;i++){
                if(v[i] == c){
                    return i;
                }
            }
            return -1;
        }

    }


