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

    private static final NamespacedKey cooldown = new NamespacedKey(SmartAddon.getSmartAddon().getPlugin(), "cooldown");
    private static final NamespacedKey lastused = new NamespacedKey(SmartAddon.getSmartAddon().getPlugin(), "lastused");

    /**
     * Add cooldown to an item
     *
     * @param item The item to add a cooldown to
     * @param time The cooldown time
     */
    public static void addCooldown(ItemStack item, int time) {
        if (time > -1) {
            ItemMeta meta = item.getItemMeta();
            PersistentDataAPI.setLong(meta, cooldown, time);
            PersistentDataAPI.setLong(meta, lastused, System.currentTimeMillis());
            item.setItemMeta(meta);
        }
    }

    /**
     * Get the cooldown time left on an item
     *
     * @param item The item to check
     * @return Time left. Returns -1 if there is no cooldown
     */
    public static long getTimeLeft(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        long l = PersistentDataAPI.getLong(meta, lastused, -1);
        long time = PersistentDataAPI.getLong(meta, cooldown, -1);
        if (l < 1 || time < 1) {
            return -1;
        }

        return ((l + time * 1000) - System.currentTimeMillis()) / 1000;
    }

}
