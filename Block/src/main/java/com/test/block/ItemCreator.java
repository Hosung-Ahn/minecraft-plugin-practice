package com.test.block;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemCreator {
    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemCreator(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemCreator displayName(String name) {
        this.itemMeta.setDisplayName(name);
        return this;
    }

    public ItemCreator lore(List<String> lore) {
        this.itemMeta.setLore(lore);
        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
