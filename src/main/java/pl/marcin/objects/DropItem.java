package pl.marcin.objects;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;

public class DropItem {

    private String name;
    private Material item;
    private double chance;
    private int minHeight;
    private boolean fortune;
    private int amount;
    private List<Player> turnOffList;

    public DropItem(String name, Material item, double chance, int minHeight, boolean fortune, int amount) {
        this.name = name;
        this.item = item;
        this.chance = chance;
        this.minHeight = minHeight;
        this.fortune = fortune;
        this.amount = amount;
        DropItemUtil.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getItem() {
        return item;
    }

    public void setItem(Material item) {
        this.item = item;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public boolean isFortune() {
        return fortune;
    }

    public void setFortune(boolean fortune) {
        this.fortune = fortune;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void switchTurn(DropUser dropUser){
        dropUser.switchDrop(this);
    }
}
