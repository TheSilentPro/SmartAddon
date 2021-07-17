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
public class SmartAddon extends JavaPlugin implements SlimefunAddon {

    private static SmartAddon smartAddon;
    private SlimefunAddon instance;
    private JavaPlugin plugin;
    private SmartRegistry registry;
    private Tasker tasker;

    public void init() {
        smartAddon = this;
        onInit();

        plugin = smartAddon.getJavaPlugin();
        registry = new SmartRegistry();
        tasker.syncTimer(new SuitTasker(), 1L);
        tasker.syncTimer(new WeaponTasker(), 1L);

        new EntityDamageByEntityListener(plugin);
        new PlayerInteractListener(plugin);
        new SuitEquipListener(plugin);
        new EntityDeathListener(plugin);
    }

    public void onInit() {}

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

    @NotNull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return null;
    }

}
