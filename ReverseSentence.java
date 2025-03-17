//Reversing sentence in java without using String Builder

class Test{
    public static void main(String[] args) {
        String sentence = "I love Programming";

        //Step 1: Split the sentence into words
        String[] words = sentence.split(" ");

        int left =0, right = words.length - 1;

        //Step 2: Reverse words using two-pointer approach
        while(left < right){
            //Swap words using two-pointer approach
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            left++;
            right--;
        }

        //Step 3: Reverse each word individually
        for(int i = 0; i < words.length; i++){
            words[i] = reverseWord(words[i]);
        }

        //Step 4: Join the words back into a sentence
        String reversedSentence = String.join(" ",words);

        //Step 5: output
        System.out.println(" Reversed Sentence:"+ reversedSentence);
    }

    static String reverseWord(String word){
        char[] charArray = word.toCharArray();
        int left =0, right = charArray.length - 1;

        while(left < right){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }
        String reversedWord = new String(charArray);

        return reversedWord;
    }
}