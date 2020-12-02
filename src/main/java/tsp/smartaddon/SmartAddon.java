package tsp.smartaddon;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.plugin.java.JavaPlugin;
import tsp.smartaddon.listener.EntityDamageByEntityListener;
import tsp.smartaddon.listener.EntityDeathListener;
import tsp.smartaddon.listener.PlayerLeftClickListener;
import tsp.smartaddon.listener.SuitEquipListener;
import tsp.smartaddon.tasker.Tasker;
import tsp.smartaddon.tasker.task.SuitTasker;
import tsp.smartaddon.tasker.task.WeaponTasker;
import tsp.smartaddon.util.Metrics;

/**
 * Represents a "Smart" {@link SlimefunAddon}
 *
 * @author TheSilentPro
 */
public class SmartAddon {

    private static SlimefunAddon instance;
    private static JavaPlugin plugin;
    private static SmartRegistry registry;

    public static void init(SlimefunAddon addon) {
        instance = addon;
        plugin = addon.getJavaPlugin();
        registry = new SmartRegistry();
        new Metrics(plugin, 9497);

        new EntityDamageByEntityListener(plugin);
        new PlayerLeftClickListener(plugin);
        new SuitEquipListener(plugin);
        new EntityDeathListener(plugin);

        Tasker.syncTimer(new SuitTasker(), 1L);
        Tasker.syncTimer(new WeaponTasker(), 1L);
    }

    public static SlimefunAddon getInstance() {
        return instance;
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static SmartRegistry getRegistry() {
        return registry;
    }
}
