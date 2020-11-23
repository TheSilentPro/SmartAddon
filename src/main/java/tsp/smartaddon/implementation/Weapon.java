package tsp.smartaddon.implementation;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;

import java.util.List;

/**
 * Represents a {@link SmartItem} that is also a {@link Weapon}
 *
 * @author TheSilentpro
 */
public interface Weapon {

    List<PotionEffect> getPotionEffects();

    default void onHit(EntityDamageByEntityEvent entityDamageByEntityEvent) {}

}
