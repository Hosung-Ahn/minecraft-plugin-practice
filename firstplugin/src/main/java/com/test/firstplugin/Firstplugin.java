package com.test.firstplugin;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Firstplugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SoundEvent(), this);
//        getServer().getPluginManager().registerEvents(new TitleEvent(), this);
//        getServer().getPluginManager().registerEvents(new Events(), this);
//        getServer().getPluginManager().registerEvents(this, this);

//        getConfig().options().copyDefaults();
//        saveDefaultConfig();
//
//        getCommand("heal").setExecutor(new HealCommand());
//
//        getCommand("config").setExecutor(new ConfigCommand(this));
//
//        Bukkit.getWorld("world").spawnEntity(Bukkit.getWorld("world").getSpawnLocation(), EntityType.CREEPER);
    }

//    @EventHandler
//    public void onPlayerMove(PlayerMoveEvent event) {
//        event.setCancelled(true);
//        event.getPlayer().sendMessage(ChatColor.RED + "You can't move!");
//    }
//
//    @EventHandler
//    public void onPlayerEggThrow(PlayerEggThrowEvent event) {
//        event.setHatching(false);
//        event.getPlayer().sendMessage(ChatColor.RED + "You can't throw eggs!");
//    }
//
//    @EventHandler
//    public void onEntitySpawn(CreeperPowerEvent event) {
//        ItemStack item = new ItemStack(Material.DIAMOND);
//        ItemMeta meta = item.getItemMeta();
//        meta.setDisplayName(ChatColor.RED + "Explosive Diamond");
//        item.setItemMeta(meta);
//
//        Bukkit.getWorld("world").getBlockAt(new Location(Bukkit.getWorld("world"), 0, 0, 0)).setType(Material.DIAMOND_BLOCK);
//
//        ItemStack book = new ItemStack(Material.BOOK);
//        BookMeta bookMeta = (BookMeta) book.getItemMeta();
//        bookMeta.setAuthor("Notch");
//        bookMeta.setTitle("The Book of Notch");
//        bookMeta.setPages("Page 1", "Page 2", "Page 3");
//        book.setItemMeta(bookMeta);
//    }
} 
