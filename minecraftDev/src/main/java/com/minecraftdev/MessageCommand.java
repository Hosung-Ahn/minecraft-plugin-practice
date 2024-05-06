package com.minecraftdev;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {
    // /message {player name} {message}
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 2) {

            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage! /message {player name} {message}");
            }
        }
        return false;
    }
}
