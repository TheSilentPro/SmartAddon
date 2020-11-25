package tsp.smartaddon.tasker.task;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import tsp.smartaddon.implementation.Weapon;
import tsp.smartaddon.tasker.Task;

/**
 * This tasker updates all {@link Weapon}'s
 *
 * @author TheSilentPro
 */
public class WeaponTasker implements Task {

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            SlimefunItem main = SlimefunItem.getByItem(player.getInventory().getItemInMainHand());
            SlimefunItem off = SlimefunItem.getByItem(player.getInventory().getItemInOffHand());
            if (main instanceof Weapon) {
                if (((Weapon) main).getPotionEffects() != null) {
                    player.addPotionEffects(((Weapon) main).getPotionEffects());
                }
            }
            if (off instanceof Weapon) {
                if (((Weapon) off).getPotionEffects() != null) {
                    player.addPotionEffects(((Weapon) off).getPotionEffects());
                }
            }
        }
    }

}
