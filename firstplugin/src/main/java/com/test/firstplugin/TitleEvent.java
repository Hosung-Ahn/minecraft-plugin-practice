package com.test.firstplugin;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TitleEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendTitle("Welcome to the server!", "Enjoy your stay!", 20, 40, 20);

        event.getPlayer().spigot()
                .sendMessage(
                        ChatMessageType.ACTION_BAR,
                        new TextComponent(ChatColor.RED + "Welcome to the server!")
                );

        event.getPlayer().setPlayerListHeaderFooter(
                ChatColor.RED + "This is header",
                ChatColor.BLUE + "This is footer");
    }
}
