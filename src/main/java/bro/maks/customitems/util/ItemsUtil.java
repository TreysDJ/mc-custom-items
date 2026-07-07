package bro.maks.customitems.util;

import org.bukkit.inventory.ItemStack;
import bro.maks.customitems.items.CustomItemsId;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class ItemsUtil {
    private final NamespacedKey customItemKey;

    public ItemsUtil(NamespacedKey customItemKey) {
        this.customItemKey = customItemKey;
    }

    public boolean isCustom(ItemStack item, CustomItemsId id) {
        if (item == null) {
            return false;
        }

        if (item.getType() == Material.AIR) {
            return false;
        }

        ItemMeta meta = item.getItemMeta();

        if (meta == null) {
            return false;
        }

        String metaId = meta.getPersistentDataContainer().get(
                customItemKey,
                PersistentDataType.STRING
        );

        if (metaId == null) {
            return false;
        }

        return metaId.equals(id.getId());
    }
}
