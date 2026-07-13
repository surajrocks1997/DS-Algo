package design.TicTacToe;

public class Player {
    String name;
    char identity;

    public Player(String name) {
        this.name = name;
    }

    public void setIdentity(char identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }
}
