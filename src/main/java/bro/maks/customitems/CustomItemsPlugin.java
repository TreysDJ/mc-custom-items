package bro.maks.customitems;

import bro.maks.customitems.items.CustomItemsCreate;
import bro.maks.customitems.items.CustomItemsRegistry;
import bro.maks.customitems.listener.CustomItemsListener;
import bro.maks.customitems.util.ItemsUtil;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemsPlugin extends JavaPlugin {
    private NamespacedKey customItemKey;
    private CustomItemsCreate itemsCreate;
    private CustomItemsRegistry itemsRegistry;
    private ItemsUtil itemsUtil;

    @Override
    public void onEnable() {
        this.customItemKey = new NamespacedKey(this, "custom_item_id");
        this.itemsCreate = new CustomItemsCreate(customItemKey);
        this.itemsRegistry = new CustomItemsRegistry(this, itemsCreate);
        this.itemsUtil = new ItemsUtil(customItemKey);

        itemsRegistry.registerAll();

        getServer().getPluginManager().registerEvents(
                new CustomItemsListener(itemsUtil),
                this
        );
    }
}
