package com.playground;

import org.bukkit.plugin.java.JavaPlugin;

public final class PlayGround extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fruit").setExecutor(new FruitCommand());
        getCommand("fruit").setTabCompleter(new FruitTab());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
