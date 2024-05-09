package com.spigotadvance.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Random;

public class MenuListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (ChatColor.translateAlternateColorCodes('&', event.getView().getTitle())
                .equals(ChatColor.RED.toString() + ChatColor.BOLD + "Menu")
            && event.getCurrentItem() != null){
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            switch (event.getRawSlot()) {
                case 0 :
                    break;
                case 20: // random tp
                    Random random = new Random();
                    Location location = player.getLocation();
                    location.setX(location.getX() + random.nextInt(100) - 50);
                    location.setZ(location.getZ() + random.nextInt(100) - 50);
                    player.teleport(location);
                    player.sendMessage(ChatColor.GREEN + "You have been teleported to a random location!");
                    break;
                case 22: // kys
                    player.setHealth(0);
                    player.sendMessage(ChatColor.RED + "You have killed yourself!");
                    break;
                case 24: // clear inventory
                    player.closeInventory();
                    player.getInventory().clear();
                    break;
                default :
                    return;
            }
            player.closeInventory();
        }
    }
}
