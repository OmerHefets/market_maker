import java.lang.reflect.Array;
import java.util.*;

public class Offers {
    ArrayList<Bids> bids = new ArrayList<>();
    ArrayList<Asks> asks = new ArrayList<>();

    // insert elements to bid,ask lists - O(n) complexity (no binSearch)
    int IndexInsertBid(ArrayList<Bids> arr, double element) {
        int arr_size = arr.size();
        if (arr_size == 0) {
            return 0;
        }
        for (int i = 0; i < arr_size; i++){
            double cur_price = arr.get(i).price();
            if (element > cur_price) {
                return i;
            }
        }
        return arr_size - 1;
    }

    int IndexInsertAsk(ArrayList<Asks> arr, double element) {
        int arr_size = arr.size();
        if (arr_size == 0) {
            return 0;
        }
        for (int i = 0; i < arr_size; i++){
            double cur_price = arr.get(i).price();
            if (element < cur_price) {
                return i;
            }
        }
        return arr_size - 1;
    }

    void newBid() {
        int amount;
        double price;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount of commodity: ");
        amount = scanner.nextInt();
        System.out.print("Enter your bidding price: ");
        price = scanner.nextDouble();
        Bids bid = new Bids(price, amount);
        int i = IndexInsertBid(bids, bid.price());
        bids.add(i, bid);
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

    void newAsk() {
        int amount;
        double price;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount of commodity: ");
        amount = scanner.nextInt();
        System.out.print("Enter your asking price: ");
        price = scanner.nextDouble();
        Asks ask = new Asks(price, amount);
        int i = IndexInsertAsk(asks, ask.price());
        asks.add(i, ask);
    }

    void printAsks() {
        System.out.println("All asks:");
        for (int i = 0; i < asks.size(); i++) {
            Asks this_ask = asks.get(i);
            double price = this_ask.price();
            int amount = this_ask.amount();
            System.out.printf("(%d) Price: %.2f, Amount %d", (i+1), price, amount);
            System.out.println();
        }
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