package tsp.smartaddon.listener;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import tsp.smartaddon.implementation.Weapon;

public class EntityDamageByEntityListener implements Listener {

    public EntityDamageByEntityListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player damager = (Player) e.getDamager();
            SlimefunItem main = SlimefunItem.getByItem(damager.getInventory().getItemInMainHand());
            SlimefunItem off = SlimefunItem.getByItem(damager.getInventory().getItemInOffHand());
            if (main instanceof Weapon) {
                ((Weapon) main).onHit(e);
            }
            if (off instanceof Weapon) {
                ((Weapon) off).onHit(e);
            }
        }
    }

}
