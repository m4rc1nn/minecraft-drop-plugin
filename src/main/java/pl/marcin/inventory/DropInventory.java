package pl.marcin.inventory;

import io.github.rysefoxx.inventory.plugin.content.IntelligentItem;
import io.github.rysefoxx.inventory.plugin.content.InventoryContents;
import io.github.rysefoxx.inventory.plugin.content.InventoryProvider;
import io.github.rysefoxx.inventory.plugin.pagination.RyseInventory;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import pl.marcin.BasicDrop;
import pl.marcin.utils.ItemBuilder;

public class DropInventory {

    public static void openInventory(Player player) {
         RyseInventory inventory = RyseInventory.builder()
                .title("This is a basic inventory")
                .rows(3)
                .disableUpdateTask()
                .provider(new InventoryProvider() {
                    @Override
                    public void init(Player player, InventoryContents contents) {
                        contents.set(0, IntelligentItem.empty(new ItemBuilder(Material.STONE).setName("I am a stone with which nothing happens.").toItemStack()));
                        contents.set(1, IntelligentItem.ignored(new ItemBuilder(Material.STONE).setName("I am a stone that can be taken out of the inventory.").toItemStack()));
                        contents.set(2, IntelligentItem.of(new ItemBuilder(Material.STONE).setName("I am a stone where something happens when you click on me.").toItemStack(), event -> {
                            event.getWhoClicked().sendMessage("You clicked on a stone!");
                        }));
                    }
                })
                .build(BasicDrop.getInstance());
         player.openInventory(inventory.getInventory());

    }
}
