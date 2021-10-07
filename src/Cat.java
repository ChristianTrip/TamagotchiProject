public class Cat extends Tamagotchi {

    public Cat(String name, int hungriness, int happiness, int tiredness, int cleanliness) {
        super(name, hungriness, happiness, tiredness, cleanliness);
    }

    @Override
    public void makeSomNoise() {
        System.out.println("Miauw");
    }

    @Override
    public void play(Playing game){
        if(game.getName().equals("Fetch")){
            addHappiness(-game.getHappinessEffect());
        }
        addTiredness(game.getTirednessEffect());
        addHungriness(game.getFullfilling());
        addCleanliness(game.getCleanlinessEffect());
    }

    @Override
    public void sleep(int hours) {
        if (hours <= 2){
            addTiredness(-4);
            addHungriness(4);
        }else if(hours >= 7){
            setTiredness(0);
            addHungriness(6);
        }
    }

    @Override
    public void takeBath() {
        setCleanliness(10);
        addHappiness(-2);
    }


    public static void printAsciiCat(){
        System.out.println("----------------------");
        System.out.println("|     )\\   _,        |");
        System.out.println("|     | \"^\" (        |");
        System.out.println("|     (e  a )        |");
        System.out.println("|    =-\\Y  -=        |");
        System.out.println("|       T\"^)   _     |");
        System.out.println("|      /   (  ((     |");
        System.out.println("|     /    < _ ';,   |");
        System.out.println("|    (      ) )  \\\\  |");
        System.out.println("|     \\ Y  '  /  ))  |");
        System.out.println("|      || ;  /   //  |");
        System.out.println("|      )| ( (__,</   |");
        System.out.println("|    c{{i.}}=oo-^    |");
        System.out.println("----------------------");
    }
}
