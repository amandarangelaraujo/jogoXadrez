package chess;

import boardgame.Board;

//classe que recebe as regras do jogo de xadrez.
public class ChessMatch {
    private Board board;
    
    public ChessMatch(){
        board = new Board(8, 8);
    }

    //esse método tem que retornar as peças da partida
    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRow()][board.getColumns()];
        for(int i=0; i<board.getRow(); i++){
            for(int j=0; j<board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }
}
