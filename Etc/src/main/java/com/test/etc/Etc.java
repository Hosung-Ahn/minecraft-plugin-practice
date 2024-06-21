package com.test.etc;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public final class Etc extends JavaPlugin {

    @Override
    public void onEnable() {
        // persistence data container
        NamespacedKey key = new NamespacedKey(this, "name");

        Player player = Bukkit.getPlayer("player");
        player.getPersistentDataContainer().set(key, PersistentDataType.STRING, "value");

        // key 에 해당하는 value 가 없다면 null 을 반환하므로 null 체크를 해야 한다.
        if (player.getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            String value = player.getPersistentDataContainer().get(key, PersistentDataType.STRING);
        }

        Block block = Bukkit.getWorld("world").getBlockAt(0, 0, 0);
        Sign
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
