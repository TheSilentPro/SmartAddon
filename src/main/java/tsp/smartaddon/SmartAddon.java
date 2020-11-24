package tsp.smartaddon;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import tsp.smartaddon.listener.EntityDamageByEntityListener;
import tsp.smartaddon.listener.PlayerLeftClickListener;
import tsp.smartaddon.listener.SuitEquipListener;
import tsp.smartaddon.tasker.SuitTasker;
import tsp.smartaddon.tasker.WeaponTasker;
import tsp.smartaddon.util.Metrics;

/**
 * Represents a "Smart" {@link SlimefunAddon}
 *
 * @author TheSilentPro
 */
public class SmartAddon {

    private static SlimefunAddon instance;
    private static JavaPlugin plugin;

    public static void init(SlimefunAddon addon) {
        instance = addon;
        plugin = addon.getJavaPlugin();
        new Metrics(plugin, 9497);

        new EntityDamageByEntityListener(plugin);
        new PlayerLeftClickListener(plugin);
        new SuitEquipListener(plugin);

        Bukkit.getScheduler().runTaskTimer(plugin, new SuitTasker(), 0L, 1L);
        Bukkit.getScheduler().runTaskTimer(plugin, new WeaponTasker(), 0L, 1L);
    }

    public static SlimefunAddon getInstance() {
        return instance;
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }

}
