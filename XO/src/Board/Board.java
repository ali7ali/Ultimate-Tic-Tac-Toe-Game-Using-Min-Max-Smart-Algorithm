package Board;

public abstract class Board {
    Cell [][] cells;

    public Board() {
        this.cells = new Cell[3][3];
    }

    public boolean GameOver(){
        if(Winner()!=null)
            return true;
        return false;
    }
    public State Winner(){
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(cells[i][j].getState()==null)
                    break;
                else if(j!=0&&cells[i][j].getState()!=cells[i][j-1].getState())
                    break;
                else if(j==2)
                    return cells[i][j].getState();
            }
        }
        for(int j=0;j<3;j++)
        {
            for(int i=0;i<3;i++)
            {
                if(cells[i][j].getState()==null)
                    break;
                else if(i!=0&&cells[i][j].getState()!=cells[i-1][j].getState())
                    break;
                else if(i==2)
                    return cells[i][j].getState();
            }
        }
        for(int i=1;i<3;i++)
        {
            if(cells[i][i].getState()==null)
                break;
            else if(i!=0&&cells[i][i].getState()!=cells[i-1][i-1].getState())
                break;
            else if(i==2)
                return cells[i][i].getState();
        }
        for(int i=1;i<3;i++)
        {
            if(cells[2-i][i].getState()==null)
                break;
            else if(i!=0&&cells[2-i][i].getState()!=cells[3-i][i-1].getState())
                break;
            else if(i==2)
                return cells[2-i][i].getState();
        }
        return null;
    }
    public abstract Board clone();

    public Cell[][] getCells() {
        return cells;
    }
}
