package com.spigotadvance.gui;

import com.spigotadvance.ItemStackBuilder;
import com.spigotadvance.Validator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!Validator.isPlayer(sender)) {
            return false;
        }

        System.out.println("MenuCommand");
        Player player = (Player) sender;
        Inventory inventory = Bukkit.createInventory(player, 45, ChatColor.RED + "Menu" + ChatColor.BOLD);

        // TELEPORT
        ItemStack teleport = new ItemStackBuilder(Material.COMPASS)
                .displayName(ChatColor.BLUE + "Teleport")
                .lore(List.of(ChatColor.GRAY + "Teleport to a location"))
                .build();
        inventory.setItem(20, teleport);

        // KILL YOURSELF
        ItemStack kys = new ItemStackBuilder(Material.DIAMOND_SWORD)
                .displayName(ChatColor.RED + "Kill Yourself")
                .lore(List.of(ChatColor.GRAY + "Kills you"))
                .build();
        inventory.setItem(22, kys);

        ItemStack clear = new ItemStackBuilder(Material.BUCKET)
                .displayName(ChatColor.GOLD + "Clear Inventory")
                .lore(List.of(ChatColor.GRAY + "Clears your inventory."))
                .build();
        inventory.setItem(24, clear);

        //FRAME
        ItemStack frame = new ItemStackBuilder(Material.LIME_STAINED_GLASS_PANE)
                .build();

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 9; c++) {
                if (r == 0 || r == 4 || c == 0 || c == 8) {
                    inventory.setItem(r*9 + c, frame);
                }
            }
        }

        // CLOSE BUTTON
        ItemStack close = new ItemStackBuilder(Material.BARRIER)
                .displayName(ChatColor.RED + "Close!")
                .build();
        inventory.setItem(0, close);

        player.openInventory(inventory);

        return true;
    }
}
