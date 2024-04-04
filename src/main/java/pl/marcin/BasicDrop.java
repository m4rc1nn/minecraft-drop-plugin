package pl.marcin;

import io.github.rysefoxx.inventory.plugin.pagination.InventoryManager;
import pl.marcin.commands.DropCommand;
import pl.marcin.listeners.BlockBreakListener;
import pl.marcin.objects.DropItem;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicDrop extends JavaPlugin {

    private static BasicDrop plugin;

    public static InventoryManager inventoryManager = new InventoryManager(getInstance());

    @Override
    public void onEnable(){
        plugin = this;
        inventoryManager.invoke();
        new DropItem("diament", Material.DIAMOND, 5.0, 50, true, 5);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
        this.getCommand("drop").setExecutor(new DropCommand());
    }

    public static BasicDrop getInstance(){
        return plugin;
    }
}
