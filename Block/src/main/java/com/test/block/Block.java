package com.test.block;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Block extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("menu").setExecutor(new MenuCommand());
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
