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
        if (!isPlayer(sender)) return false;
        Player player = (Player) sender;

        if (!isInvalidUsage(args)) {
            player.sendMessage(ChatColor.RED + "Invalid usage! /message {player name} {message}");
            return false;
        }

        String playerName = args[0];
        String message = buildMessage(args);
        // 플레이어 이름과 정확히 일치하는 온라인 유저만 가져온다.
        Player target = Bukkit.getPlayerExact(playerName);

        if (player == null) {
            player.sendMessage(ChatColor.RED + "Player not found!");
            return false;
        }

        player.sendMessage(ChatColor.GRAY + "[me -> " + target.getName() + "] " + message);
        target.sendMessage(ChatColor.GRAY + "[" + player.getName() + " -> me] " + message);

        return true;
    }

    private boolean isPlayer(CommandSender sender) {
        return sender instanceof Player;
    }

    private boolean isInvalidUsage(String[] args) {
        return args.length >= 2;
    }

    private String buildMessage(String[] args) {
        StringBuilder message = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            message.append(args[i]).append(" ");
        }
        return message.toString();
    }
}
