package com.minecraftdev;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ReMessageCommand implements CommandExecutor {
    // /remessage {message}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!isPlayer(sender)) return false;
        Player player = (Player) sender;

        if (invalidUsage(args)) {
            player.sendMessage(ChatColor.RED + "Invalid usage! /message {player name} {message}");
            return false;
        }
        String message = buildMessage(args);

        if (!existsRecentMessage(player)) {
            player.sendMessage(ChatColor.RED + "No recent message!");
            return false;
        }

        UUID uuid = RecentMessageFactory.getRecentMessage(player.getUniqueId());
        Player target = player.getServer().getPlayer(uuid);
        player.sendMessage(ChatColor.GRAY + "[me -> " + target.getName() + "] " + message);

        return false;
    }

    private boolean isPlayer(CommandSender sender) {
        return sender instanceof Player;
    }

    private boolean invalidUsage(String[] args) {
        return args.length < 1;
    }

    private boolean existsRecentMessage(Player player) {
        return RecentMessageFactory.existsRecentMessage(player.getUniqueId());
    }

    private String buildMessage(String[] args) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            message.append(args[i]).append(" ");
        }
        return message.toString();
    }


}
