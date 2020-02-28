package Board;

import Main.Game;

import java.util.LinkedList;
import java.util.List;

public class SubBoard extends Board {
    public SubBoard() {
        super();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                cells[i][j]=new Cell();

            }
        }
    }
public void test(){
        cells[0][0].state=State.O;
    cells[0][1].state=State.X;
    cells[0][2].state=State.X;
    cells[1][1].state=State.O;
}
    public boolean MakeMove(State state, Coordinates coordinates) {
        if(CanMove(coordinates))
        {
            this.cells[coordinates.x][coordinates.y].state=state;
            return true;
        }
        return false;
    }

    public boolean CanMove(Coordinates coordinates) {
        if(this.cells[coordinates.x][coordinates.y].state==null)
            return true;
        return false;
    }

    @Override
    public SubBoard clone() {
        SubBoard subBoard=new SubBoard();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                subBoard.cells[i][j]=cells[i][j].clone();
            }
        }
        return subBoard;
    }

    public List<Coordinates> AvaliableMoves()
    {
        List<Coordinates> moves=new LinkedList<Coordinates>();
        for (int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(cells[i][j].state==null)
                {
                    moves.add(new Coordinates(i,j));
                }
            }
        }


        return moves;
    }

}
