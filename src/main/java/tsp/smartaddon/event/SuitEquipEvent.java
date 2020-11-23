package tsp.smartaddon.event;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SuitEquipEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final InventoryClickEvent inventoryClickEvent;
    private final HumanEntity humanEntity;
    private final ItemStack itemEquipped;
    private final ItemStack itemUnequipped;
    private Player player = null;

    public SuitEquipEvent(InventoryClickEvent inventoryClickEvent) {
        this.inventoryClickEvent = inventoryClickEvent;
        this.humanEntity = inventoryClickEvent.getWhoClicked();
        this.itemEquipped = inventoryClickEvent.getCursor();
        this.itemUnequipped = inventoryClickEvent.getCurrentItem();
        if (humanEntity instanceof Player) {
            this.player = (Player) inventoryClickEvent.getWhoClicked();
        }
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public InventoryClickEvent getInventoryClickEvent() {
        return inventoryClickEvent;
    }

    public ItemStack getItemEquipped() {
        return itemEquipped;
    }

    public ItemStack getItemUnequipped() {
        return itemUnequipped;
    }

    public HumanEntity getHumanEntity() {
        return humanEntity;
    }

    public Player getPlayer() {
        return player;
    }
}
