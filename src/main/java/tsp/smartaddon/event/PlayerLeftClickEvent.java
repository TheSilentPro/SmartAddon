package tsp.smartaddon.event;

import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.cscorelib2.data.ComputedOptional;
import org.apache.commons.lang.Validate;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.Optional;

public class PlayerLeftClickEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final PlayerInteractEvent event;
    private final Player player;
    private final Optional<ItemStack> itemStack;
    private final Optional<Block> clickedBlock;
    private final EquipmentSlot hand;
    private final BlockFace face;
    private ComputedOptional<SlimefunItem> slimefunItem = ComputedOptional.createNew();
    private ComputedOptional<SlimefunItem> slimefunBlock = ComputedOptional.createNew();
    private Result itemResult;
    private Result blockResult;

    public PlayerLeftClickEvent(@Nonnull PlayerInteractEvent e) {
        this.itemResult = Result.DEFAULT;
        this.blockResult = Result.DEFAULT;
        this.event = e;
        this.player = e.getPlayer();
        this.clickedBlock = Optional.ofNullable(e.getClickedBlock());
        this.face = e.getBlockFace();
        this.hand = e.getHand();
        if (e.getItem() != null && e.getItem().getType() != Material.AIR && e.getItem().getAmount() != 0) {
            this.itemStack = Optional.of(e.getItem());
        } else {
            this.itemStack = Optional.empty();
        }

    }

    @Nonnull
    public PlayerInteractEvent getInteractEvent() {
        return this.event;
    }

    @Nonnull
    public Player getPlayer() {
        return this.player;
    }

    @Nonnull
    public ItemStack getItem() {
        return (ItemStack)this.itemStack.orElse(new ItemStack(Material.AIR));
    }

    @Nonnull
    public EquipmentSlot getHand() {
        return this.hand;
    }

    @Nonnull
    public Optional<Block> getClickedBlock() {
        return this.clickedBlock;
    }

    @Nonnull
    public BlockFace getClickedFace() {
        return this.face;
    }

    @Nonnull
    public Optional<SlimefunItem> getSlimefunItem() {
        if (!this.slimefunItem.isComputed()) {
            if (this.itemStack.isPresent()) {
                this.slimefunItem.compute(SlimefunItem.getByItem((ItemStack)this.itemStack.get()));
            } else {
                this.slimefunItem = ComputedOptional.empty();
            }
        }

        return this.slimefunItem.getAsOptional();
    }

    @Nonnull
    public Optional<SlimefunItem> getSlimefunBlock() {
        if (!this.slimefunBlock.isComputed()) {
            if (this.clickedBlock.isPresent()) {
                this.slimefunBlock.compute(BlockStorage.check((Block)this.clickedBlock.get()));
            } else {
                this.slimefunBlock = ComputedOptional.empty();
            }
        }

        return this.slimefunBlock.getAsOptional();
    }

    public void cancel() {
        this.itemResult = Result.DENY;
        this.blockResult = Result.DENY;
    }

    @Nonnull
    public Result useItem() {
        return this.itemResult;
    }

    @Nonnull
    public Result useBlock() {
        return this.blockResult;
    }

    public void setUseItem(@Nonnull Result result) {
        Validate.notNull(result, "Result cannot be null");
        this.itemResult = result;
    }

    public void setUseBlock(@Nonnull Result result) {
        Validate.notNull(result, "Result cannot be null");
        this.blockResult = result;
    }

    @Nonnull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Nonnull
    public HandlerList getHandlers() {
        return getHandlerList();
    }
}
