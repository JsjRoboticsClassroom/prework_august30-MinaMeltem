package nyc.c4q;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Hangman hangman = new Hangman();
        boolean playAgain = true;

        do {

            Hangman hangman = new Hangman();

            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }

            boolean isInvalid = false;
            do{
                System.out.println("\nDo you want to play again?: ");
                String answer;
                answer = scanner.nextLine();

                if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                  playAgain = true;
                  isInvalid =false;

                } else if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
                  playAgain = false;
                  isInvalid =false;

                } else {
                  System.out.println("Invalid Input : Answer should be Yes or No");
                  isInvalid = true;

                }
            }while(isInvalid);

        }while(playAgain);
    }
}



