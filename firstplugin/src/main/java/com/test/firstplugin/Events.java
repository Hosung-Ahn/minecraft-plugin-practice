package com.test.firstplugin;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Events implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        ItemStack item = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setColor(org.bukkit.Color.RED);
        item.setItemMeta(meta);

        event.getPlayer().getInventory().setHelmet(item);
    }

}
