package bro.maks.customitems.items;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class CustomItemsCreate {
    private final NamespacedKey customItemKey;

    public CustomItemsCreate(NamespacedKey customItemKey) {
        this.customItemKey = customItemKey;
    }

    public ItemStack createItem(CustomItemsId id) {
        return switch (id) {
            case BladeOfBlood -> createVampireSword();
        };
    }

    private ItemStack createVampireSword() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();

        meta.displayName(Component.text("Клинок Алого ордена", NamedTextColor.DARK_RED));
        meta.setLore(List.of(
                "§7На обратной стороне всё ещё видны следы крови"
        ));

        meta.getPersistentDataContainer().set(
                customItemKey,
                PersistentDataType.STRING,
                CustomItemsId.BladeOfBlood.getId()
        );

        item.setItemMeta(meta);
        return item;
    }
}
