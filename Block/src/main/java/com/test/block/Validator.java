package com.test.block;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Validator {
    public static boolean isPlayer(CommandSender sender) {
        if (!(sender instanceof Player)) {
            return false;
        }
        return true;
    }
}
