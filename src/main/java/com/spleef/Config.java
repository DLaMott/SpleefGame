package com.spleef;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    private final FileConfiguration config;

    public Config(SpleefPlugin plugin) {
        this.config = plugin.getConfig();
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }

    public Location readLocation(String configKey) {
        String line = config.getString(configKey);
        String[] parts = line.split(" ");

        String worldName = parts[0];
        String x = parts[1], y = parts[2], z = parts[3];

        int xPos = parseInt(x), yPos = parseInt(y), zPos = parseInt(z);
        World world = Bukkit.getWorld(worldName);
        return new Location(world, xPos, yPos, zPos);
    }

    private static int parseInt(String i) {
        try {
            return Integer.parseInt(i);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
