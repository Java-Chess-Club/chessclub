package com.revature.players;

public class HumanPlayer extends Player {
    
    private String username;
    
    public HumanPlayer(boolean whiteSide, String username) {
        this.whiteSide = whiteSide;
        this.humanPlayer = true;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "HumanPlayer [username=" + username + "]";
    }
    
}
