package pl.marcin.objects;

import java.util.*;

public class DropUser {

    private UUID uuid;
    private List<DropItem> disabledDropList;
    private int points;

    public DropUser(UUID uuid) {
        this.uuid = uuid;
        this.disabledDropList = new ArrayList<DropItem>();
        this.points = 0;
        DropUserUtil.add(this);
    }

    public UUID getUUID(){
        return this.uuid;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }

    public void addDropItem(DropItem dropItem) {
        this.disabledDropList.add(dropItem);
    }

    public void removeDropItem(DropItem dropItem) {
        this.disabledDropList.remove(dropItem);
    }

    public Boolean getStatus(DropItem dropItem) {
        return !this.disabledDropList.contains(dropItem);
    }

    public void switchDrop(DropItem dropItem) {
        if(this.disabledDropList.contains(dropItem)) {
            this.removeDropItem(dropItem);
        } else {
            this.addDropItem(dropItem);
        }
    }
}
