public class Primes {
    public static void main(String[] args) {
        int n = 7;  // Change this value to test different ranges
        printPrimes(n);
    }

    public static void printPrimes(int n) {
        // Step 1: Create an array to mark prime numbers
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;  // Assume all numbers are prime initially
        }

        // Step 2: Apply the Sieve of Eratosthenes
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 3: Count the number of primes and print them
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);  // Print the prime number
                primeCount++;
            }
        }

        // Step 4: Calculate the percentage of primes
        int totalNumbers = n - 2 + 1;  // Total numbers from 2 to n (inclusive)
        int percentage = (int) ((primeCount / (double) totalNumbers) * 100); // Calculate the percentage of primes

        // Step 5: Output the result
        System.out.println("There are " + primeCount + " primes between 2 and " + n + " (" + percentage + "% are primes)");
    }
}
