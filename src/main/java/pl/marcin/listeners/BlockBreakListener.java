package pl.marcin.listeners;

import org.bukkit.event.EventHandler;
import pl.marcin.objects.DropItem;
import pl.marcin.objects.DropItemUtil;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BlockBreakListener implements Listener {

    private final Random random = new Random();

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if(event.getBlock().getType() != Material.STONE) {
            return;
        }
        for(DropItem dropItem : DropItemUtil.dropItemList) {
            double chance = random.nextDouble() * 100;
            if (chance > dropItem.getChance()) {
                return;
            }
            event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new ItemStack(dropItem.getItem()));
            event.getPlayer().sendMessage("Wydropiłeś: " + dropItem.getName());
        }
    }
}
