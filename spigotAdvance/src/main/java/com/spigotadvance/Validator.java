package com.spigotadvance;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Validator {
    private Validator() {
    }

    public static boolean isPlayer(CommandSender sender) {
        return sender instanceof Player;
    }
}
