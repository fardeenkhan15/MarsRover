public class EmptySpace implements GridComponent {
    @Override
    public boolean isObstacle() {
        return false;
    }

    @Override
    public String getRepresentation() {
        return ".";
    }
}