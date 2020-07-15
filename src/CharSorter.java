import java.util.*;

public class CharSorter {
    // 1st Method. Sort data alphabetically.

    public static void alphabeticalSort(int[] alphNum) {

        for (int i = 0; i < 256; i++) {
            if (alphNum[i] != 0) {
                System.out.println((char)(i) + " freq: " + alphNum[i]);
            }
        }
        System.out.println("");
    }

    // 2nd Method. Sort all char from highest to lowest.

    public static void frequencySort (int [] freqNum) {

        int x = 0;
        int y = 0;
        char objChar;
        int freqArray [] = new int[256];
        char charArray [] = new char[256];

        for (int i = 0; i < 256; i++) {

            freqArray[i] = 0;
            charArray[i] = '\0';
        }

        for (int j = 0; j < 256; j++) {

            x = 0;
            objChar = '\0';

            for (int i = 0; i < 256; i++) {

                if (freqNum[i] > x) {

                    x = freqNum[i];
                    objChar = (char)(i);
                    y = i;
                }
            }

            freqArray[j] = x;
            charArray[j] = objChar;
            freqNum[y] = 0;
        }

        System.out.println("The sorted by frequency characters are: \n");
        for (int i = 0; i < 256; i++) {

            if (freqArray[i] != 0) {

                System.out.println(charArray[i] + " freq: " + freqArray[i]);
            }
        }
        System.out.println("");
    }

    // 3rd Method. Sort data in categories.

    public static void charTypes (String content) {

        int textual = 0;
        int numeric = 0;
        int whiteSpace = 0;
        int symbolic = 0;

        for (int i = 0; i < content.length(); i++) {

            // Symbols
            if (content.charAt(i) >= 33 && content.charAt(i) < 48) {
                symbolic++;
            }
            if (content.charAt(i) >= 58 && content.charAt(i) < 65) {
                symbolic++;
            }
            if (content.charAt(i) >= 91 && content.charAt(i) < 97) {
                symbolic++;
            }
            if (content.charAt(i) >= 123 && content.charAt(i) < 127) {
                symbolic++;
            }

            // Numerical

            if (content.charAt(i) >= 48 && content.charAt(i) < 58) {
                numeric++;
            }

            // Textual

            if (content.charAt(i) >= 65 && content.charAt(i) < 91) {
                textual++;
            }
            if (content.charAt(i) >= 97 && content.charAt(i) < 123) {
                textual++;
            }

            // WhiteSpace

            if (content.charAt(i) == 32 || content.charAt(i) == 127) {
                whiteSpace++;
            }

        }

        System.out.println("Textual Character count: " + textual);
        System.out.println("Numerical Character count: " + numeric);
        System.out.println("WhiteSpace Character count: " + whiteSpace);
        System.out.println("Symbol Character count: " + symbolic);
        System.out.println("");

    }

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Character Sorter Program");
        System.out.println("Please input a string to be sorted: ");

        String content = sc.nextLine();

        int characters[] = new int[256];
        for (int i = 0; i < 256; i++) {
            characters[i] = 0;
        }

        for (int i = 0; i < content.length(); i++) {
            characters [(int)(content.charAt(i))]++;
        }

        int selection = 0;

        while (selection != 4) {
            userMenu();

            // giving the error

            while(true) {
                try {
                    selection = sc.nextInt();
                    if (selection > 4 || selection < 1)
                        System.out.println("Error, bad input, please enter a number 1-4\n");
                    break;
                }
                catch (Exception e) {
                    System.out.println("Error, bad input, please enter a number 1-4\n");
                    sc.nextLine();
                    break;
                }
            }

            if (selection == 1){
                alphabeticalSort(characters);
                selection = 0;
            }
            if (selection == 2){
                int[] tempArray = new int[characters.length];
                System.arraycopy(characters, 0, tempArray, 0, characters.length);
                frequencySort(tempArray);
                selection = 0;
            }
            if (selection == 3){
                charTypes(content);
                selection = 0;
            }
        }
        System.out.println("Character Sorter Exited Successfully");
    }

    public static void userMenu() {
        System.out.println("Please select the option you would like to see");
        System.out.println("");
        System.out.println("1. Display character frequencies alphabetically");
        System.out.println("2. Display sorted frequencies");
        System.out.println("3. Show types of character frequencies");
        System.out.println("4. Exit ");
    }
}
