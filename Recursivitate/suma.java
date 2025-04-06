public class suma {
    public static int sumaImpare(int N) {
        if (N <= 0) {
            return 0;
        }
        if (N % 2 != 0) {
            return N + sumaImpare(N - 2);
        }
        return sumaImpare(N - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumaImpare(5));
    }
}
