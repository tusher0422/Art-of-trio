
import java.util.*;
import java.time.Duration;
import java.time.Instant;

public class Puzzle2 {
    int [][]  puzzle1 = new int [][] {
        {0, 1, 1, 0, 1},
        {1, 0, 0, 1, 1},
        {1, 0, 0, 1, 1},
        {0, 1, 1, 0, 0},
        {1, 1, 1, 0, 0}
    };
    int [][]  puzzle2 = new int [][] {
        {0, 1, 1, 0, 0, 1},
        {1, 0, 0, 0, 1, 1},
        {1, 0, 0, 1, 1, 0},
        {0, 0, 1, 0, 1, 0},
        {0, 1, 1, 1, 0, 0},
        {1, 1, 0, 0, 0, 0},
    };

   
    public void playLevel1() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int round = 1;
        int tries = 10;
        int matchesNeeded = 1;
        Instant startTime = Instant.now();
        Duration timeLimit = Duration.ofSeconds(120);

        while (round <= 3 && tries > 0 && Duration.between(startTime, Instant.now()).compareTo(timeLimit) <= 0) {
            int start, end;
            int[] validOptions = getValidOptions(round);

            System.out.println("Remaining time: " + (timeLimit.toMillis() - Duration.between(startTime, Instant.now()).toMillis()) / 1000 + " seconds");
            System.out.println("Remaining tries: " + tries);

            do {
                System.out.println("Round " + round + " - Choose a start point (" + Arrays.toString(validOptions) + ") for Level 1: ");
                start = scanner.nextInt();
            } while (!isValidOption(start, validOptions));

            do {
                System.out.println("Round " + round + " - Choose an end point (" + Arrays.toString(validOptions) + ") for Level 1: ");
                end = scanner.nextInt();
            } while (!isValidOption(end, validOptions));

            if (puzzle1[start - 1][end - 1] == 1 ) {
                System.out.println("Round " + round + " - It's a match!");
                matchesNeeded--;

                if (matchesNeeded == 0) {
                    round++;
                    matchesNeeded = round;
                }
            } else {
                System.out.println("Round " + round + " - Invalid choice. No match.");
                tries--;
            }
        }

        if (round > 3) {
            System.out.println("Congratulations! You passed Level 1.");
        } else {
            System.out.println("Sorry, you didn't pass Level 1. Better luck next time.");
        }
    }

    private int[] getValidOptions(int round) {
        int[] validOptions = new int[round + 2];
        for (int i = 0; i < validOptions.length; i++) {
            validOptions[i] = i + 3 - round;
            if (validOptions[i] == 0){
                validOptions[i] = 5;
            }
        }
        return validOptions;
    }

    private boolean isValidOption(int option, int[] validOptions) {
        for (int validOption : validOptions) {
            if (option == validOption) {
                return true;
            }
        }
        return false;
    }
    public void playLevel2() {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int round = 1;
            int tries = 9;  
            int matchesNeeded = 1;
            Instant startTime = Instant.now();
            Duration timeLimit = Duration.ofSeconds(90);
        
            while (round <= 3 && tries > 0 && Duration.between(startTime, Instant.now()).compareTo(timeLimit) <= 0) {
                int start, end;
                int[] validOptions = getValidOptions(round);
        
                System.out.println("Remaining time: " + (timeLimit.toMillis() - Duration.between(startTime, Instant.now()).toMillis()) / 1000 + " seconds");
                System.out.println("Remaining tries: " + tries);
        
                do {
                    System.out.println("Round " + round + " - Choose a start point (" + Arrays.toString(validOptions) + ") for Level 2: ");
                    start = scanner.nextInt();
                } while (!isValidOption(start, validOptions));
        
                do {
                    System.out.println("Round " + round + " - Choose an end point (" + Arrays.toString(validOptions) + ") for Level 2: ");
                    end = scanner.nextInt();
                } while (!isValidOption(end, validOptions));
        
                if (puzzle2[start - 1][end - 1] == 1) {
                    System.out.println("Round " + round + " - It's a match!");
                    matchesNeeded--;
        
                    if (matchesNeeded == 0) {
                        round++;
                        matchesNeeded = round;
                    }
                } else {
                    System.out.println("Round " + round + " - Invalid choice. No match.");
                    tries--;
                }
            }
        
            if (round > 3) {
                System.out.println("Congratulations! You passed Level 2.");
            } else {
                System.out.println("Sorry, you didn't pass Level 2. Better luck next time.");
            }
        }
    

    public static void main(String[] args) {
        Puzzle2 puzzleGame = new Puzzle2();

        System.out.println("Welcome to the Puzzle Game!");
        System.out.println("Select a level: ");
        System.out.println("1. Level 1");
        System.out.println("2. Level 2");

        Scanner scanner = new Scanner(System.in);
        int selectedLevel = scanner.nextInt();

        switch (selectedLevel) {
            case 1:
                puzzleGame.playLevel1();
                break;
            case 2:
                puzzleGame.playLevel2();
                break;
            default:
                System.out.println("Invalid level selection.");
                break;
        }
    }
}

