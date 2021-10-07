import java.util.Arrays;

public class Dog extends Tamagotchi{

    public Dog(String name, int hungriness, int happiness, int tiredness, int cleanliness) {
        super(name, hungriness, happiness, tiredness, cleanliness);
    }

    @Override
    public void makeSomNoise() {
        System.out.println("Vuf");
    }

    @Override
    public String toString() {

        return  "======== " + getName().toUpperCase() + " ========\n"  +
                "Cleanliness  -  " + getCleanliness()   + "\n" +
                "Happiness    -  " + getHappiness()   + "\n" +
                "tiredness    -  " + getTiredness() + "\n"+
                "Hungriness   -  " + getHungriness()  + "\n"   +
                "-------------------------------";
    }

    public static void printAsciiDog(){
        System.out.println("    ----------------------");
        System.out.println("    |                    |");
        System.out.println("    |                    |");
        System.out.println("    |                    |");
        System.out.println("    |                    |");
        System.out.println("    |        .--.__      |");
        System.out.println("    |        | ;'__P     |");
        System.out.println("    |        '.;\\        |");
        System.out.println("    |         | .)       |");
        System.out.println("    |         ';.L       |");
        System.out.println("    |                    |");
        System.out.println("    |                    |");
        System.out.println("    |                    |");
        System.out.println("    ----------------------");

    }

    @Override
    public void play(Playing game) {
        if(game.getName().equals("Fetch")){
            addHappiness(game.getHappinessEffect());
        }
        addTiredness(game.getTirednessEffect());
        addHungriness(game.getFullfilling());
        addCleanliness(game.getCleanlinessEffect());

    }

    @Override
    public void sleep(int hours) {
        if (hours <= 2){
            addTiredness(-4);
            addHungriness(3);
        }else if(hours >= 7){
            setTiredness(0);
            addHungriness(6);
        }
    }

    @Override
    public void takeBath() {
        setCleanliness(10);
        addHappiness(-1);
    }

}
