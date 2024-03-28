package com.test.firstplugin;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class FireworkEvent implements Listener {

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {

        Firework firework = event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), Firework.class);
        FireworkMeta fireworkMeta = firework.getFireworkMeta();
        fireworkMeta.setPower(2);
        fireworkMeta.addEffect(
                FireworkEffect.builder().flicker(true).trail(true)
                        .withColor(Color.RED)
                        .withFade(Color.BLUE)
                        .with(FireworkEffect.Type.BALL_LARGE).build()
        );
        firework.setFireworkMeta(fireworkMeta);


    }
}
