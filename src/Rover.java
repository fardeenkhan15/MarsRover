public class Rover {
    private Position position;
    private Direction direction;

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }
    public Direction getDirection() { return direction; }
    public void setDirection(Direction direction) { this.direction = direction; }

    public void executeCommand(Command command, Grid grid) {
        command.execute(this, grid);
    }

    public String getStatusReport() {
        return String.format("Rover is at (%d, %d) facing %s.", 
                             position.getX(), position.getY(), direction);
    }
}