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

/**
 * Represents a "Smart" {@link SlimefunAddon}
 *
 * @author TheSilentPro
 */
public final class SmartAddon {

    private static final SmartAddon smartAddon = new SmartAddon();
    private SlimefunAddon instance;
    private JavaPlugin plugin;
    private SmartRegistry registry;

    private SmartAddon() {}

    public static void init(SlimefunAddon addon) {
        smartAddon.instance = addon;
        smartAddon.plugin = addon.getJavaPlugin();
        smartAddon.registry = new SmartRegistry();

        new EntityDamageByEntityListener(smartAddon.plugin);
        new PlayerLeftClickListener(smartAddon.plugin);
        new SuitEquipListener(smartAddon.plugin);
        new EntityDeathListener(smartAddon.plugin);

        Tasker.syncTimer(new SuitTasker(), 1L);
        Tasker.syncTimer(new WeaponTasker(), 1L);
    }

    public SlimefunAddon getInstance() {
        return instance;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public SmartRegistry getRegistry() {
        return registry;
    }

    public static SmartAddon getSmartAddon() {
        return smartAddon;
    }

}
