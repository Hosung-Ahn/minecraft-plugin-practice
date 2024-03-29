package com.test.firstplugin;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class ProjectileEvent implements Listener {
//    @EventHandler
//    public void onLaunch(ProjectileLaunchEvent event) {
//        event.setCancelled(true);
//    }
//
//    @EventHandler
//    public void onHit(ProjectileHitEvent event) {
//        event.getEntity().getShooter();
//        event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 4);
//    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getHand().equals(EquipmentSlot.HAND) &&
                (event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) &&
                player.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_HOE)) {
            Snowball snowball = player.launchProjectile(Snowball.class);
            snowball.setVelocity(player.getLocation().getDirection().multiply(2));
        }
    }
}
