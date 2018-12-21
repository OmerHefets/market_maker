import java.util.*;

public class Offers {
    ArrayList<Bids> bids = new ArrayList<Bids>();
    ArrayList<Asks> asks = new ArrayList<Asks>();

    void newBid(double price, int amount) {
        Bids bid = new Bids(price, amount);
        bids.add(bid);
    }

    void printBids() {
        System.out.println("All bids:");
        for (int i = 0; i < bids.size(); i++) {
            Bids this_bid = bids.get(i);
            double price = this_bid.price();
            int amount = this_bid.amount();
            System.out.printf("(%d) Price: %.2f, Amount %d", (i+1), price, amount);
            System.out.println();
        }
    }

    void newAsk(double price, int amount) {
        Asks ask = new Asks(price, amount);
        asks.add(ask);
    }


}

class Bids {
    private double price;
    private int amount;

    Bids(double price, int amount) {
        this.price = price;
        this.amount = amount;
    }

    double price() {
        return price;
    }

    int amount() {
        return amount;
    }
}

class Asks {
    private double price;
    private int amount;

    Asks(double price, int amount) {
        this.price = price;
        this.amount = amount;
    }

    double price() {
        return price;
    }

    int amount() {
        return amount;
    }
}