package com.test.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.io.File;

public class ServerIconEvent implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent event) {
        event.setMaxPlayers(1000);
        event.setMotd(ChatColor.AQUA + "Hello World!\n" + ChatColor.RED + "Welcome to the server!");
        try {
            event.setServerIcon(Bukkit.loadServerIcon(new File("server-icon.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
