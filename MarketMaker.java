import java.util.Scanner;

class UI {
    void UserInterface() {
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, your following options:");
        options();
        do {
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
                    options();
                    break;
                default:
                    System.out.println("No such option, try again.");
                    break;
            }
        } while (choice < 1 || choice > 6);
    }

    private void options() {
        System.out.println("1. Current quote");
        System.out.println("2. Current bid-ask");
        System.out.println("3. All Bids");
        System.out.println("4. All Asks");
        System.out.println("5. Volume");
        System.out.println("6. Data of a specific offer");
        System.out.println("7. View your options");
    }
}

public class MarketMaker {
    public static void main(String args[]){
        UI beginUI = new UI();
        beginUI.UserInterface();
    }
}
