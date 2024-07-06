import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class MarsRoverApplication {
    private static final Map<Character, Command> COMMAND_MAP = new HashMap<>();
    static {
        COMMAND_MAP.put('M', new MoveCommand());
        COMMAND_MAP.put('L', new TurnLeftCommand());
        COMMAND_MAP.put('R', new TurnRightCommand());
    }

    private static Scanner scanner = new Scanner(System.in);

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // clear the invalid input
            }
        }
    }

    public static void main(String[] args) {
        int width = getIntInput("Enter grid width:");
        int height = getIntInput("Enter grid height:");
        Grid grid = new Grid(width, height);

        int obstacleCount = getIntInput("Enter number of obstacles:");
        for (int i = 0; i < obstacleCount; i++) {
            int x = getIntInput("Enter obstacle X coordinate:");
            int y = getIntInput("Enter obstacle Y coordinate:");
            grid.addObstacle(new Position(x, y));
        }

        int roverX = getIntInput("Enter initial rover X coordinate:");
        int roverY = getIntInput("Enter initial rover Y coordinate:");
        
        System.out.println("Enter initial rover direction (N/E/S/W):");
        Direction roverDirection;
        while (true) {
            try {
                roverDirection = Direction.valueOf(scanner.next().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid direction. Please enter N, E, S, or W.");
            }
        }

        Rover rover = new Rover(new Position(roverX, roverY), roverDirection);

        scanner.nextLine(); // Consume newline

        while (true) {
            System.out.println("Enter commands (M/L/R) or Q to quit:");
            String commands = scanner.nextLine().toUpperCase();
            if (commands.equals("Q")) {
                break;
            }

            System.out.println("Initial " + rover.getStatusReport());

            for (char c : commands.toCharArray()) {
                Command command = COMMAND_MAP.get(c);
                if (command != null) {
                    rover.executeCommand(command, grid);
                    System.out.println("After '" + c + "': " + rover.getStatusReport());
                } else {
                    System.out.println("Unknown command: " + c);
                }
            }

            System.out.println("Final " + rover.getStatusReport());
            printGrid(grid, rover);
        }

        scanner.close();
    }

    private static void printGrid(Grid grid, Rover rover) {
        for (int y = grid.getHeight() - 1; y >= 0; y--) {
            for (int x = 0; x < grid.getWidth(); x++) {
                Position pos = new Position(x, y);
                if (pos.equals(rover.getPosition())) {
                    System.out.print("R ");
                } else {
                    System.out.print(grid.getRepresentation(pos) + " ");
                }
            }
            System.out.println();
        }
    }
}
