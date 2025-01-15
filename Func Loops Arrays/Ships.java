import java.util.Scanner;
import java.util.Random;

public class Ships {

    //You are tasked with sinking all 3 ships hidden on a 5x5 grid. Each turn, enter a row and column to fire at a location. 
    //A hit is marked with 'X', and a miss with 'O'. You have only 5 turns to sink all the ships. 
    //If you sink them all, you win—otherwise, it’s game over!
    public static void main(String[] args) {
        int gridSize = 5; 
        int totalShips = 3; 
        int turns = 5;

        char[][] grid = new char[gridSize][gridSize];
        boolean[][] ships = new boolean[gridSize][gridSize];

        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = '~';
            }
        }

        Random random = new Random();
        for (int i = 0; i < totalShips; ) {
            int row = random.nextInt(gridSize);
            int col = random.nextInt(gridSize);
            if (!ships[row][col]) {
                ships[row][col] = true;
                i++;
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Simple Battleship!");
        System.out.println("Sink all " + totalShips + " ships. You have " + turns + " turns.");

        while (turns > 0 && totalShips > 0) {
            System.out.println("\nYour Grid:");
            printGrid(grid);

            System.out.print("Enter row (0 to " + (gridSize - 1) + "): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0 to " + (gridSize - 1) + "): ");
            int col = scanner.nextInt();

            if (row < 0 || row >= gridSize || col < 0 || col >= gridSize) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (grid[row][col] == 'X' || grid[row][col] == 'O') {
                System.out.println("You already guessed this spot!");
                continue;
            }

            turns--;

            if (ships[row][col]) {
                grid[row][col] = 'X'; 
                totalShips--;
                System.out.println("You hit a ship! Ships left: " + totalShips);
            } else {
                grid[row][col] = 'O'; 
                System.out.println("You missed!");
            }
        }

        if(totalShips == 0){
            System.out.println("\nCongratulations! You sunk all the ships!");
        }else{
            System.out.println("\nGame over! You ran out of turns.");
        }

        System.out.println("\nFinal Grid:");
        printGrid(grid);
        scanner.close();
    }

    public static void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

