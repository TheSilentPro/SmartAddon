package tsp.smartaddon.implementation;

import org.bukkit.potion.PotionEffect;
import tsp.smartaddon.event.SuitEquipEvent;

import java.util.List;

/**
 * Represents a {@link SmartItem} that is also a {@link Suit}
 *
 * @author TheSilentPro
 */
public interface Suit {

    List<PotionEffect> getPotionEffects();

    default void onEquip(SuitEquipEvent suitEquipEvent) {}

    default void onUnEquip(SuitEquipEvent suitEquipEvent) {}

}
