public class TurnRightCommand implements Command {
    @Override
    public void execute(Rover rover, Grid grid) {
        rover.setDirection(rover.getDirection().turnRight());
    }
}