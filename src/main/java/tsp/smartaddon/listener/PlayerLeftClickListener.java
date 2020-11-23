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
 * This listener class handles the {@link PlayerLeftClickEvent}
 *
 * @author TheSilentPro
 */
public class PlayerLeftClickListener implements Listener {

    public PlayerLeftClickListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerLeftClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            SlimefunItem sfitem = SlimefunItem.getByItem(e.getItem());
            if (sfitem instanceof SmartItem) {
                ((SmartItem) sfitem).onLeftClick(new PlayerLeftClickEvent(e));
            }
        }
    }

}
