package backtracking;

public class ComisVoiajor {

    public static void main(String[] args) {
        n = 4;
        v = new int[n];
        BK(0, 1);
    }

    static int[] v;
    static int n;

    static void BK(int k, int start) {
        for (int i = 0; i < v.length; i++) {
            v[k] = i;
            if (valid(k, start)) {
                if (solutie(k)) {
                    afisare();
                } else {
                    BK(k + 1, start);
                }
            }
        }
    }

    static boolean valid(int k, int start) {
        if (v[0] != start) {
            return false;
        }
        for (int i = 0; i < k; i++) {
            if (v[i] == v[k]) {
                return false;
            }
        }
        return true;
    }

    static boolean solutie(int k) {
        return k == n - 1;
    }

    static void afisare() {
        //  System.out.println();
        for (int i = 0; i < v.length; i++) {
            System.out.print((v[i] + 1));
        }
        System.out.println();
    }
}

