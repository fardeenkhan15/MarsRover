public class Grid {
    private GridComponent[][] grid;

    public Grid(int width, int height) {
        grid = new GridComponent[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = new EmptySpace();
            }
        }
    }

    public void addObstacle(Position position) {
        grid[position.getY()][position.getX()] = new Obstacle();
    }

    public boolean isObstacle(Position position) {
        return grid[position.getY()][position.getX()].isObstacle();
    }

    public boolean isValidPosition(Position position) {
        return position.getX() >= 0 && position.getX() < getWidth() &&
               position.getY() >= 0 && position.getY() < getHeight();
    }

    public int getWidth() {
        return grid[0].length;
    }

    public int getHeight() {
        return grid.length;
    }

    public String getRepresentation(Position position) {
        return grid[position.getY()][position.getX()].getRepresentation();
    }
}