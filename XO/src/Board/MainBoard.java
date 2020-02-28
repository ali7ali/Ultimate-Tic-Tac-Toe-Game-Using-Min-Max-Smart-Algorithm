package Board;

import sample.Main;
import Main.*;
import java.util.LinkedList;
import java.util.List;

public class MainBoard extends Board {
    Coordinates position;
    State turn;
    public MainBoard(Coordinates position) {
        super();
        turn=State.X;
        this.position=new Coordinates(position.getX(),position.getY());
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {

                cells[i][j]=new BigCell();
                if(i==0&&j==0)
                    ((BigCell)cells[i][j]).getSubBoard().test();
            }
        }
    }

    public void setPosition(Coordinates position) {
        this.position = position;
    }

    public Coordinates getPosition() {
        return position;
    }

    public State getTurn() {
        return turn;
    }

    public void setTurn(State turn) {
        this.turn = turn;
    }

    public boolean MakeMove(Coordinates coordinates) {
        boolean re=((BigCell)cells[position.getX()][position.getY()]).getSubBoard().MakeMove(turn,coordinates);
        position=new Coordinates(coordinates.getX(),coordinates.getY());
        runTurn();
        return re;
    }
    public void runTurn() {
        this.setTurn(this.getTurn().equals(State.O)?State.X:State.O);
    }

    @Override
    public MainBoard clone() {
        MainBoard mainBoard=new MainBoard(this.getPosition());
        mainBoard.setTurn(this.getTurn());
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                mainBoard.cells[i][j]=cells[i][j].clone();
            }
        }
        return mainBoard;    }
    public List<Coordinates> AvaliableMoves()
    {
        return ((BigCell)cells[position.getX()][position.getY()]).getSubBoard().AvaliableMoves();
    }
}
