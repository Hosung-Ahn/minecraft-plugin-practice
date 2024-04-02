package com.test.firstplugin;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

public class BannerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            ItemStack item = new ItemStack(Material.WHITE_BANNER);
            BannerMeta meta = (BannerMeta) item.getItemMeta();
            meta.addPattern(new Pattern(DyeColor.RED, PatternType.STRIPE_TOP));
            meta.addPattern(new Pattern(DyeColor.ORANGE, PatternType.STRIPE_CENTER));

            item.setItemMeta(meta);
            Player player = (Player) sender;
            player.getInventory().addItem(item);
            return true;
        }
        return false;
    }
}
