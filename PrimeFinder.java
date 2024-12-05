public class PrimeFinder {

    public static void main(String[] args) {
        // Get the upper limit n from command-line input
        int upperLimit = Integer.parseInt(args[0]);
        findPrimes(upperLimit);
    }

    /**
     * Finds and prints all prime numbers up to the specified upper limit using
     * the Sieve of Eratosthenes.
     *
     * @param upperLimit The upper bound for prime number generation.
     */
    public static void findPrimes(int upperLimit) {
        if (upperLimit < 2) {
            System.out.println("There are no prime numbers up to " + upperLimit);
            return;
        }

        // Step 1: Set up a boolean array to track potential primes
        boolean[] primes = new boolean[upperLimit + 1];
        for (int i = 2; i <= upperLimit; i++) {
            primes[i] = true;  // Assume every number >= 2 is prime
        }

        // Step 2: Implement the sieve to mark non-primes
        for (int number = 2; number * number <= upperLimit; number++) {
            if (primes[number]) {
                for (int multiple = number * number; multiple <= upperLimit; multiple += number) {
                    primes[multiple] = false;  // Mark multiples of the prime as non-prime
                }
            }
        }

        // Step 3: Collect and print the prime numbers
        System.out.println("Prime numbers up to " + upperLimit + ":");
        int primeCount = 0;
        for (int i = 2; i <= upperLimit; i++) {
            if (primes[i]) {
                System.out.println(i);
                primeCount++;
            }
        }

        // Step 4: Calculate and display the percentage of primes
        double primePercentage = (double) primeCount / upperLimit * 100;
        System.out.println("There are " + primeCount + " primes between 2 and " + upperLimit
                + " (" + (int) primePercentage + "% are primes)");
    }
}
