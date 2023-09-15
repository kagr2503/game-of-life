public class GameLogic {

    public Grid nextGeneration(Grid currentGen) {

        // Creating a new grid to store the next generation board
        Grid nextGen = new Grid(currentGen.getRows(), currentGen.getCols());

        for (int i = 0; i < currentGen.getRows(); i++) {
            for (int j = 0; j < currentGen.getCols(); j++) {
                int liveNeighbors = countLiveNeighbors(i, j, currentGen);
                if(currentGen.getCellState(i, j)){
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        nextGen.setCellState(i, j, false); // Cell dies
                    } else {
                        nextGen.setCellState(i, j, true); // Cell lives
                    }
                } else {
                    if (liveNeighbors == 3) {
                        nextGen.setCellState(i, j, true); // Cell reproduction
                    }
                }
            }
        }

        // Return the next generation updated grid
        return nextGen;
    }

    private int countLiveNeighbors(int row, int col, Grid grid) {
        int count = 0;
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for (int i = 0; i < 8; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (grid.isValidCell(newRow, newCol) && grid.getCellState(newRow, newCol)) {
                count++;
            }
        }

        return count;
    }

}
