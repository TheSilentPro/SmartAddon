package tsp.smartaddon.listener;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import tsp.smartaddon.SmartAddon;
import tsp.smartaddon.implementation.MobDrop;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EntityDeathListener implements Listener {

    public EntityDeathListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        if (e.getEntity().getKiller() != null) {
            Player player = e.getEntity().getKiller();;

            List<ItemStack> drops = SmartAddon.getSmartAddon().getRegistry().getMobDrops().get(e.getEntityType());

            if (drops != null && !drops.isEmpty()) {
                for (ItemStack drop : drops) {
                    if (canDrop(player, drop)) {
                        e.getDrops().add(drop);
                    }
                }
            }
        }
    }

    private boolean canDrop(@Nonnull Player p, @Nonnull ItemStack item) {
        SlimefunItem sfi = SlimefunItem.getByItem(item);

        if (sfi == null) {
            return true;
        } else if (Slimefun.hasUnlocked(p, sfi, true)) {
            if (sfi instanceof MobDrop) {
                int random = ThreadLocalRandom.current().nextInt(100);

                if (((MobDrop) sfi).getDropChance() <= random) {
                    return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

}
