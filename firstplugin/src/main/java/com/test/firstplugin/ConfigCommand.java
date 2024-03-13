package com.test.firstplugin;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

@RequiredArgsConstructor
public class ConfigCommand implements CommandExecutor {
    private final Firstplugin plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            plugin.getConfig().set("Number", 10);
            List<String> stringList = plugin.getConfig().getStringList("String-list");
            stringList.add("This is a new line");
            plugin.getConfig().set("String-list", stringList);

            plugin.saveConfig();

            player.sendMessage(plugin.getConfig().getString("Word"));
            player.sendMessage(String.valueOf(plugin.getConfig().getInt("Number")));
            player.sendMessage(String.valueOf(plugin.getConfig().getBoolean("Enabled")));

            for (String message : plugin.getConfig().getStringList("String-list")) {
                player.sendMessage(message);
            }
        }
        return false;
    }
}
