Mars Rover Simulation

Overview
  This project is a console-based simulation of a Mars Rover navigating a grid-based terrain. The rover can move forward, turn left, and turn right, while avoiding obstacles and staying within the boundaries of the grid. The project is implemented using Java, adhering to Object-Oriented Programming principles, design patterns, and best coding practices.

Features
  Initialize the rover with a starting position and direction.
  Execute commands to move the rover forward, turn left, and turn right.
  Detect and avoid obstacles in the grid.
  Report the rover's current status, including position and direction.
  Handle invalid inputs and display appropriate error messages.

Design Patterns Used
  Command Pattern: Encapsulates Move, Turn Left, and Turn Right commands as objects for flexibility.
  Composite Pattern: Represents the grid and obstacles.
  Enum: Represents directions (N, E, S, W).

Classes and Interfaces
  Command Interface: Defines the contract for commands.
  Direction Enum: Defines possible directions and methods to turn left or right.
  GridComponent Interface: Represents components of the grid (empty space and obstacles).
  EmptySpace and Obstacle Classes: Implement GridComponent for empty spaces and obstacles.
  Grid Class: Represents the grid, handles initialization, obstacle addition, and validity checks.
  Position Class: Represents a position on the grid with x and y coordinates.
  Rover Class: Represents the rover, handles command execution, and provides status reports.
  Logger Class: Logs messages with timestamps.
  MoveCommand, TurnLeftCommand, TurnRightCommand Classes: Implement the Command interface for respective commands.
  MarsRoverApplication Class: Main application class, handles user input, and orchestrates the simulation.

Prerequisites
  Java Development Kit (JDK) 8 or higher
  A Java IDE or text editor
  Command line interface (CLI)

  
Setup and Execution
  Clone the Repository
  git clone <repository-url>
  cd marsRover
  
Compile the Code
javac -d bin src/*.java

Run the Application
java -cp bin MarsRoverApplication

Follow the Prompts
  Enter grid width and height.
  Specify the number of obstacles and their coordinates.
  Enter the initial rover position and direction.
  Enter commands (M for move, L for turn left, R for turn right) or Q to quit.
  The application will display the rover's status and grid after each command.

Example Usage
mathematica
Copy code
Enter grid width:
5
Enter grid height:
5
Enter number of obstacles:
1
Enter obstacle X coordinate:
0
Enter obstacle Y coordinate:
0
Enter initial rover X coordinate:
1
Enter initial rover Y coordinate:
3
Enter initial rover direction (N/E/S/W):
S
Enter commands (M/L/R) or Q to quit:
M
Initial Rover is at (1, 3) facing S.
After 'M': Rover is at (1, 2) facing S.
Final Rover is at (1, 2) facing S.
. . . . .
. . . . .
. R . . .
. . . . .
O . . . .

Logging
  The application logs important events with timestamps to the console, including movements, obstacle detections, and invalid actions.
  
Error Handling
  The application validates inputs and provides error messages for invalid grid dimensions, coordinates, directions, and commands.
