package com.test.firstplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.setHealth(20);
            player.sendMessage("You have been healed!");
            return true;
        } else {
            sender.sendMessage("You must be a player to use this command!");
            return false;
        }
    }
}
