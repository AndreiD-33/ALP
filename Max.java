package Recursivitate;

public class Max {
    public static void main(String[] args){
        int[] v={7,17,-2,8,9,10,2};
        System.out.println(maxRec(v,0,(v.length-1)));
    }

    public static int maxRec(int[] v, int start, int end) {

        if (start == end) {
            return v[start];
        } else {

            int mid = start + (end - start) / 2;

            int maxLeft = maxRec(v, start, mid);

            int maxRight = maxRec(v, mid + 1, end);

            return Math.max(maxLeft, maxRight);
        }
    }
}
