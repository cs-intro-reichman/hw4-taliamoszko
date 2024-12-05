public class Primes {
    public static void main(String[] args) {
        // Parse the input value n
        int n = Integer.parseInt(args[0]);

        // Initialize the sieve
        boolean[] sieve = new boolean[n + 1];

        // Mark all numbers as prime initially, except for 0 and 1
        for (int i = 2; i <= n; i++) {
            sieve[i] = true;
        }

        // Implement the Sieve of Eratosthenes
        int p = 2;
        while (p * p <= n) {
            if (sieve[p]) {
                // Mark multiples of p as false
                for (int i = p * p; i <= n; i += p) {
                    sieve[i] = false;
                }
            }
            p++;
        }

        // Print prime numbers
        System.out.println("Prime numbers up to " + n + ":");
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (sieve[i]) {
                System.out.println(i);
                primeCount++;
            }
        }

        // Calculate and print the percentage of primes as an integer
        int percentage = (int) ((double) primeCount / (n - 1) * 100); // Casting to int to drop decimals
        System.out.printf("There are %d primes between 2 and %d (%d%% are primes)\n", primeCount, n, percentage);
    }
}

