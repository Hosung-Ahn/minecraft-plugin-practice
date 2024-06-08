package com.test.cannonstick;

import org.bukkit.ChatColor;

public enum Name {
    CANNON_STICK(ChatColor.RED.toString() + ChatColor.BOLD + "Cannon Stick");

    private final String name;

    Name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
