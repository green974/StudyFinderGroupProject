package com.company;

import java.util.Scanner;

import java.util.Date;

class studyfinder {

    static abstract class Superclass { // Requirement 13: Add multiple classes
        // Requirement 17: Abstraction method
        public static void display() {
            System.out.println("Welcome to the Studyfinder!");
        }
    }

    public static class Subclass extends Superclass { // Requirement 18: Inheritance
        public static void display() {
            System.out.println("Your number one tool to find out how many hours you should study for that test looming over your head!");
        }

        public void my_method() {
            Subclass sub = new Subclass();
            super.display(); // Requirement 16: Super keyword
            sub.display();
        }
    }


    static boolean run; // Requirement 2: Variables

    studyfinder(boolean r) { // Creating a constructor
        run = r;
    }

    public static void main(String[] args) {
        String theirName = TestTaker.getNombre();
        System.out.println("Your name is " + theirName);

        Date Today = new Date(); // Requirement 20: Java Library Class
        System.out.println("Hello! Today's date is: " + Today.toString());

        Subclass obj = new Subclass(); // Requirement 14: Create an object
        obj.my_method();

        studyfinder s1 = new studyfinder(true); // Requirement 15: Constructor
        while (run) { // Requirement 8: Loop

            Scanner input = new Scanner(System.in); // Requirement 1: Scanner Class
            final int EASY = 1; // Requirement 23: Modifier
            final int MEDIUM = 2;
            final int HARD = 3;


            System.out.println("How hard is your test, between 1-3? (1 = easy, 2 = medium, 3 = hard)");
            // Requirement 24: Println Method

            int difficulty = input.nextInt();
            switch (difficulty) { // Requirement 3: Switch Statement
                case 1:
                    difficulty = 1;
                    System.out.println("Easy? Great to hear!");
                    break;
                case 2:
                    difficulty = 2;
                    System.out.println("Somewhat difficult, huh? No problem.");
                    break;
                case 3:
                    difficulty = 3;
                    System.out.println("Dang, hard? I hope you're ready to study!");
                    break;
                default:
                    System.out.println("Invalid Input");
                    System.exit(0);

            }
            System.out.println("How prepared are you for this test? (1 = very, 2 = somewhat, 3 = not very)");
            int prepared = input.nextInt();
            switch (prepared) {
                case 1:
                    prepared = 1;
                    System.out.println("Very prepared? Awesome!");
                    break;
                case 2:
                    prepared = 2;
                    System.out.println("Somewhat prepared? Cool.");
                    break;
                case 3:
                    prepared = 3;
                    System.out.println("Not very prepared, huh? Uh oh... Don't worry about it though!");
                    break;
                default:
                    System.out.println("Invalid Input");
                    System.exit(0);
            }
            System.out.println("What grade you do want on the test? (A, B, C, D, E) Please use uppercase!");
            char grade = input.next(".").charAt(0); // String Class Method
            switch (grade) {
                case 'A':
                    System.out.println("You want an A. Good for you!");
                    break;
                case 'B':
                    System.out.println("You want a B. That's good enough!");
                    break;
                case 'C':
                    System.out.println("You want a C. Fair.");
                    break;
                case 'D':
                    System.out.println("Why do you want a D?");
                    break;
                case 'E':
                    System.out.println("You want an E? Uh...");
                    break;
                default:
                    System.out.println("Invalid Input");
            }
            double calc[] = new double[50]; // Requirement 12: Array

            double hour;
            if (grade == 'E') { // Requirement 4: Conditional Operator
                System.out.println("You don't need to study.");
            } else if (grade == 'D') {
                double D = .25;
                hour = D * prepared * difficulty; // Requirement 5: Operators
                calc[0] = hour;
                System.out.println("You need to study " + calc[0] + " hours.");
            } else if (grade == 'C') {
                double C = 1.0;
                hour = C * prepared * difficulty;
                calc[1] = hour;
                System.out.println("You need to study " + calc[1] + " hours.");
            } else if (grade == 'B') {
                double B = 2.0;
                hour = B * prepared * difficulty;
                calc[2] = hour;
                System.out.println("You need to study " + calc[2] + " hours.");
            } else if (grade == 'A') {
                double A = 4.0;
                hour = A * prepared * difficulty;
                double confusing = Math.pow(hour, 1); // Requirement 7: Math Class Methods
                calc[3] = confusing;
                System.out.println("You need to study " + calc[3] + " hours.");
            } else System.out.println("You don't need to study.");

            System.out.println("Would you like to restart? Y/N?");
            char restart = input.next(".").charAt(0);

            switch (restart) {
                case 'Y':
                    break;
                case 'N':
                    run = false;

            }
        }

        System.out.println(thanks(1)); // Requirement 9: Pass By Value

        System.out.println(thanks("From Victor, Ben, Jun, Seulah, Jacob, and Ray!"));

    }

    public static String thanks(int num) { // Requirement 6: String class method
        return ("You are number " + num + "!! You're the best! Give us an A!"); // Requirement 10: Return value from method
    }

    public static String thanks(String num) { // Requirement 11: Overloading
        return ("Thank you for running our program! " + num);
    }

    public static class TestTaker { // Requirement 19: Encapsulation
        private static String firstName = "Shiva"; // Requirement 21: Static variable
        private static String lastName = "Sharma";

        public TestTaker(String nameOne, String nameTwo) {
            nameOne = firstName;
            nameTwo = lastName;

            this.firstName = nameOne; // Requirement 22: "This" keyword
            this.lastName = nameTwo;
        }

        public static String getNombre() { // Requirement 21: Static method
            return firstName + " " + lastName;
        }

        public String setFirstNombre(String item) {
            firstName = item;
            return item;
        }
    }
}