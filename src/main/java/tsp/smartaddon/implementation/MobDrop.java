package tsp.smartaddon.implementation;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Represents a droppable {@link SmartItem} from {@link EntityType}
 *
 * @author TheSilentPro
 */
public interface MobDrop {

    List<EntityType> getMobs();

    List<ItemStack> getMobDrops();

    int getDropChance();

}
