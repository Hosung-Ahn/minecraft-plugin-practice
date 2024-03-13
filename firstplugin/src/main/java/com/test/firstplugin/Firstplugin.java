package com.test.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Firstplugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

//        getServer().getPluginManager().registerEvents(new Events(), this);
//        getServer().getPluginManager().registerEvents(this, this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("heal").setExecutor(new HealCommand());

        getCommand("config").setExecutor(new ConfigCommand(this));
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        event.setCancelled(true);
        event.getPlayer().sendMessage(ChatColor.RED + "You can't move!");
    }

    @EventHandler
    public void onPlayerEggThrow(PlayerEggThrowEvent event) {
        event.setHatching(false);
        event.getPlayer().sendMessage(ChatColor.RED + "You can't throw eggs!");
    }
} 
