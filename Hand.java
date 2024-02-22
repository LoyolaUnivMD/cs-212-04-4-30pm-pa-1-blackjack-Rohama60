import java.util.ArrayList;

public class Hand {
    // Instance variable to store the cards in the hand

    private ArrayList<String> cards;

    // constructor to initialize the cards ArrayList
    public Hand() {
        cards = new ArrayList<String>();
    }

    // Method to add a card to the hand
    public void add(String card) {
        cards.add(card);
    }

    // Method to calculate the total value of the cards in the hand
    public int total() {
        int totalValue = 0;
        for (String card : cards) {
            String rank = card.split(" ")[0];
            switch (rank) {
                case "Ace":
                    totalValue += 1;
                    break;
                case "2":
                    totalValue += 2;
                    break;
                case "3":
                    totalValue += 3;
                    break;
                case "4":
                    totalValue += 4;
                    break;
                case "5":
                    totalValue += 5;
                    break;
                case "6":
                    totalValue += 6;
                    break;
                case "7":
                    totalValue += 7;
                    break;
                case "8":
                    totalValue += 8;
                    break;
                case "9":
                    totalValue += 9;
                    break;
                case "10":
                    totalValue += 10;
                    break;
                case "King":
                case "Queen":
                case "Jack":
                    totalValue += 10;
                    break;
            }
        }
        return totalValue;
    }

    // Method to display the cards in the hand
    public void display() {
        for (String card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}
