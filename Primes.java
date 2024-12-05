public class Primes {
    public static void main(String[] args) {
        // Ensure that n is passed from the command line argument
        if (args.length < 1) {
            System.out.println("Please provide a value for n.");
            return;
        }
        
        int n = Integer.parseInt(args[0]); // Parse the input n
        System.out.println("Prime numbers up to " + n + ":");
        
        // Call the method to find and print prime numbers
        findPrimes(n);
    }

    // Method to find prime numbers between 2 and n using the Sieve of Eratosthenes
    public static void findPrimes(int n) {
        // If n is less than 2, there are no primes
        if (n < 2) {
            System.out.println("There are no prime numbers up to " + n);
            return;
        }

        // Initialize a boolean array for prime number detection
        boolean[] isPrime = new boolean[n + 1];
        
        // Assume all numbers are prime initially (set all values to true)
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }

        // 0 and 1 are not prime numbers
        isPrime[0] = isPrime[1] = false;

        // Start from the first prime number, 2
        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                // Mark all multiples of p as non-prime
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
            p++;
        }

        // Print out the prime numbers
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i); // Print the prime number
                primeCount++;
            }
        }

        // Calculate the percentage of primes and print it
        int percentage = (int)(((double) primeCount / (n - 1)) * 100); // Calculating the percentage of primes
        System.out.println("There are " + primeCount + " primes between 2 and " + n + " (" + percentage + "% are primes)");
    }
}

