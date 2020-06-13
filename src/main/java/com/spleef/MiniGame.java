package com.spleef;

public class MiniGame {

    private final SpleefPlugin plugin;
    private final Arena arena;
    private GameState gameState = GameState.LOADING;

    public MiniGame(SpleefPlugin plugin,Arena arena){
        this.arena = arena;
        this.plugin = plugin;
    }
    public void load(){
        arena.load();
        gameState = GameState.WAITING;

    }

    public boolean isLoading() {
        return gameState == GameState.LOADING;
    }

    public boolean isWaiting() {
        return gameState == GameState.WAITING;
    }

    public boolean isRunning() {
        return gameState == GameState.RUNNING;
    }

    public boolean isFinished() {
        return gameState == GameState.FINISHED;
    }

    private enum GameState {
        // the game is loading (map data, etc.)
        LOADING,
        // the game is ready for players to join (this can be via command, clicking an NPC, etc.)
        WAITING,
        // the game has started (maybe max players joined, maybe a timer ran out)
        RUNNING,
        // the game has finished and is resetting
        FINISHED;
    }

}
