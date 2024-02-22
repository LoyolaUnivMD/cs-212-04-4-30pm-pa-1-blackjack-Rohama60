import java.util.ArrayList;

public class Hand {
    private ArrayList<String> cards;
    public Hand() {
        cards = new ArrayList<String>();
    }
    public void add(String card) {
        cards.add(card);
    }
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
    public void display() {
        for (String card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}
