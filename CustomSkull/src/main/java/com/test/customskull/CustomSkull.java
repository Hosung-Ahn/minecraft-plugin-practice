package com.test.customskull;

import org.bukkit.plugin.java.JavaPlugin;

public final class CustomSkull extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("skull").setExecutor(new SkullCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
