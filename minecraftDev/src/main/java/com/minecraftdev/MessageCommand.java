package com.minecraftdev;

import org.bukkit.Bukkit;
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

            if (args.length >= 2) {
                String playerName = args[0];
                String message = buildMessage(args);
                Player target = Bukkit.getPlayerExact(playerName);

                if (target != null) {
                    player.sendMessage(ChatColor.GRAY + "[me -> " + target.getName() + "] " + message);
                    target.sendMessage(ChatColor.GRAY + "[" + player.getName() + " -> me] " + message);
                } else {
                    player.sendMessage(ChatColor.RED + "Player not found!");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage! /message {player name} {message}");
            }
        }
        return false;
    }

    private String buildMessage(String[] args) {
        StringBuilder message = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            message.append(args[i]).append(" ");
        }
        return message.toString();
    }
}
