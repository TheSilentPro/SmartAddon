package tsp.smartaddon.implementation;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;
import tsp.smartaddon.event.PlayerLeftClickEvent;

/**
 * Represents a {@link SmartItem}
 *
 * @author TheSilentPro
 */
public class SmartItem extends SlimefunItem {

    public SmartItem(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(category, item, recipeType, recipe);
    }

    public void onRightClick(PlayerRightClickEvent playerRightClickEvent) {

    }

    public void onLeftClick(PlayerLeftClickEvent playerLeftClickEvent) {

    }

    public int getCooldown() {
        return -1;
    }

    @Override
    public void preRegister() {
        addItemHandler((ItemUseHandler) this::onRightClick);
    }

}
