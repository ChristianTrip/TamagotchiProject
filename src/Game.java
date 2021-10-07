import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    static Scanner scan = new Scanner(System.in);
    static Tamagotchi tamagotchi;

    static Food banana = new Food("Banana", 1, 0, 1, 0);
    static Food apple = new Food("Apple", 1, 0, 1, 0);
    static Food coqAuVin = new Food("Coq au vin", 3, 2, 3, -3);

    static Playing chess = new Playing("Chess", -1, 3, 1, 0);
    static Playing badminton = new Playing("Badminton", -2, 1, 2, -3);
    static Playing fetch = new Playing("Fetch", -2, 2, 3, -4);


    static void startGame(){
        System.out.println("===============================");
        System.out.println("      T A M A G O T C H I      ");
        System.out.println("===============================");
        System.out.println();
        if (tamagotchi == null) {
            System.out.println("Since you dont have a tamagotchi yet\n" +
                    "We will go to the pet store\n" +
                    "so you can pick one up!\n\n" +
                    "Press enter\n");
            scan.nextLine();
            petStoreMenu();

        }
    }

    static void mainMenu(){

        if (!tamagotchi.isAlive()){
            System.out.println(tamagotchi.getName() + " RIP");
        }
        else {
            System.out.println("  1. Choose a new Tamagotchi    ");
            System.out.println("  2. Continue with exsisting one");
            System.out.println("  3. Exit                       ");
            System.out.println("===============================");

            boolean run = true;
            while (run) {

                int choice = validateUserIntInput(1, 3);
                switch (choice) {
                    case 1:
                        petStoreMenu();
                        break;
                    case 2:
                        performAction();
                        run = false;
                        break;
                    case 3:
                        System.out.println("Goodbye");
                        run = false;
                        break;
                }
            }
        }
    }

    static void petStoreMenu(){

            System.out.println("===============================");
            System.out.println("      T A M A G O T C H I      ");
            System.out.println("       P E T   S T O R E       ");
            System.out.println("===============================");
            System.out.println();
            System.out.println("Welcome to the Tamagotchi pet store!");
            System.out.println("Please select your Tamagotchi");
            System.out.println();
            System.out.println("  1. Dog    ");
            System.out.println("  2. Cat    ");
            if (tamagotchi != null) {
                System.out.println("  3. Back   ");
            }
            System.out.println();

            int choice = validateUserIntInput(1, 3);

            if (choice == 1 || choice == 2){
                createNewTamagotchi(choice);
            }

            mainMenu();
    }

    static Food chooseWhatToEat(){

        Food toReturn = null;

        System.out.println("===============================");
        System.out.println("  1. " + apple.getName());
        System.out.println("  2. " + banana.getName());
        System.out.println("  3. " + coqAuVin.getName());

        int choice = validateUserIntInput(1, 3);
        switch (choice){
            case 1:
                toReturn = apple;
                break;
            case 2:
                toReturn = banana;
                break;
            case 3:
                toReturn = coqAuVin;
                break;
        }

        return toReturn;
    }

    static Playing chooseWhatToPlay(){

        Playing toReturn = null;

        System.out.println("===============================");
        System.out.println("1. " + chess.getName());
        System.out.println("2. " + badminton.getName());
        System.out.println("3. " + fetch.getName());

        int choice = validateUserIntInput(1, 3);
        switch (choice){
            case 1:
                toReturn = chess;
                break;
            case 2:
                toReturn = badminton;
                break;
            case 3:
                toReturn = fetch;
                break;
        }

        return toReturn;
    }

    static void performAction(){

        boolean run = true;
        while (run){

            if (!tamagotchi.isAlive()){
                System.out.println(tamagotchi.getName() + " is dead");
                scan.close();
                break;
            }
            System.out.println(tamagotchi.toString());
            tamagotchi.validateMood();

            System.out.println("===============================");
            System.out.println("What should " + tamagotchi.getName() + " do now?");
            System.out.println("  1. Feed   ");
            System.out.println("  2. Play   ");
            System.out.println("  3. Sleep  ");
            System.out.println("  4. Clean  ");
            System.out.println("  5. View " + tamagotchi.getName() + "s stats");
            System.out.println("  6. Back to main menu");

            int choice = validateUserIntInput(1, 6);

            switch (choice){
                case 1:
                    Food toFeed = chooseWhatToEat();
                    tamagotchi.feed(toFeed);
                    break;
                case 2:
                    Playing toPlay = chooseWhatToPlay();
                    tamagotchi.play(toPlay);
                    break;
                case 3:
                    System.out.println("How many hours of rest?");
                    int hoursToSleep = validateUserIntInput(1, 10);
                    tamagotchi.sleep(hoursToSleep);
                    break;
                case 4:
                    tamagotchi.takeBath();
                    break;
                case 5:
                    System.out.println(tamagotchi.toString());
                    break;
                case 6:
                    run = false;
                    break;
            }
        }
    }

    static void createNewTamagotchi(int tamagitchiType){

        int happiness = getRandomNumber(5, 10);
        int tiredness = getRandomNumber(0, 5);
        int hungriness = getRandomNumber(0, 5);
        int cleanliness = getRandomNumber(5, 10);

        String name;

        if (tamagitchiType == 1){
            Dog.printAsciiDog();
            System.out.println("You choose a sweet dog!");
            System.out.println("What name should it have?");
            name = scan.next() + scan.nextLine();
            tamagotchi = new Dog(name, hungriness, happiness, tiredness, cleanliness);

        }
        else if (tamagitchiType == 2){
            Cat.printAsciiCat();
            System.out.println("You choose a sweet cat!");
            System.out.println("What name should it have?");
            name = scan.next() + scan.nextLine();
            tamagotchi = new Cat(name, hungriness, happiness, tiredness, cleanliness);

        }
        tamagotchi.makeSomNoise();
        performAction();

    }

    static int getRandomNumber(int minValue, int maxValue){

        int randomNumber = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
        return randomNumber;
    }

    static int validateUserIntInput(){
        int returnNum = 0;
        boolean run = true;
        while (run) {
            try {
                returnNum = scan.nextInt();
                run = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! try a number");
                scan.next();
            }
        }
        return returnNum;
    }

    static int validateUserIntInput(int minValue, int maxValue){
        int returnNum = 0;
        boolean run = true;
        while (run) {
            try {
                returnNum = scan.nextInt();
                if (returnNum >= minValue && returnNum <= maxValue){
                    run = false;
                }
                else {
                    System.out.println("The number has to be between " + (minValue - 1) + " and " + (maxValue + 1));
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! try a number");
                scan.next();
            }
        }
        return returnNum;
    }

    public static void main(String[] args) {

        startGame();

    }
}
