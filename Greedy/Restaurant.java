package Greedy;
public class Restaurant {

    public static void main(String[] args) {
        int[] timpi= {10, 20, 10, 20};
        int timpTotal = getMin(timpi);
        System.out.println("Timpul total de asteptare este: " + timpTotal);
    }


    static int getMin(int[] timpi) {
        sort(timpi);

        int timpTotal = 0;
        int timpAsteptareCurent = 0;


        for(int i = 0; i < timpi.length; i++) {
            timpAsteptareCurent += timpi[i];
            timpTotal += timpAsteptareCurent;
        }

        return timpTotal;
    }

    static void sort(int[] elemente) {
        boolean swap;
        for(int i = 0; i < elemente.length; i++) {
            swap = false;
            for(int j = 0; j < elemente.length - i - 1; j++) {
                if(elemente[j + 1] < elemente[j]) {
                    int temp = elemente[j];
                    elemente[j] = elemente[j + 1];
                    elemente[j + 1] = temp;
                    swap = true;
                }
            }
            if(!swap) break;
        }
    }
}
