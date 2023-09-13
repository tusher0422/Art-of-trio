import java.util.*;
import java.time.Duration;
import java.time.Instant;

public class Puzzle2{

    Display display = new Display();

    int [][]  puzzle1 = new int [][] {
        {0, 1, 1, 0, 1},
        {1, 0, 0, 1, 1},
        {1, 0, 0, 1, 1},
        {0, 1, 1, 0, 0},
        {1, 1, 1, 0, 0}
    };

    int [][]  puzzle2 = new int [][] {
        {0, 1, 1, 0, 1, 0},
        {1, 0, 0, 0, 1, 1},
        {1, 0, 0, 1, 1, 0},
        {0, 0, 1, 0, 1, 0},
        {1, 1, 1, 1, 0, 0},
        {0, 1, 0, 0, 0, 0},
    };

    int [][]  puzzle3 = new int [][] {
        {0, 3, 2, 0, 0, 4},
        {3, 0, 1, 4, 0, 6},
        {2, 1, 0, 5, 2, 0},
        {0, 4, 5, 0, 1, 1},
        {0, 0, 2, 1, 1, 0},
        {4, 6, 0, 1, 0, 0},
    };

    private Graph puzzleGraph;

    public Puzzle2() {
        
        adjacencyMatrix = new int[][]  {
            {0, 3, 2, 0, 0, 4},
            {3, 0, 1, 4, 0, 6},
            {2, 1, 0, 5, 2, 0},
            {0, 4, 5, 0, 1, 1},
            {0, 0, 2, 1, 1, 0},
            {4, 6, 0, 1, 0, 0},

        };

        puzzleGraph = new Graph(adjacencyMatrix);    
        int size = puzzle3.length;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int weight = puzzle3[i][j];
                if (weight > 0) {
                    puzzleGraph.addEdge(i, j, weight);
                    puzzleGraph.addEdge(j, i, weight);
                }
            }
        }
    }

      public void playLevel1() {
        Scanner scanner = new Scanner(System.in);
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
            System.out.println("Available Nodes: ");
            display.print();
            System.out.println();

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
            display.print1();
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
    private int[] getValidOptions3(int round) {
                int[] validOptions3 = new int[round + 2];
                for (int i = 0; i < validOptions3.length; i++) {
                    validOptions3[i] = i + 3 - round;
                    if (validOptions3[i] == 0){
                        validOptions3[i] = 6;
                    }
                }
                return validOptions3;
    }

    private boolean isValidOption3(int option, int[] validOptions3) {
                for (int validOption3 : validOptions3) {
                    if (option == validOption3) {
                        return true;
                    }
                }
                return false;
    }
    public void playLevel2() {
      Scanner scanner = new Scanner(System.in);
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
                System.out.println("Available Nodes: ");
                display.print4();
                System.out.println();
                
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
                display.print5();
                System.out.println("Congratulations! You passed Level 2.");
            } else {
                System.out.println("Sorry, you didn't pass Level 2. Better luck next time.");
            }
    }

    int[][] adjacencyMatrix;

    public void playLevel3() {
        Scanner scanner = new Scanner(System.in);
        int round = 1;
        int tries = 11;
        int matchesNeeded = 1; 
        Instant startTime = Instant.now();
        Duration timeLimit = Duration.ofSeconds(60);

        while (round <= 3 && tries > 0 && Duration.between(startTime, Instant.now()).compareTo(timeLimit) <= 0) {
            int start, end;
            int[] validOptions3 = getValidOptions3(round);

            System.out.println("Remaining time: " + (timeLimit.toMillis() - Duration.between(startTime, Instant.now()).toMillis()) / 1000 + " seconds");
            System.out.println("Remaining tries: " + tries);
            System.out.println("Available Nodes: ");
            display.print4();
            System.out.println();

            do {
                System.out.println("Round " + round + " - Choose a start point (" + Arrays.toString(validOptions3) + ") for Level 3: ");
                start = scanner.nextInt();
            } while (!isValidOption3(start, validOptions3));

            do {
                System.out.println("Round " + round + " - Choose an end point (" + Arrays.toString(validOptions3) + ") for Level 3: ");
                end = scanner.nextInt();
            } while (!isValidOption3(end, validOptions3));

            List<Integer> shortestPath = puzzleGraph.shortestPath(start - 1, end - 1, adjacencyMatrix);
            if (shortestPath.contains(start - 1) && shortestPath.contains(end - 1)) {
                boolean connected = false;
                for (int i = 0; i < shortestPath.size() - 1; i++) {
                    if ((shortestPath.get(i) == start - 1 && shortestPath.get(i + 1) == end - 1) ||
                        (shortestPath.get(i) == end - 1 && shortestPath.get(i + 1) == start - 1)) {
                        connected = true;
                        break;
                    }
                }
                if (connected) {
                    System.out.println("Round " + round + " - Connected in shortest path!");
                    matchesNeeded--;
            
                    if (matchesNeeded == 0) {
                        round++;
                        matchesNeeded = round;
                    }
                } else {
                    System.out.println("Round " + round + " - Not connected in shortest path.");
                    tries--;
                }
            } else {
                System.out.println("Round " + round + " - Not in shortest path.");
                tries--;
            }
            
        }

        if (round > 3) {
            System.out.println("Congratulations! You passed Level 3.");
        } else {
            System.out.println("Sorry, you didn't pass Level 3. Better luck next time.");
        }
    }
}