package tsp.smartaddon.tasker.task;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import tsp.smartaddon.implementation.Suit;

import java.util.List;

/**
 * This tasker updates all {@link Suit}'s
 *
 * @author TheSilentPro
 */
public class SuitTasker implements Runnable {

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            ItemStack[] contents = player.getInventory().getArmorContents();
            for (ItemStack armor : contents) {
                SlimefunItem sfitem = SlimefunItem.getByItem(armor);
                if (sfitem instanceof Suit) {
                    List<PotionEffect> potionEffects = ((Suit) sfitem).getPotionEffects();
                    if (potionEffects != null) {
                        player.addPotionEffects(potionEffects);
                    }
                }
            }
        }
    }

}
