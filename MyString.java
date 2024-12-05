public class MyString {
    public static void main(String[] args) {
        // Test lowercase function
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        // Test contains function
        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        // Convert the string to lowercase using built-in method and return it
        return str.toLowerCase();
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        // Loop through str1 and check if str2 is found within str1
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            // Check if the substring from position i matches str2
            if (str1.substring(i, i + str2.length()).equals(str2)) {
                return true;  // If a match is found, return true
            }
        }
        return false;  // If no match is found, return false
    }
}

