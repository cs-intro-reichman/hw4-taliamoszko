public class Primes {
    public static void main(String[] args) {
        // Ensure the input value is provided correctly from command line
        if (args.length < 1) {
            System.out.println("Please provide a value for n.");
            return;
        }

        int n = Integer.parseInt(args[0]);  // Get 'n' from command line input
        System.out.println("Prime numbers up to " + n + ":");
        findPrimes(n);
    }

    public static void findPrimes(int n) {
        // If n is less than 2, return early as there are no primes
        if (n < 2) {
            System.out.println("There are no prime numbers up to " + n);
            return;
        }

        // Create a boolean array to track prime numbers
        boolean[] prime = new boolean[n + 1];
        
        // Initially assume all numbers are prime (set to true)
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }

        // 0 and 1 are not prime numbers
        prime[0] = prime[1] = false;

        // Implement the Sieve of Eratosthenes
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false; // Mark multiples of p as non-prime
                }
            }
        }

        // Print the prime numbers
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                System.out.println(i); // Print the prime number
                primeCount++;
            }
        }

        // Calculate the percentage of primes and print it
        int percentage = (int) (((double) primeCount / (n - 1)) * 100); 
        System.out.println("There are " + primeCount + " primes between 2 and " + n + " (" + percentage + "% are primes)");
    }
}
