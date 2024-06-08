package com.test.customcraftingrecipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class CustomCraftingRecipes extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "custom_diamond_sword"), diamondSword);
        recipe.shape(
                " D ",
                " D ",
                " D ");
        recipe.setIngredient('D', Material.DIAMOND);;

        Bukkit.addRecipe(recipe);

        ItemStack barrier = new ItemStack(Material.BARRIER);
        ShapedRecipe barrierRecipe = new ShapedRecipe(new NamespacedKey(this, "barrier"), barrier);
        barrierRecipe.shape(
                "R R",
                " R ",
                "R R");
        barrierRecipe.setIngredient('R', Material.RED_WOOL);;

        Bukkit.addRecipe(barrierRecipe);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
