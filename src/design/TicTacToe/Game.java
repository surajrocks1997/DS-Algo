package design.TicTacToe;

enum GameState {
    won,
    draw,
    playing
}

public class Game {
    Player p1;
    Player p2;

    Player currentPlayer;
    boolean isP1turn;
    Board board;
    GameState gameState;
    Player winner;

    public Game(Player p1, Player p2) {
        this.p1 = p1;
        p1.setIdentity('X');
        this.p2 = p2;
        p2.setIdentity('O');

        this.currentPlayer = p1;
        this.isP1turn = true;
        this.board = new Board();
        this.gameState = GameState.playing;
    }

    public Player getCurrentPlayer() {
        return isP1turn ? p1 : p2;
    }

    public void move(int row, int col, Player p) {
        board.move(row, col, p);
        if (board.isFull()) {
            gameState = GameState.draw;
        }
        if (board.checkIfWon(row, col, p)) {
            gameState = GameState.won;
            winner = p;
        }
        isP1turn = !isP1turn;
    }


    public void printCurrentState() {
        board.printCurrentState();
    }

    public void resetMove(int row, int col) {
        board.resetMove(row, col);
        isP1turn = !isP1turn;
    }
}
