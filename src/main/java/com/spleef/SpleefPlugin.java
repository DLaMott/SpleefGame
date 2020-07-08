package com.spleef;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class SpleefPlugin extends JavaPlugin {

    private MiniGame miniGame;
    private Config config;

    @Override
    public void onEnable() {
        this.config = new Config(this);
        Location a = config.readLocation("cornerA");
        Location b = config.readLocation("cornerB");
        this.miniGame = new MiniGame(this, new Arena(this, a, b));//fuck
        this.miniGame.load();


    }

    @Override
    public void onDisable() {


    }

}
