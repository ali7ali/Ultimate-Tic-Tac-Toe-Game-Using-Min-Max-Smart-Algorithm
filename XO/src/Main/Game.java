package Main;

import Algorithms.*;
import Board.BigCell;
import Board.Coordinates;
import Board.MainBoard;
import Board.State;

import java.util.Scanner;

public class Game {
   static MainBoard mainBoard;
    public Game() {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter x,y");
        int x = scanner.nextInt();
        int y=scanner.nextInt();
        this.mainBoard = new MainBoard(new Coordinates(x,y));
        print();
        while(!mainBoard.GameOver())
        {
            if(mainBoard.getTurn().equals(State.O))
            {
                AlphaBeta alphaBeta=new AlphaBeta();
                alphaBeta.run(getTurn(), mainBoard,10);
                mainBoard.MakeMove(AlphaBeta.bestMove);
                System.out.println(mainBoard.getPosition().getX()+"\\"+mainBoard.getPosition().getY());
                print();
                System.out.println("____________________________________");

            }
            else
            {x = scanner.nextInt();
             y=scanner.nextInt();
            mainBoard.setPosition(new Coordinates(x,y));
            mainBoard.MakeMove(mainBoard.getPosition());
                System.out.println(mainBoard.getPosition().getX()+"\\"+mainBoard.getPosition().getY());
                print();
                System.out.println("____________________________________");

            }
            System.out.println(mainBoard.getPosition().getX()+"\\"+mainBoard.getPosition().getY());
            print();
            System.out.println("____________________________________");
        }
    }

    public void print(){
        for (int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(((BigCell)mainBoard.getCells()[mainBoard.getPosition().getX()][mainBoard.getPosition().getY()]).getSubBoard().getCells()[i][j].getState()+"\t");
            }
            System.out.println();
        }
    }
    public static State getTurn() {
        return mainBoard.getTurn();
    }
}
