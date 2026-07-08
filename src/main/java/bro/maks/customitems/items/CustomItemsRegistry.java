package bro.maks.customitems.items;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemsRegistry {
    private final JavaPlugin plugin;
    private final CustomItemsCreate itemsCreate;

    public CustomItemsRegistry(JavaPlugin plugin, CustomItemsCreate itemsCreate) {
        this.plugin = plugin;
        this.itemsCreate = itemsCreate;
    }

    public void registerAll() {
        registerRecipe();
    }

    private void registerRecipe() {
        NamespacedKey key = new NamespacedKey(plugin, "клинок_алого_ордена");

        ShapedRecipe recipe = new ShapedRecipe(key, itemsCreate.createItem(CustomItemsId.BladeOfBlood));

        recipe.shape(
                "A B",
                " C ",
                "D E"
        );

        recipe.setIngredient('A', Material.REDSTONE);
        recipe.setIngredient('B', Material.NETHER_STAR);
        recipe.setIngredient('C', Material.NETHERITE_SWORD);
        recipe.setIngredient('D', Material.ENCHANTED_GOLDEN_APPLE);
        recipe.setIngredient('E', Material.WITHER_SKELETON_SKULL);

        Bukkit.addRecipe(recipe);
    }
}

