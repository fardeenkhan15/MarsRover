public class TurnLeftCommand implements Command {
    @Override
    public void execute(Rover rover, Grid grid) {
        rover.setDirection(rover.getDirection().turnLeft());
    }
}