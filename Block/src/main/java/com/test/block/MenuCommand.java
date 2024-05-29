package com.test.block;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!Validator.isPlayer(sender)) {
            return false;
        }

        System.out.println("MenuCommand");
        Player player = (Player) sender;
        Inventory inventory = Bukkit.createInventory(player, 45, ChatColor.RED.toString() + ChatColor.BOLD + "Menu");



        // KILL YOURSELF
        ItemStack start = new ItemCreator(Material.DIAMOND_SWORD)
                .displayName(ChatColor.GREEN + "START")
                .lore(List.of(ChatColor.GRAY + "start game"))
                .build();
        inventory.setItem(22, start);

        //FRAME
        ItemStack frame = new ItemCreator(Material.LIME_STAINED_GLASS_PANE)
                .build();

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 9; c++) {
                if (r == 0 || r == 4 || c == 0 || c == 8) {
                    inventory.setItem(r*9 + c, frame);
                }
            }
        }

        // CLOSE BUTTON
        ItemStack close = new ItemCreator(Material.BARRIER)
                .displayName(ChatColor.RED + "Close!")
                .build();
        inventory.setItem(0, close);

        player.openInventory(inventory);

        return true;
    }
}
