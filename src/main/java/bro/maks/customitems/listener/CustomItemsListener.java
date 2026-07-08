package bro.maks.customitems.listener;

import bro.maks.customitems.items.CustomItemsId;
import bro.maks.customitems.util.ItemsUtil;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;

import java.util.concurrent.ThreadLocalRandom;

public class CustomItemsListener implements Listener {
    private final ItemsUtil itemsUtil;
    private static final double HEAL_CHANCE = 0.2;
    private static final double HEAL_AMOUNT = 4.0;

    public CustomItemsListener(ItemsUtil itemsUtil) {
        this.itemsUtil = itemsUtil;
    }

    @EventHandler
    public void onVampireSwordHit(EntityDamageByEntityEvent event) {
        if (event.isCancelled()) {
            return;
        }

        if (!(event.getDamager() instanceof Player player)) {
            return;
        }

        if (!(event.getEntity() instanceof LivingEntity)) {
            return;
        }

        if (!event.isCritical()) {
            return;
        }

        ItemStack item = player.getInventory().getItemInMainHand();

        if (!itemsUtil.isCustom(item, CustomItemsId.BladeOfBlood)) {
            return;
        }

        double roll = ThreadLocalRandom.current().nextDouble();

        if (roll > HEAL_CHANCE) {
            return;
        }

        double newHealth = Math.min(
                player.getHealth() + HEAL_AMOUNT,
                player.getMaxHealth()
        );

        player.setHealth(newHealth);

        Location location = player.getLocation().add(0, 1.0, 0);

        Particle.DustOptions dustOptions = new Particle.DustOptions(
                Color.RED,
                1.5f
        );

        player.getWorld().spawnParticle(
                Particle.DUST,
                location,
                25,
                0.4,
                0.6,
                0.4,
                0.02,
                dustOptions
        );

        player.getWorld().spawnParticle(
                Particle.HEART,
                player.getLocation().add(0, 2.0, 0),
                2,
                0.3,
                0.3,
                0.3,
                0.01
        );

    }
}