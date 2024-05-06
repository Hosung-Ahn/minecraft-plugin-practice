package com.minecraftdev;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReplyCommand implements CommandExecutor {
    // /reply {message}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!isPlayer(sender)) return false;
        Player player = (Player) sender;

        if (!isInvalidUsage(args)) {
            player.sendMessage(ChatColor.RED + "Invalid usage! /message {player name} {message}");
            return false;
        }

        return false;
    }

    private boolean isPlayer(CommandSender sender) {
        return sender instanceof Player;
    }

    private boolean isInvalidUsage(String[] args) {
        return args.length >= 1;
    }

    private String buildMessage(String[] args) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            message.append(args[i]).append(" ");
        }
        return message.toString();
    }


}
