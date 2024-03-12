package org.example;
import java.util.Scanner;
import java.util.Random;
class Die {
    private int value;
    public Die() {
        this.value = 0;
    }
    // code for 6 sides of dice
    public void roll() {
        Random random = new Random();
        this.value = random.nextInt(6) + 1;
    }
    // get dice value
    public int getValue() {
        return this.value;
    }
}

class Dice {
    private final Die die1;
    private final Die die2;
    public Dice() {
        this.die1 = new Die();
        this.die2 = new Die();
    }

    public int getDie1Value() {
        return this.die1.getValue();
    }
    public int getDie2Value() {
        return this.die2.getValue();
    }
    public int getSum() {
        return this.die1.getValue() + this.die2.getValue();
    }
    public void roll() {
        this.die1.roll();
        this.die2.roll();
    }
    public void printRoll() {
        System.out.println("Die 1: " + this.getDie1Value());
        System.out.println("Die 2: " + this.getDie2Value());
        System.out.println("Total: " + this.getSum());

        if (this.getSum() == 7)
            System.out.println("Craps!");
        else if (this.getDie1Value() == 1 && this.getDie2Value() == 1)
            System.out.println("Snake eyes!");
        else if (this.getDie1Value() == 6 && this.getDie2Value() == 6)
            System.out.println("Box cars!");
    }
}

public class DiceRoller {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dice Roller\n");
        String rollthedice;
        System.out.print("\nRoll the dice? (y/n): ");
        rollthedice = scanner.nextLine();
        if (rollthedice.equalsIgnoreCase("y")){
            rollDice();
        }
        while (rollthedice.equalsIgnoreCase("y")) {
            System.out.print("\nRoll again? (y/n): ");
            rollthedice = scanner.nextLine();
            if (rollthedice.equalsIgnoreCase("y")) {
                rollDice();
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static void rollDice() {
        Dice dice = new Dice();
        dice.roll();
        dice.printRoll();
    }
}
