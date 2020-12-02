package tsp.smartaddon;

import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import tsp.smartaddon.implementation.MobDrop;
import tsp.smartaddon.implementation.SmartItem;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class SmartRegistry {

    private final Map<EntityType, List<ItemStack>> mobDrops = new EnumMap<>(EntityType.class);

    public void registerMobDrop(SmartItem smartItem) {
        if (smartItem instanceof MobDrop) {
            for (EntityType entity : ((MobDrop) smartItem).getMobs()) {
                List<ItemStack> drops = getMobDrops().getOrDefault(entity, new ArrayList<>());
                drops.addAll(((MobDrop) smartItem).getMobDrops());
                mobDrops.put(entity, drops);
            }
        }
    }

    public Map<EntityType, List<ItemStack>> getMobDrops() {
        return mobDrops;
    }

}
