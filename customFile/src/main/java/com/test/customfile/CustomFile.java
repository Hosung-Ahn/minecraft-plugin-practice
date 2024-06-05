package com.test.customfile;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class CustomFile extends JavaPlugin {

    @Override
    public void onEnable() {

        getCommand("config").setExecutor(new ConfigCommand(this));

        File file = new File(getDataFolder(), "custom.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

        yamlConfiguration.set("custom-key", "custom-value");
        yamlConfiguration.set("custom-number", 42);
        yamlConfiguration.set("custom-boolean", true);
        yamlConfiguration.set("custom-list", new String[]{"a", "b", "c"});

        try {
            yamlConfiguration.save(file);
        } catch (Exception e) {
            System.out.println("An error occurred while saving the file");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
