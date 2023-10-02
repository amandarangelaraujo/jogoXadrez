package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        //nao faz sentido criar um tabuleiro com menos de - colunas e linhas
        if(rows<1 || columns < 1){
            throw new BoardExceptioin("ERRO CRIANDO TABULEIRO: É necessário que tenha pelo menos 1 linha e uma coluna");
        }
            this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRow() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int column){
        if(!positionExists(row,column)){
            throw new BoardExceptioin("ERRO: não existe essa posição no tabuleiro");
        }
        return pieces[row][column];
    }

    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardExceptioin("ERRO: não existe essa posição no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){

            throw new BoardExceptioin("ERRO: já existe uma peça nessa posição ->" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionExists(int row, int column){
        return row >=0 && row < rows && column >=0 && column<columns;
        
    }
    
    public boolean positionExists(Position position){
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardExceptioin("ERRO: não existe essa posição no tabuleiro");
        }
        return piece(position) != null;
    }

    
}
