import java.util.Random;
import java.util.Scanner;

public class RPSLS {

    enum Move { ROCK, PAPER, SCISSORS, LIZARD, SPOCK }

    // returns 1 if a beats b, -1 if b beats a, 0 for a tie
    static int winner(Move a, Move b) {
        if (a == b) return 0;

        boolean aWins = switch (a) {
            case SCISSORS -> (b == Move.PAPER || b == Move.LIZARD);
            case PAPER    -> (b == Move.ROCK || b == Move.SPOCK);
            case ROCK     -> (b == Move.LIZARD || b == Move.SCISSORS);
            case LIZARD   -> (b == Move.SPOCK || b == Move.PAPER);
            case SPOCK    -> (b == Move.SCISSORS || b == Move.ROCK);
        };

        return aWins ? 1 : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        Move[] moves = Move.values();

        int playerScore = 0;
        int computerScore = 0;

        for (int round = 1; round <= 5; round++) {
            Move computerMove = moves[rand.nextInt(moves.length)];

            Move playerMove = null;
            while (playerMove == null) {
                System.out.print("Round " + round + " - your move (ROCK, PAPER, SCISSORS, LIZARD, SPOCK): ");
                String input = sc.nextLine().trim().toUpperCase();
                try {
                    playerMove = Move.valueOf(input);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid move. Try again.");
                }
            }

            int result = winner(playerMove, computerMove);

            System.out.println("You: " + playerMove + "  Computer: " + computerMove);
            if (result == 1) {
                System.out.println("You win this round!");
                playerScore++;
            } else if (result == -1) {
                System.out.println("Computer wins this round!");
                computerScore++;
            } else {
                System.out.println("Tie!");
            }
            System.out.println();
        }

        System.out.println("Final score - You: " + playerScore + ", Computer: " + computerScore);
        if (playerScore > computerScore) {
            System.out.println("You win " + playerScore + "-" + computerScore);
        } else if (computerScore > playerScore) {
            System.out.println("Computer wins " + computerScore + "-" + playerScore);
        } else {
            System.out.println("It's an overall tie " + playerScore + "-" + computerScore);
        }

        sc.close();
    }
}
