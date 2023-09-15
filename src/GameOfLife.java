public class GameOfLife {


    public static void main(String[] args) {

        Grid grid = initializeGrid();
        GameLogic gameLogic = new GameLogic();

        for (int generation = 1; generation <= 50; generation++) {
            System.out.println("Generation " + generation);
            System.out.println(grid.display());
            grid = gameLogic.nextGeneration(grid);
        }
    }

    private static Grid initializeGrid(){

        int rows = 20;
        int cols = 20;

        Grid grid = new Grid(rows, cols);

        // Place the 'Glider' pattern in the middle of the grid
        grid.setCellState(10, 11, true);
        grid.setCellState(11, 11, true);
        grid.setCellState(9, 10, true);
        grid.setCellState(8, 6, true);
        grid.setCellState(8, 9, true);

        return grid;

    }


}
