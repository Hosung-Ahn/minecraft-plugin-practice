package com.test.customfile;

import com.test.customfile.jsonUtil.Data;
import com.test.customfile.jsonUtil.JsonUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class CustomFile extends JavaPlugin {

    @Override
    public void onEnable() {

//        getCommand("config").setExecutor(new ConfigCommand(this));
//
//        File file = new File(getDataFolder(), "custom.yml");
//        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
//
//        yamlConfiguration.set("custom-key", "custom-value");
//        yamlConfiguration.set("custom-number", 42);
//        yamlConfiguration.set("custom-boolean", true);
//        yamlConfiguration.set("custom-list", new String[]{"a", "b", "c"});
//
//        try {
//            yamlConfiguration.save(file);
//        } catch (Exception e) {
//            System.out.println("An error occurred while saving the file");
//        }

        System.out.println(getDataFolder().getAbsolutePath());

        JsonUtil.write(new Data("John", 25), getDataFolder());
        Data data = JsonUtil.read(Data.class, getDataFolder());
        System.out.println(data);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
