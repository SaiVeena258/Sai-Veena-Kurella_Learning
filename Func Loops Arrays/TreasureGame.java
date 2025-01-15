import java.util.Scanner;

public class TreasureGame {
    
    //Navigate through the game by typing "left", "right" or "forward". Each move triggers a random event: you may encounter a monster (game over), 
    //find the treasure (you win) or walk a safe path (continue). Invalid inputs will prompt you to try again.
    //The game ends when you win or lose—good luck!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;

        System.out.println("Welcome to a Treasure Game!");
        System.out.println("Navigate through by typing 'left', 'right' or 'forward'.");
        System.out.println("Beware of monsters and try to find the treasure. Good luck!\n");

        while (gameRunning) {
            System.out.print("Choose a direction (left/right/forward): ");
            String direction = scanner.nextLine().toLowerCase();

            if (!direction.equals("left") && !direction.equals("right") && !direction.equals("forward")) {
                System.out.println("Invalid choice! Please type 'left', 'right' or 'forward'.");
                continue;
            }

            int event = (int) (Math.random() * 3); 
            
            switch (event) {
                case 0: // Monster 
                    System.out.println("Oh no! You encountered a monster. Game over!");
                    gameRunning = false;
                    break;
                case 1: // Treasure
                    System.out.println("Congratulations! You found the treasure. You win!");
                    gameRunning = false;
                    break;
                case 2: // Safe path
                    System.out.println("The path is safe... for now. Keep going!");
                    break;
            }
        }

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}

