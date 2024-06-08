package com.test.cannonstick;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class CannonStick extends JavaPlugin {

    @Override
    public void onEnable() {
        // cannon stick recipe
        ItemStack cannonStick = new ItemStackBuilder(Material.STICK)
                .displayName(Name.CANNON_STICK.getName())
                .lore(List.of("Right click to shoot a fireball!"))
                .build();

        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "cannon_stick"), cannonStick);
        recipe.shape(
                "DDD",
                "DSD",
                "DDD");
        recipe.setIngredient('D', Material.DIAMOND);
        recipe.setIngredient('S', Material.STICK);

        getServer().addRecipe(recipe);

        // listener registration
        getServer().getPluginManager().registerEvents(new CannonShotListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
