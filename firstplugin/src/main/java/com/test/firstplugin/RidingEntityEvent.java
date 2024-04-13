package com.test.firstplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class RidingEntityEvent implements Listener {
    @EventHandler
    public void onRidingEntityEvent(PlayerInteractEntityEvent event) {

        // sneak 이면 내가 탑승하고 아니면 상대방이 탑승한다.
        if (event.getPlayer().isSneaking()) {
            event.getRightClicked().addPassenger(event.getPlayer());
        } else {
            event.getPlayer().addPassenger(event.getRightClicked());
        }

        // 탑승자를 리턴한다.
//        event.getRightClicked().getVehicle();

        // 탑승자를 제거한다.
//        event.getRightClicked().eject();
    }
}
