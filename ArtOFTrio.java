import java.util.Scanner;

public class ArtOFTrio {
      public static void main(String[] args) {
        System.out.println("\t\t\t\t!!!   Welcome to Art Of Trio  !!!");
        System.out.println("Manual : ");

        System.out.println("Every level has a stored puzzle. In each level and each round user has to connect two points from the given available points.");
        System.out.println("They have to try to connect the points same as they are connected in the fixed puzzle.");
        System.out.println("Good luck on your experience with this game & try to get help from your luck to finish this trio successfully.");

        System.out.println("");
        System.out.println("");

        System.out.println("Select a level: ");
        System.out.println("1. Level 1");
        System.out.println("2. Level 2");
        System.out.println("3. Level 3");
        System.out.println();

        Puzzle2 puzzleGame = new Puzzle2();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Level:");
        int selectedLevel = scanner.nextInt();

        switch (selectedLevel) {
            case 1:
                puzzleGame.playLevel1();
                break;
            case 2:
                puzzleGame.playLevel2();
                break;
            case 3:
                puzzleGame.playLevel3();
                break;
            default:
                System.out.println("Invalid level selection.");
                break;
        }
    }
    

}
