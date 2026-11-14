import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public final class Main {
    private static final String[] CHOICES = {"rock", "paper", "scissors"};
    private Main() {}

    public static void main(String[] args) {
        int wins = 0, losses = 0, ties = 0;
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Rock-paper-scissors. Type rock, paper, scissors, or q to quit.");
            while (true) {
                System.out.print("Your move: ");
                String user = input.nextLine().trim().toLowerCase();
                if (user.equals("q")) {
                    System.out.printf("Final score - wins: %d, losses: %d, ties: %d%n", wins, losses, ties);
                    return;
                }
                if (!user.equals("rock") && !user.equals("paper") && !user.equals("scissors")) {
                    System.out.println("Please enter rock, paper, scissors, or q.");
                    continue;
                }
                String computer = CHOICES[ThreadLocalRandom.current().nextInt(CHOICES.length)];
                System.out.println("Computer: " + computer);
                if (user.equals(computer)) { ties++; System.out.println("Tie."); }
                else if ((user.equals("rock") && computer.equals("scissors"))
                        || (user.equals("paper") && computer.equals("rock"))
                        || (user.equals("scissors") && computer.equals("paper"))) {
                    wins++; System.out.println("You win.");
                } else { losses++; System.out.println("You lose."); }
            }
        }
    }
}
