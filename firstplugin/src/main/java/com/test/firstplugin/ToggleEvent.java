package com.test.firstplugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class ToggleEvent implements Listener {
    private boolean isToggled = false;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getHand().equals(EquipmentSlot.HAND) &&
                player.getInventory().getItemInMainHand().getType().equals(Material.NETHER_STAR)) {
            isToggled = !isToggled;
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        if (isToggled) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("채팅이 차단되었습니다.");
        }
    }
}
