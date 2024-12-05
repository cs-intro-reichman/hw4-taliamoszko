public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the keywords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        // Iterate over each sentence in the array
        for (String sentence : sentences) {
            // Convert the sentence to lowercase for case-insensitive comparison
            String lowerCaseSentence = sentence.toLowerCase();

            // Check if any of the keywords exist in the sentence
            for (String keyword : keywords) {
                // Convert the keyword to lowercase for case-insensitive comparison
                if (lowerCaseSentence.contains(keyword.toLowerCase())) {
                    // If the sentence contains the keyword, print it
                    System.out.println(sentence);
                    break;  // No need to check further keywords once a match is found
                }
            }
        }
    }
}
