package com.playground.attribute;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HorseCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation();

            Horse horse = (Horse) location.getWorld().spawnEntity(location, EntityType.HORSE);
            horse.setAdult();
            horse.setTamed(true);
            horse.setOwner(player);
            horse.setJumpStrength(2);
            horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
            return true;
        }
        return false;
    }
}
