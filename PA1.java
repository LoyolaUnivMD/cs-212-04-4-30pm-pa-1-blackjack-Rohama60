//pa1
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PA1{
    public static void main(String[] args){
        playBlackjack();
    }

    public static String dealCard() {
        String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        Random random = new Random();
        return cards[random.nextInt(cards.length)];
    }

    public static int calculateScore(List<String> hand) {
        int score = 0;
        int numAces = 0;

        for (String card : hand) {
            if (Character.isDigit(card.charAt(0))) {
                score += Integer.parseInt(card);
            } else if (card.equals("J") || card.equals("Q") || card.equals("K")) {
                score += 10;
            } else if (card.equals("A")) {
                numAces++;
            } else {
                score += 10;
            }
        }

        for (int i = 0; i < numAces; i++) {
            if (score + 11 <= 21) {
                score += 11;
            } else {
                score += 1;
            }
        }

        return score;
    }

    public static void playBlackjack() {
        List<String> dealerHand = new ArrayList<>();
        dealerHand.add(dealCard());

        List<String> playerHand = new ArrayList<>();
        playerHand.add(dealCard());
        playerHand.add(dealCard());

        System.out.println("Dealer: " + dealerHand.get(0) + " XX");
        System.out.println("Player: " + String.join(" ", playerHand));

        int playerScore = calculateScore(playerHand);
        System.out.println(playerScore);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Hit(1) or Stay(2): ");
        String choice = scanner.nextLine();

        while (choice.equals("1") && playerScore < 21) {
            playerHand.add(dealCard());
            System.out.println("Dealer: " + dealerHand.get(0) + " XX");
            System.out.println("Player: " + String.join(" ", playerHand));
            playerScore = calculateScore(playerHand);
            System.out.println(playerScore);
            if (playerScore >= 21) {
                System.out.println("Player busted. Dealer wins.");
                return;
            }
            System.out.print("Hit(1) or Stay(2): ");
            choice = scanner.nextLine();
        }

        while (calculateScore(dealerHand) < 17) {
            dealerHand.add(dealCard());
            System.out.println("Dealer: " + String.join(" ", dealerHand));
        }

        int dealerScore = calculateScore(dealerHand);
        playerScore = calculateScore(playerHand);
        System.out.println("Dealer: " + String.join(" ", dealerHand));
        System.out.println(dealerScore);

        if (dealerScore > 21 || (playerScore <= 21 && playerScore > dealerScore)) {
            System.out.println("Player wins!");
        } else if (playerScore < dealerScore) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a draw.");
        }
    }
}
