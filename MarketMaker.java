import java.util.Scanner;

class UI {
    private void timeDelay(long t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {}
    }

    void UserInterface(Offers offers) {
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, choose between info and action options:");
        do {
            meta_options();
            choice = scan.nextInt();
            switch(choice) {
                case 1:
                    choose_info(offers);
                    break;
                case 2:
                    choose_action(offers);
                    break;
                default:
                    System.out.println("No such option, try again.");
            }
        } while (choice < 1 || choice > 2);

    }

    private void choose_info(Offers offers) {
        int choice;
        info_options();
        do {
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch(choice) {
                case 1:
                    offers.printQuote();
                    timeDelay(2500);
                    choose_info(offers);
                    break;
                case 2:
                    offers.currentBidAsk();
                    timeDelay(2500);
                    choose_info(offers);
                    break;
                case 3:
                    offers.printBids();
                    timeDelay(2500);
                    choose_info(offers);
                    break;
                case 4:
                    offers.printAsks();
                    timeDelay(2500);
                    choose_info(offers);
                    break;
                case 5:
                    offers.printVolume();
                    timeDelay(2500);
                    choose_info(offers);
                    break;
                case 6:
                    offers.ShowOfferData();
                    timeDelay(2500);
                    choose_info(offers);
                    break;
                case 7:
                    choose_action(offers);
                    break;
                case 8:
                    info_options();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("No such option, try again.");
                    break;
            }
        } while (choice < 1 || choice > 7);
    }

    private void choose_action(Offers offers) {
        int choice;
        action_options();
        do {
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch(choice) {
                case 1:
                    offers.newBid();
                    timeDelay(1000);
                    choose_action(offers);
                    break;
                case 2:
                    offers.newAsk();
                    timeDelay(1000);
                    choose_action(offers);
                    break;
                case 3:
                    offers.MarketOrder();
                    timeDelay(1000);
                    choose_action(offers);
                    break;
                case 4:
                    timeDelay(2500);
                    choose_action(offers);
                    break;
                case 5:
                    choose_info(offers);
                    break;
                case 6:
                    action_options();
                    break;
                case 7:
                    return;
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
        System.out.println("7. exit");
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
        System.out.println("9. exit");
    }

}

public class MarketMaker {
    public static void main(String args[]){
        UI beginUI = new UI();
        Offers offers = new Offers();
        beginUI.UserInterface(offers);
        //System.out.println(offers.bids);
        //System.out.println(offers.bids.get(1));
        //offers.printBids();
        //offers.printAsks();
    }
}
