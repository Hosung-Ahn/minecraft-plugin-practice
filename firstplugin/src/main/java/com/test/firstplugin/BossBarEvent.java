package com.test.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BossBarEvent implements Listener {
    private BossBar bossBar = Bukkit.createBossBar("Hello", BarColor.RED, BarStyle.SOLID);

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        bossBar.addPlayer(event.getPlayer());
    }
}
