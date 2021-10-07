import java.util.ArrayList;

public abstract class Tamagotchi {

    private String name;
    private boolean alive = true;

    private int hungriness;
    private int happiness;
    private int tiredness;
    private int cleanliness;

    public Tamagotchi(String name, int hungriness, int happiness, int tiredness, int cleanliness) {
        this.name = name;
        this.hungriness = hungriness;
        this.happiness = happiness;
        this.tiredness = tiredness;
        this.cleanliness = cleanliness;
    }


    public abstract void makeSomNoise();

    public abstract void play(Playing game);

    public void feed(Food food){
        hungriness -= food.getFullfilling();
        happiness += food.getHappinessEffect();
        tiredness += food.getTirednessEffect();
    }

    public abstract void sleep(int hours);

    public abstract void takeBath();

    public void validateMood(){

        if (this.hungriness < 6 && this.tiredness < 8 && this.cleanliness > 4 && this.happiness > 4){
            System.out.println(this.name + " is very satisfied");
        }

// -------------------- humgriness valadation --------------------
        if (this.hungriness > 10) {
            this.alive = false;
        }
        else if (this.hungriness < 0) {
            this.hungriness = 0;
        }
        else if (this.hungriness >= 6){
            System.out.println(name + " is hungry!");
        }
// -------------------- tiredness valadation --------------------
        if (this.tiredness > 10){
            this.alive = false;
        }
        else if (this.tiredness < 0) {
            this.tiredness = 0;
        }
        else if (this.tiredness >= 8){
            System.out.println(name + " is very tired!");
        }
// -------------------- cleanliness valadation --------------------
        if (this.cleanliness < 0) {
            this.alive = false;
        }
        else if (this.cleanliness > 10) {
            this.cleanliness = 10;
        }
        else if (this.cleanliness <= 4){
            System.out.println(name + " could use a bath!");
        }
// -------------------- happiness valadation --------------------
        if (this.happiness < 0) {
            this.alive = false;
        }
        else if (this.happiness > 10) {
            this.happiness = 10;
        }
        else if (this.happiness <= 4){
            System.out.println(name + " is not feeling happy!");
        }
    }

    public String toString() {

        return  "======== " + getName().toUpperCase() + " ========\n"  +
                "Cleanliness  -  " + getCleanliness()   + "\n" +
                "Happiness    -  " + getHappiness()   + "\n" +
                "tiredness    -  " + getTiredness() + "\n"+
                "Hungriness   -  " + getHungriness()  + "\n"   +
                "-------------------------------";
    }

//--------------------------- Setters, Getters & Adders ---------------------------
    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getHungriness() {
        return hungriness;
    }

    public void addHungriness(int hungriness) {
        this.hungriness += hungriness;
    }

    public int getHappiness() {
        return happiness;
    }

    public void addHappiness(int happiness) {
        this.happiness += happiness;
    }

    public int getTiredness() {
        return tiredness;
    }

    public void addTiredness(int tiredness) {
        this.tiredness += tiredness;
    }

    public void setTiredness(int tiredness) {
        this.tiredness = tiredness;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void addCleanliness(int cleanliness) {
        this.cleanliness += cleanliness;
    }

    public void setCleanliness(int cleanliness){
        this.cleanliness = cleanliness;
    }
}
