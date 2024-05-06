package com.minecraftdev;

import org.bukkit.plugin.java.JavaPlugin;

public final class MinecraftDev extends JavaPlugin {

    // /message {player name} {message}
    // /reply {message}

    @Override
    public void onEnable() {
        getCommand("message").setExecutor(new MessageCommand());
        getCommand("reply").setExecutor(new ReplyCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
