package tsp.smartaddon.tasker;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Utility class for running a {@link Runnable} or {@link Consumer<BukkitTask>}
 *
 * @author TheSilentPro
 */

public class Tasker {

    private final JavaPlugin plugin;
    private final BukkitScheduler scheduler;

    public Tasker(JavaPlugin plugin) {
        this.plugin = plugin;
        this.scheduler = plugin.getServer().getScheduler();
    }

    // SYNC
    public BukkitTask sync(Runnable task) {
        return scheduler.runTask(plugin, task);
    }

    public List<BukkitTask> sync(Runnable... tasks) {
        List<BukkitTask> result = new ArrayList<>();
        Arrays.stream(tasks).forEach(task -> result.add(sync(task)));

        return result;
    }

    public BukkitTask syncTimer(Runnable task, long delay, long repeat) {
        return scheduler.runTaskTimer(plugin, task, delay, repeat);
    }

    public BukkitTask syncTimer(Runnable task, long repeat) {
        return syncTimer(task, 0L, repeat);
    }

    public List<BukkitTask> syncTimer(long delay, long repeat, Runnable... tasks) {
        List<BukkitTask> result = new ArrayList<>();
        Arrays.stream(tasks).forEach(task -> result.add(syncTimer(task, delay, repeat)));

        return result;
    }

    public List<BukkitTask> syncTimer(long repeat, Runnable... tasks) {
        return syncTimer(0L, repeat, tasks);
    }

    public BukkitTask syncLater(Runnable task, long delay) {
        return scheduler.runTaskLater(plugin, task, delay);
    }

    public List<BukkitTask> syncLater(long delay, Runnable... tasks) {
        List<BukkitTask> result = new ArrayList<>();
        Arrays.stream(tasks).forEach(task -> result.add(syncLater(task, delay)));

        return result;
    }

    // SYNC - CONSUMER
    public void sync(Consumer<BukkitTask> task) {
        scheduler.runTask(plugin, task);
    }

    public void sync(Consumer<BukkitTask>... tasks) {
        Arrays.stream(tasks).forEach(this::sync);
    }

    public void syncTimer(Consumer<BukkitTask> task, long delay, long repeat) {
        scheduler.runTaskTimer(plugin, task, delay, repeat);
    }

    public void syncTimer(Consumer<BukkitTask> task, long repeat) {
        syncTimer(task, 0L, repeat);
    }

    public void syncTimer(long delay, long repeat, Consumer<BukkitTask>... tasks) {
        Arrays.stream(tasks).forEach(task -> syncTimer(task, delay, repeat));
    }

    public void syncTimer(long repeat, Consumer<BukkitTask>... tasks) {
        syncTimer(0L, repeat, tasks);
    }

    public void syncLater(Consumer<BukkitTask> task, long delay) {
        scheduler.runTaskLater(plugin, task, delay);
    }

    public void syncLater(long delay, Consumer<BukkitTask>... tasks) {
        Arrays.stream(tasks).forEach(task -> syncLater(task, delay));
    }

    // ASYNC
    public BukkitTask async(Runnable task) {
        return scheduler.runTaskAsynchronously(plugin, task::run);
    }

    public List<BukkitTask> async(Runnable... tasks) {
        List<BukkitTask> result = new ArrayList<>();
        Arrays.stream(tasks).forEach(task -> result.add(async(task)));

        return result;
    }

    public BukkitTask asyncTimer(Runnable task, long delay, long repeat) {
        return scheduler.runTaskTimerAsynchronously(plugin, task, delay, repeat);
    }

    public BukkitTask asyncTimer(Runnable task, long repeat) {
        return asyncTimer(task, 0L, repeat);
    }

    public List<BukkitTask> asyncTimer(long delay, long repeat, Runnable... tasks) {
        List<BukkitTask> result = new ArrayList<>();
        Arrays.stream(tasks).forEach(task -> result.add(asyncTimer(task, delay, repeat)));

        return result;
    }

    public List<BukkitTask> asyncTimer(long repeat, Runnable... tasks) {
        return asyncTimer(0L, repeat, tasks);
    }

    public BukkitTask asyncLater(Runnable task, long delay) {
        return scheduler.runTaskLaterAsynchronously(plugin, task, delay);
    }

    public List<BukkitTask> asyncLater(long delay, Runnable... tasks) {
        List<BukkitTask> result = new ArrayList<>();
        Arrays.stream(tasks).forEach(task -> result.add(asyncLater(task, delay)));

        return result;
    }

    // ASYNC - CONSUMER
    public void async(Consumer<BukkitTask> task) {
        scheduler.runTaskAsynchronously(plugin, task);
    }

    public void async(Consumer<BukkitTask>... tasks) {
        Arrays.stream(tasks).forEach(this::async);
    }

    public void asyncTimer(Consumer<BukkitTask> task, long delay, long repeat) {
        scheduler.runTaskTimerAsynchronously(plugin, task, delay, repeat);
    }

    public void asyncTimer(Consumer<BukkitTask> task, long repeat) {
        asyncTimer(task, 0L, repeat);
    }

    public void asyncTimer(long delay, long repeat, Consumer<BukkitTask>... tasks) {
        Arrays.stream(tasks).forEach(task -> asyncTimer(task, delay, repeat));
    }

    public void asyncTimer(long repeat, Consumer<BukkitTask>... tasks) {
        asyncTimer(0L, repeat, tasks);
    }

    public void asyncLater(Consumer<BukkitTask> task, long delay) {
        scheduler.runTaskLaterAsynchronously(plugin, task, delay);
    }

    public void asyncLater(long delay, Consumer<BukkitTask>... tasks) {
        Arrays.stream(tasks).forEach(task -> asyncLater(task, delay));
    }

    public void stopAll() {
        scheduler.cancelTasks(plugin);
    }

    public BukkitScheduler getScheduler() {
        return scheduler;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

}