package com.example.chess.model.db;
import java.util.ArrayList;

public class Player {
    int id;
    String name;
    String email;
    int numberOfGames = 0;
    int numberOfWins = 0;
    int numberOfDraws = 0;
    int getNumberOfDefeats = 0;
    ArrayList<Game> lastGames = new ArrayList<Game>();
    int rating;

    Player(int id, String name, String email, int rating){
        this.id = id;
        this.name = name;
        this.email = email;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public int getGetNumberOfDefeats() {
        return getNumberOfDefeats;
    }

    public ArrayList<Game> getLastGames() {
        return lastGames;
    }

    public int getRating() {
        return rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws = numberOfDraws;
    }

    public void setGetNumberOfDefeats(int getNumberOfDefeats) {
        this.getNumberOfDefeats = getNumberOfDefeats;
    }

    public void setLastGames(ArrayList<Game> lastGames) {
        this.lastGames = lastGames;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
