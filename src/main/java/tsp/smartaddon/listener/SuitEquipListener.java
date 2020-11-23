package tsp.smartaddon.listener;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import tsp.smartaddon.event.SuitEquipEvent;
import tsp.smartaddon.implementation.Suit;

/**
 * This listener class handles all suit wearing handlers
 *
 * @author TheSilentPro
 */
public class SuitEquipListener implements Listener {

    public SuitEquipListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onSuitEquip(InventoryClickEvent e) {
        SlimefunItem sfitem = SlimefunItem.getByItem(e.getCursor());
        SlimefunItem currentSlimefunItem = SlimefunItem.getByItem(e.getCurrentItem());
        if (e.getSlotType() == InventoryType.SlotType.ARMOR && isArmor(e.getCursor()) && sfitem instanceof Suit) {
            ((Suit) sfitem).onEquip(new SuitEquipEvent(e));
        }
        if (e.getSlotType() == InventoryType.SlotType.ARMOR && isArmor(e.getCurrentItem()) && currentSlimefunItem instanceof Suit) {
            ((Suit) currentSlimefunItem).onUnEquip(new SuitEquipEvent(e));
        }
    }

    private boolean isArmor(ItemStack itemStack) {
        if (itemStack == null)
            return false;
        final String typeNameString = itemStack.getType().name();
        return typeNameString.endsWith("_HELMET")
                || typeNameString.endsWith("_CHESTPLATE")
                || typeNameString.endsWith("_LEGGINGS")
                || typeNameString.endsWith("_BOOTS");
    }

}
