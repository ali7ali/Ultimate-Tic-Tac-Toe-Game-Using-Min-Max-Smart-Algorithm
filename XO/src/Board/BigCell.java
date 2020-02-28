package Board;

public class BigCell extends Cell {
    SubBoard subBoard;

    public BigCell() {
        subBoard=new SubBoard();
    }

    public State getState() {
        return subBoard.Winner();
    }
    public Cell clone()
    {
        BigCell bigCell=new BigCell();
        bigCell.subBoard=subBoard.clone();
        bigCell.setState(state);
        return bigCell;
    }

    public SubBoard getSubBoard() {
        return subBoard;
    }
}
