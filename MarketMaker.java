import java.util.Scanner;


class UI {
    void UserInterface() {
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, choose between info and action options:");
        do {
            meta_options();
            choice = scan.nextInt();
            switch(choice) {
                case 1:
                    choose_info();
                    break;
                case 2:
                    choose_action();
                    break;
                default:
                    System.out.println("No such option, try again.");
            }
        } while (choice < 1 || choice > 2);

    }

    private void choose_info() {
        int choice;
        info_options();
        do {
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch(choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    choose_action();
                    break;
                case 8:
                    info_options();
                    break;
                default:
                    System.out.println("No such option, try again.");
                    break;
            }
        } while (choice < 1 || choice > 7);
    }

    private void choose_action() {
        int choice;
        action_options();
        do {
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch(choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    choose_info();
                    break;
                case 6:
                    action_options();
                    break;
                default:
                    System.out.println("No such option, try again.");
            }
        } while (choice < 1 || choice > 5);
    }

    private void meta_options() {
        System.out.println("1. Info Options");
        System.out.println("2. Action Options");
    }

    private void action_options() {
        System.out.println("Action Options:");
        System.out.println("1. Place a bid");
        System.out.println("2. Place an ask");
        System.out.println("3. Place a Market Order");
        System.out.println("4. Place a Stop Order");
        System.out.println("5. Switch to Info");
        System.out.println("6. View your options");
    }

    private void info_options() {
        System.out.println("Info Options:");
        System.out.println("1. Current quote");
        System.out.println("2. Current bid-ask");
        System.out.println("3. All Bids");
        System.out.println("4. All Asks");
        System.out.println("5. Volume");
        System.out.println("6. Data of a specific offer");
        System.out.println("7. Switch to actions");
        System.out.println("8. View your options");
    }

}

public class MarketMaker {
    public static void main(String args[]){
        UI beginUI = new UI();
        beginUI.UserInterface();
        Offers offers = new Offers();
        offers.newBid(99.5, 10);
        offers.newBid(99, 20);
        offers.newBid(99.5, 5);
        System.out.println(offers.bids);
        System.out.println(offers.bids.get(1));
        offers.printBids();
    }
}
