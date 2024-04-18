import java.util.Scanner;
import java.util.Random;

// user defined exception
class InvalidInputException extends Exception {
    InvalidInputException(String msg) {
        super(msg);
    }
}

class Game {
    int user_choice;
    int computer_choice;

    // taking input from users.
    int input() throws InvalidInputException {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter '0' for rock, '1' for Scissor ,'2' for paper:");
        user_choice = sc.nextInt();
        if (user_choice > 2 || user_choice < 0) {
            throw new InvalidInputException("Invalid input. Please choose a number from 0 to 2.");
        }
        return user_choice;
    }

    // generating random number for computer
    int numberGenerator() {
        Random r = new Random();
        computer_choice = r.nextInt(3);
        System.out.println("Computer choice: " + computer_choice);
        return computer_choice;
    }

    // decide the winner by comparing the input they have assigned
    void compare() {
        if (user_choice == 0 && computer_choice == 1)
            System.out.println("You Win!!🎉");
        else if (user_choice == 1 && computer_choice == 2)
            System.out.println("You Win!!🎉");
        else if (user_choice == 2 && computer_choice == 0)
            System.out.println("You Win!!🎉");
        else if (user_choice == computer_choice)
            System.out.println("Match Draw....");
        else
            System.out.println("You lose!!😔");
    }

    boolean loop() {
        boolean is_con = true;
        while (is_con) {
            try {
                input();
                numberGenerator();
                compare();
                is_con = wantToContinue();
            } catch (InvalidInputException nee) {
                System.out.println(nee.getMessage());
            }
        }
        return is_con;
    }

    boolean wantToContinue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue? Type 'y' or 'n':");
        String wantToContinue = scanner.next();
        scanner.close();
        return wantToContinue.equalsIgnoreCase("y");
    }
}

public class RPSGame {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Game g = new Game();
        boolean continuePlaying = true;
        while (continuePlaying) {
            continuePlaying = g.loop();
        }
        System.out.println("Thank you for playing!!");
        s.close();
    }
}
