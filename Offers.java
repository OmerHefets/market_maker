import java.lang.reflect.Array;
import java.util.*;

public class Offers {
    ArrayList<Bids> bids = new ArrayList<>();
    ArrayList<Asks> asks = new ArrayList<>();

    // insert elements to bid,ask lists - log(n) complexity
    int binInsert(List<Bids> arr, double element) {
        int arr_size = arr.size();
        if (arr_size == 0) {
            return 0;
        }
        arr_size /= 2;
        double temp = arr.get(arr_size).price();
        if (temp > element) {
            return binInsert(arr.subList(0, arr_size), element);
        } else if (temp < element) {
            return 1;
        } else {
            return arr_size;
        }
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

    void newAsk() {
        int amount;
        double price;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount of commodity: ");
        amount = scanner.nextInt();
        System.out.print("Enter your asking price: ");
        price = scanner.nextDouble();
        Asks ask = new Asks(price, amount);
        asks.add(ask);
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