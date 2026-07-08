package bro.maks.customitems;

import bro.maks.customitems.items.CustomItemsCreate;
import bro.maks.customitems.items.CustomItemsRegistry;
import bro.maks.customitems.listener.CustomItemsListener;
import bro.maks.customitems.util.ItemsUtil;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomItemsPlugin extends JavaPlugin {
    private NamespacedKey customItemsKey;
    private CustomItemsCreate itemsCreate;
    private CustomItemsRegistry itemsRegistry;
    private ItemsUtil itemsUtil;

    @Override
    public void onEnable() {
        this.customItemsKey = new NamespacedKey(this, "custom_items_id");
        this.itemsCreate = new CustomItemsCreate(customItemsKey);
        this.itemsRegistry = new CustomItemsRegistry(this, itemsCreate);
        this.itemsUtil = new ItemsUtil(customItemsKey);

        itemsRegistry.registerAll();

        getServer().getPluginManager().registerEvents(
                new CustomItemsListener(itemsUtil),
                this
        );
    }
}
