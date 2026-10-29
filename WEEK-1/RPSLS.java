import java.util.Random;
import java.util.Scanner;

enum Move {
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK
}

public class RPSLS {

    static int winner(Move a, Move b) {

        if (a == b) {
            return 0;
        }

        boolean win = switch (a) {

            case ROCK ->
                    b == Move.SCISSORS || b == Move.LIZARD;

            case PAPER ->
                    b == Move.ROCK || b == Move.SPOCK;

            case SCISSORS ->
                    b == Move.PAPER || b == Move.LIZARD;

            case LIZARD ->
                    b == Move.SPOCK || b == Move.PAPER;

            case SPOCK ->
                    b == Move.SCISSORS || b == Move.ROCK;
        };

        if (win) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        for (int round = 1; round <= 5; round++) {

            System.out.println("\nRound " + round);

            System.out.print("Enter move: ");

            Move player =
                    Move.valueOf(sc.next().toUpperCase());

            Move computer =
                    Move.values()[random.nextInt(Move.values().length)];

            System.out.println("Player: " + player);

            System.out.println("Computer: " + computer);

            int result = winner(player, computer);

            if (result == 1) {

                System.out.println("You win this round!");

                playerScore++;

            } else if (result == -1) {

                System.out.println("Computer wins this round!");

                computerScore++;

            } else {

                System.out.println("Tie!");
            }
        }

        System.out.println("\nFinal Score");

        System.out.println("You " + playerScore
                + " - " + computerScore + " Computer");

        if (playerScore > computerScore) {

            System.out.println("You win "
                    + playerScore + "-" + computerScore);

        } else if (computerScore > playerScore) {

            System.out.println("Computer wins "
                    + computerScore + "-" + playerScore);

        } else {

            System.out.println("Overall Tie!");
        }

        sc.close();
    }
}