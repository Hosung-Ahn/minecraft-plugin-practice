package com.playground.attribute;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class BoostCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
            if (itemInMainHand != null &&
                    !itemInMainHand.getType().isAir()) {
                AttributeModifier attributeModifier = new AttributeModifier("generic.attack_damage", 100, AttributeModifier.Operation.ADD_NUMBER);
//                new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", 100, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
                ItemMeta itemMeta = itemInMainHand.getItemMeta();
                itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier);
                itemInMainHand.setItemMeta(itemMeta);
                return true;
            }
        }
        return false;
    }
}
