public class MoveCommand implements Command {
    @Override
    public void execute(Rover rover, Grid grid) {
        Position newPosition = calculateNewPosition(rover);
        if (grid.isValidPosition(newPosition)) {
            if (!grid.isObstacle(newPosition)) {
                rover.setPosition(newPosition);
                Logger.log("Rover moved to " + newPosition.getX() + "," + newPosition.getY());
            } else {
                Logger.log("Cannot move. Obstacle detected at " + newPosition.getX() + "," + newPosition.getY() + ". Please choose another direction.");
                System.out.println("Cannot move. Obstacle detected at " + newPosition.getX() + "," + newPosition.getY() + ". Please choose another direction.");
            }
        } else {
            Logger.log("Cannot move. Position out of bounds.");
            System.out.println("Cannot move. Position out of bounds.");
        }
    }

    private Position calculateNewPosition(Rover rover) {
        Position currentPosition = rover.getPosition();
        switch (rover.getDirection()) {
            case N: return new Position(currentPosition.getX(), currentPosition.getY() + 1);
            case E: return new Position(currentPosition.getX() + 1, currentPosition.getY());
            case S: return new Position(currentPosition.getX(), currentPosition.getY() - 1);
            case W: return new Position(currentPosition.getX() - 1, currentPosition.getY());
            default: return currentPosition;
        }
    }
}
