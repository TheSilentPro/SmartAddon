package tsp.smartaddon.util;

import me.mrCookieSlime.Slimefun.cscorelib2.data.PersistentDataAPI;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import tsp.smartaddon.SmartAddon;

/**
 * Some Item Utilities for {@link tsp.smartaddon.implementation.SmartItem}'s
 *
 * @author TheSilentPro
 * @author WalshyDev
 */
public class SmartItemUtils {

    private static final NamespacedKey cooldown = new NamespacedKey(SmartAddon.getPlugin(), "cooldown");

    /**
     * Add cooldown to an item
     *
     * @param item The item to add a cooldown to
     * @param time The cooldown time
     */
    public static void addCooldown(ItemStack item, int time) {
        if (time > -1) {
            ItemMeta meta = item.getItemMeta();
            PersistentDataAPI.setLong(meta, cooldown, System.currentTimeMillis());
            item.setItemMeta(meta);
        }
    }

    /**
     * Get the cooldown time left on an item
     *
     * @param item The item to check
     * @param time The cooldown time
     * @return Time left. Returns -1 if there is no cooldown
     */
    public static long getTimeLeft(ItemStack item, int time) {
        ItemMeta meta = item.getItemMeta();
        long l = PersistentDataAPI.getLong(meta, cooldown, -1);
        return ((l + time * 1000) - System.currentTimeMillis()) / 1000;
    }

}
