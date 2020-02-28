package Board;

public class Cell {
    State state;

    public Cell(State state) {
        this.state = state;
    }
    public Cell() {
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public Cell clone()
    {
        return new Cell(state);
    }
}
