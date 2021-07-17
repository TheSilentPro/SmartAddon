package tsp.smartaddon.listener;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import tsp.smartaddon.event.PlayerLeftClickEvent;
import tsp.smartaddon.implementation.SmartItem;

/**
 * This listener class handles all {@link SmartItem} interaction handlers
 *
 * @author TheSilentPro
 */
public class PlayerInteractListener implements Listener {

    public PlayerInteractListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        SlimefunItem sfitem = SlimefunItem.getByItem(e.getItem());
        if (sfitem instanceof SmartItem) {
            // Fire interact listeners
            ((SmartItem) sfitem).onInteract(e);

            // Fire left click listeners
            if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
                ((SmartItem) sfitem).onLeftClick(new PlayerLeftClickEvent(e));
            }
        }
    }

}
