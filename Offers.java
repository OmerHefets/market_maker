import java.lang.reflect.Array;
import java.util.*;

public class Offers {
    ArrayList<Bids> bids = new ArrayList<>();
    ArrayList<Asks> asks = new ArrayList<>();
    private double quote = -1;
    private int volume = 0;

    void printQuote() {
        if (quote == -1) {
            System.out.println("There is no quote in the market.");
        } else {
            System.out.printf("Current quote is: %.2f\n", quote);
        }
    }

    void printVolume() {
        System.out.println(volume);
    }
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
        return arr_size;
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
        return arr_size;
    }

    void MarketOrder() {
        int action_amount, action_amount_const;
        int sell_or_buy;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter amount of commodity: ");
            action_amount = scanner.nextInt();
            action_amount_const = action_amount;
            System.out.print("Enter 1 for selling / 2 for buying: ");
            sell_or_buy = scanner.nextInt();
        } while (sell_or_buy != 1 && sell_or_buy != 2);
        if (sell_or_buy == 2) {
            if (asks.size() == 0) {
                System.out.println("There are no asks in the market");
            } else {
                for (; (action_amount > 0) && (bids.size() > 0);) {
                    int temp_amount = asks.get(0).amount();
                    quote = asks.get(0).price();
                    if (temp_amount > action_amount) {
                        volume += action_amount;
                        asks.get(0).change("amount", (temp_amount-action_amount));
                        action_amount = 0;
                    } else {
                        volume += temp_amount;
                        asks.remove(0);
                        action_amount -= temp_amount;
                    }
                }
                if (action_amount > 0) {
                    System.out.printf("Not all units were sold, only %d of %d\n",
                            (action_amount_const - action_amount), action_amount_const);
                }
            }
        } else {
            if (bids.size() == 0) {
                System.out.println("There are no bids in the market");
            } else {
                for (; (action_amount > 0) && (bids.size() > 0);) {
                    int temp_amount = bids.get(0).amount();
                    quote = bids.get(0).price();
                    if (temp_amount > action_amount) {
                        volume += action_amount;
                        bids.get(0).change("amount", (temp_amount-action_amount));
                        action_amount = 0;
                    } else {
                        volume += temp_amount;
                        bids.remove(0);
                        action_amount -= temp_amount;
                    }
                }
                if (action_amount > 0) {
                    System.out.printf("Not all units were bought, only %d of %d\n",
                            (action_amount_const - action_amount), action_amount_const);
                }
            }
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
        int i = IndexInsertBid(bids, bid.price());
        bids.add(i, bid);
    }

    void printBids() {
        if (bids.size() > 0) {
            System.out.println("All bids:");
            for (int i = 0; i < bids.size(); i++) {
                Bids this_bid = bids.get(i);
                double price = this_bid.price();
                int amount = this_bid.amount();
                System.out.printf("(%d) Price: %.2f, Amount %d", (i + 1), price, amount);
                System.out.println();
            }
        } else {
            System.out.println("No current bids.");
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
        if (asks.size() > 0) {
            System.out.println("All asks:");
            for (int i = 0; i < asks.size(); i++) {
                Asks this_ask = asks.get(i);
                double price = this_ask.price();
                int amount = this_ask.amount();
                System.out.printf("(%d) Price: %.2f, Amount %d", (i + 1), price, amount);
                System.out.println();
            }
        } else {
            System.out.println("No current asks.");
        }
    }

    void currentBidAsk() {
        if(bids.size() == 0) {
            System.out.println("No current bids.");
        } else {
            double curBidPrice = bids.get(0).price();
            int curBidAmount = bids.get(0).amount();
            if (bids.get(0).amount() == 1) {
                System.out.printf("Bidding 1 unit for %.2f\n", curBidPrice);
            } else {
                System.out.printf("Bidding %d units for %.2f\n", curBidAmount, curBidPrice);
            }
        }
        if(asks.size() == 0) {
            System.out.println("No current asks.");
        } else {
            double curAskPrice = asks.get(0).price();
            int curAskAmount = asks.get(0).amount();
            if (asks.get(0).amount() == 1) {
                System.out.printf("Asking 1 unit for %.2f\n", curAskPrice);
            } else {
                System.out.printf("Asking %d units for %.2f\n", curAskAmount, curAskPrice);
            }
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

    void change(String var, double new_val) {
        if (var.equals("price")) {
            this.price = new_val;
        } else if (var.equals("amount")) {
            this.amount = (int) new_val;
        }
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

    void change(String var, double new_val) {
        if (var.equals("price")) {
            this.price = new_val;
        } else if (var.equals("amount")) {
            this.amount = (int) new_val;
        }
    }

    double price() {
        return price;
    }

    int amount() {
        return amount;
    }
}