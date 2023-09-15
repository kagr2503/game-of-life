
// Grid class representing the game board
class Grid {

    //Assuming the fix size board otherwise it's goes to infinite loop
    private int rows;
    private int cols;
    private Cell[][] cells;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
        initializeGrid();
    }

    public void initializeGrid() {
        // Initialize all cells as dead
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void setCellState(int row, int col, boolean alive) {
        cells[row][col].setAlive(alive);
    }

    public boolean getCellState(int row, int col) {
        return cells[row][col].isAlive();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(cells[i][j].isAlive() ? "1 " : "0 ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}