public class Obstacle implements GridComponent {
    @Override
    public boolean isObstacle() {
        return true;
    }

    @Override
    public String getRepresentation() {
        return "O";
    }
}