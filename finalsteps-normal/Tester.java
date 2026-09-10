import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Tester {
    public static void main(String[] args) {
        final int[] isPrimeInputs = {32, 137, 41, 7064, 1985, 393, 5, 5951, 29, 403, 101, 51, 57, 9497, 276, 4214, 269};
        final boolean[] isPrimeOutputs = {false, true, true, false, false, false, true, false, true, false, true, false, false, true, false, false, true};

        // based on 2 having an index of 0
        final int[] nthPrimeInputs = {0, 196, 441, 368, 660, 79, 50, 110, 266, 510, 280};
        final int[] nthPrimeOutputs = {2, 1201, 3089, 2521, 4943, 409, 233, 607, 1709, 3659, 1823};


        if (isPrimeInputs.length != isPrimeOutputs.length || nthPrimeInputs.length != nthPrimeOutputs.length) {
            System.out.println("test array lengths don't match up");
            return;
        }

        for (int i = 0; i < isPrimeInputs.length; i++) {
            final boolean actualOutput = isPrime(isPrimeInputs[i]);
            if (actualOutput != isPrimeOutputs[i]) {
                System.out.println("fail, expected '" + isPrimeOutputs[i] + "' but got '" + actualOutput + "' instead");
            } else {
                System.out.println("pass");
            }
        }

        for (int i = 0; i < nthPrimeInputs.length; i++) {
            final int actualOutput = nthPrime(nthPrimeInputs[i]);
            if (actualOutput != nthPrimeOutputs[i]) {
                System.out.println("fail, expected '" + nthPrimeOutputs[i] + "' but got '" + actualOutput + "' instead");
            } else {
                System.out.println("pass");
            }
        }
    }

    public static boolean isPrime(int x) {
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int nthPrime(int n) {
        int i = 1;
        int count = 0;
        while (count <= n) {
            i++;
            if (isPrime(i)) {
                count++;
            }
        }
        return i;
    }
}