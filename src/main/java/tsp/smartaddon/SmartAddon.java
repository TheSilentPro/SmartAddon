package tsp.smartaddon;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tsp.smartaddon.listener.EntityDamageByEntityListener;
import tsp.smartaddon.listener.EntityDeathListener;
import tsp.smartaddon.listener.PlayerInteractListener;
import tsp.smartaddon.listener.SuitEquipListener;
import tsp.smartaddon.tasker.Tasker;
import tsp.smartaddon.tasker.task.SuitTasker;
import tsp.smartaddon.tasker.task.WeaponTasker;

/**
 * Represents a "Smart" {@link SlimefunAddon}
 *
 * @author TheSilentPro
 */
public class SmartAddon implements SlimefunAddon {

    private static SmartAddon smartAddon;
    private JavaPlugin plugin;
    private SmartRegistry registry;
    private Tasker tasker;

    public void init(JavaPlugin plugin) {
        smartAddon = this;
        onInit();

        this.plugin = plugin;
        registry = new SmartRegistry();
        tasker = new Tasker(plugin);
        tasker.syncTimer(new SuitTasker(), 1L);
        tasker.syncTimer(new WeaponTasker(), 1L);

        new EntityDamageByEntityListener(plugin);
        new PlayerInteractListener(plugin);
        new SuitEquipListener(plugin);
        new EntityDeathListener(plugin);
    }

    public void onInit() {}

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public SmartRegistry getRegistry() {
        return registry;
    }

    public Tasker getTasker() {
        return tasker;
    }

    public static SmartAddon getSmartAddon() {
        return smartAddon;
    }

    @NotNull
    @Override
    public JavaPlugin getJavaPlugin() {
        return plugin;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return null;
    }

}
