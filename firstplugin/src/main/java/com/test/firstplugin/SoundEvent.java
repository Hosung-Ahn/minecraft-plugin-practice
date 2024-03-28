package com.test.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class SoundEvent implements Listener {
    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        // 해당 플레이어에게만 소리가 들림
        event.getPlayer()
                .playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDER_DRAGON_AMBIENT, 1.0F, 1);
        // 월드에 속한 모두에게 소리가 들림
//        Bukkit.getWorld("world")
//                .playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDER_DRAGON_AMBIENT, 1.0F, 1);
    }
}
