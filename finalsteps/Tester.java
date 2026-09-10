import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Tester {
    private static record TestCase<I, O>(I input, O expectedOutput) { 
        public void test(Function<I, O> method) {
            final O output = method.apply(input);
            // System.out.println(output);
            System.out.println(output.equals(expectedOutput) ? "pass" : "fail. Expected '" + expectedOutput + "' but value returned was '" + output + "'."); 
        }
    }
    public static void main(String[] args) {
        final List<TestCase<Integer, Boolean>> isPrimeTests = new ArrayList<>();
        isPrimeTests.add(new TestCase<>(32, false));
        isPrimeTests.add(new TestCase<>(137, true));
        isPrimeTests.add(new TestCase<>(41, true));
        isPrimeTests.add(new TestCase<>(7064, false));
        isPrimeTests.add(new TestCase<>(1985, false));
        isPrimeTests.add(new TestCase<>(393, false));
        isPrimeTests.add(new TestCase<>(5, true));
        isPrimeTests.add(new TestCase<>(5951, false));
        isPrimeTests.add(new TestCase<>(29, true));
        isPrimeTests.add(new TestCase<>(403, false));
        isPrimeTests.add(new TestCase<>(101, true));
        isPrimeTests.add(new TestCase<>(51, false));
        isPrimeTests.add(new TestCase<>(57, false));
        isPrimeTests.add(new TestCase<>(9497, true));
        isPrimeTests.add(new TestCase<>(276, false));
        isPrimeTests.add(new TestCase<>(4214, false));
        isPrimeTests.add(new TestCase<>(269, true));

        final List<TestCase<Integer, Integer>> nthPrimeTests = new ArrayList<>();
        nthPrimeTests.add(new TestCase<>(0, 2));
        nthPrimeTests.add(new TestCase<>(196, 1201));
        nthPrimeTests.add(new TestCase<>(441, 3089));
        nthPrimeTests.add(new TestCase<>(368, 2521));
        nthPrimeTests.add(new TestCase<>(660, 4943));
        nthPrimeTests.add(new TestCase<>(79, 409));
        nthPrimeTests.add(new TestCase<>(50, 233));
        nthPrimeTests.add(new TestCase<>(110, 607));
        nthPrimeTests.add(new TestCase<>(266, 1709));
        nthPrimeTests.add(new TestCase<>(510, 3659));
        nthPrimeTests.add(new TestCase<>(280, 1823));

        for (var testCase : isPrimeTests) {
            testCase.test(Tester::isPrime);
        }
        for (var testCase : nthPrimeTests) {
            testCase.test(Tester::nthPrime);
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