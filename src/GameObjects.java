public class GameObjects {

    private String name;
    private int fullfilling;
    private int tirednessEffect;
    private int happinessEffect;
    private int cleanlinessEffect;


    public GameObjects(String name, int fullfilling, int tirednessEffect, int happinessEffect, int cleanlinessEffect) {
        this.name = name;
        this.fullfilling = fullfilling;
        this.tirednessEffect = tirednessEffect;
        this.happinessEffect = happinessEffect;
        this.cleanlinessEffect = cleanlinessEffect;
    }




    public String getName() {
        return name;
    }

    public int getFullfilling() {
        return fullfilling;
    }

    public int getTirednessEffect() {
        return tirednessEffect;
    }

    public int getHappinessEffect() {
        return happinessEffect;
    }

    public int getCleanlinessEffect() {
        return cleanlinessEffect;
    }
}

