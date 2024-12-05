/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1, 2));      
        System.out.println(indexOf(arr1, 'l'));  
        System.out.println(indexOf(arr1, 'l', 3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd")); // Should return 0
        System.out.println(compareTo("abc", "abcd"));  // Should return -1
        System.out.println(compareTo("abw", "abcd"));  // Should return 1
        System.out.println(compareTo("Abcd", "a"));    // Should return -1
        System.out.println(compareTo("apple", "banana")); // Should return -1
        System.out.println(compareTo("apple", "applepie")); // Should return -1
        System.out.println(compareTo("Zoo", "zoo"));    // Should return -1
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static char charAt(char[] arr, int index) {
        return arr[index];
    }

    public static boolean equals(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static int indexOf(char[] arr, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) return i;
        }
        return -1;
    }

    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for (int i = fromIndex; i < arr.length; i++) {
            if (arr[i] == ch) return i;
        }
        return -1;
    }

    public static int lastIndexOf(char[] arr, char ch) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ch) return i;
        }
        return -1;
    }

    public static char[] concat(char[] arr1, char[] arr2) {
        char[] result = new char[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }

    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        char[] result = new char[endIndex - beginIndex];
        System.arraycopy(arr, beginIndex, result, 0, endIndex - beginIndex);
        return result;
    }

    public static long hashCode(char[] arr) {
        long hash = 0;
        long power = 1; 
        for (int i = arr.length - 1; i >= 0; i--) {
            hash += arr[i] * power;
            power *= 7;
        }
        return hash;
    }

    public static int compareTo(String str1, String str2) {
        // Check for null strings (although the problem assumes non-empty strings, this is good practice)
        if (str1 == null || str2 == null) {
            return -2; // Error code for invalid input
        }

        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);

        // Compare characters lexicographically
        for (int i = 0; i < minLen; i++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(i);
            if (char1 != char2) {
                return char1 < char2 ? -1 : 1; // Use Unicode comparison
            }
        }

        // If all compared characters are equal, check lengths
        if (len1 == len2) {
            return 0; // Strings are equal
        }
        return len1 < len2 ? -1 : 1; // Shorter string is lexicographically smaller
    }
}

