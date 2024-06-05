package com.test.customfile;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;


public class ConfigCommand implements CommandExecutor {
    private final CustomFile plugin;

    public ConfigCommand(CustomFile plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String key = args[0];
        File file = new File(plugin.getDataFolder(), "custom.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

        sender.sendMessage(key + ": " + yamlConfiguration.get(key));
        return true;
    }
}
