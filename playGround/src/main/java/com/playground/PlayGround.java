package com.playground;

import com.playground.attribute.BoostCommand;
import com.playground.attribute.HealthCommand;
import com.playground.attribute.HorseCommand;
import com.playground.commandTabComplete.FruitCommand;
import com.playground.commandTabComplete.FruitTab;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayGround extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("horse").setExecutor(new HorseCommand());
        getCommand("health").setExecutor(new HealthCommand());
        getCommand("boost").setExecutor(new BoostCommand());
//        getCommand("fruit").setExecutor(new FruitCommand());
//        getCommand("fruit").setTabCompleter(new FruitTab());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
