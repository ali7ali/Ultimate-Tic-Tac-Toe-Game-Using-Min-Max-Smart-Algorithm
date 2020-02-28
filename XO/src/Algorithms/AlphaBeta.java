package Algorithms;

import Board.*;
import Main.Game;

public class AlphaBeta {
 public static Coordinates bestMove;
 int Depth;
    public AlphaBeta () {


    }
    private int AlphaBetaExec(State turn,MainBoard mainBoard,int alpha,int beta,int level)
    {
        if (level++ == Depth || mainBoard.GameOver()) {
            return Score(turn, mainBoard);
        }
        if (Game.getTurn().equals(turn))
        {

        }
        else{

        }
        return 0;
    }
    private  int getMax (State turn, MainBoard board, int alpha, int beta, int currentDepth) {
        Coordinates BestMove=null;
        //System.out.println("max" + currentDepth);
        for (Coordinates theMove : board.AvaliableMoves()) {

            MainBoard modifiedBoard = board.clone();
            modifiedBoard.MakeMove(theMove);
            int score = alphaBetaPruning(turn, modifiedBoard, alpha, beta, currentDepth);

            if (score > alpha) {
                alpha = score;
                BestMove = theMove;
            }

            // Pruning.
            if (alpha >= beta) {
                break;
            }

        }

        if (BestMove != null) {
            board.MakeMove(BestMove);
            this.bestMove = BestMove;
        }
        // System.out.println("alpha "+ alpha);
        return (int)alpha;
    }
    private  int getMin (State turn, MainBoard board, int alpha, int beta, int currentDepth) {
        Coordinates BestMove = null;
        // System.out.println("min" + currentDepth);
        for (Coordinates theMove : board.AvaliableMoves()) {

            MainBoard modifiedBoard = board.clone();
            modifiedBoard.MakeMove(theMove);

            int score = alphaBetaPruning(turn, modifiedBoard, alpha, beta, currentDepth);

            if (score < beta) {
                beta = score;
                BestMove = theMove;
            }

            // Pruning.
            if (alpha >= beta) {
                break;
            }
        }

        if (BestMove != null) {
            board.MakeMove(BestMove);
            this.bestMove = BestMove;
        }
        // System.out.println("beta "+beta);
        return (int)beta;
    }

    public static Coordinates Solve(Board board) {
        Coordinates coordinates=new Coordinates(0,0);




        return coordinates;
    }
    public void run (State turn, MainBoard board, int d) {
        if (d < 1) {
            throw new IllegalArgumentException("Maximum depth must be greater than 0.");
        }

        this.Depth = d;

        alphaBetaPruning(turn, board, -999, 999, 0);
    }
    private  int alphaBetaPruning (State turn, MainBoard board, int alpha, int beta, int currentDepth) {
        // System.out.println("depth" + currentDepth);
        if (currentDepth++ == Depth || board.GameOver()) {
            return Score(turn, board);
        }

        if (board.getTurn() == turn) {
            return getMax(turn, (MainBoard) board, alpha, beta, currentDepth); //comp i want to win
        } else {
            return getMin(turn, (MainBoard) board, alpha, beta, currentDepth);
        }
    }
  /*  private  int getMax (State turn, SubBoard board, double alpha, double beta, int currentDepth) {
        Coordinates BestMove=null;
        //System.out.println("max" + currentDepth);
        for (Coordinates theMove : board.AvaliableMoves()) {

                SubBoard modifiedBoard = board.clone();
                modifiedBoard.MakeMove(turn,theMove);
                int score = alphaBetaPruning(turn.equals(State.X)?State.O:State.X, modifiedBoard, alpha, beta, currentDepth);

                if (score > alpha) {
                    alpha = score;
                    BestMove = theMove;
                }

                // Pruning.
                if (alpha >= beta) {
                    break;
                }

            }

        if (BestMove != null) {
            board.MakeMove(turn,BestMove);
            this.bestMove = BestMove;
        }
        // System.out.println("alpha "+ alpha);
        return (int)alpha;
    }
    private  int getMin (State turn, SubBoard board, double alpha, double beta, int currentDepth) {
        Coordinates BestMove = null;
        // System.out.println("min" + currentDepth);
        for (Coordinates theMove : board.AvaliableMoves()) {

                SubBoard modifiedBoard = board.clone();
                modifiedBoard.MakeMove(turn,theMove);

                int score = alphaBetaPruning(turn.equals(State.X)?State.O:State.X, modifiedBoard, alpha, beta, currentDepth);

                if (score < beta) {
                    beta = score;
                    BestMove = theMove;
                }

                // Pruning.
                if (alpha >= beta) {
                    break;
                }
            }

        if (BestMove != null) {
            board.MakeMove(turn,BestMove);
            this.bestMove = BestMove;
        }
        // System.out.println("beta "+beta);
        return (int)beta;
    }*/
    public static int Score(State turn,Board board) {
        if(board.GameOver()&&board.Winner()==turn)
            return 10;
        else if(board.GameOver()&&board.Winner()!=turn)
            return -10;
        else
            return 0;
    }


}
