package com.test.firstplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PotionEffectEvent implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 2));
    }
}
