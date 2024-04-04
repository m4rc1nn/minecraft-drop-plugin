package pl.marcin.objects;

import java.util.ArrayList;
import java.util.List;

public class DropItemUtil {

    public static List<DropItem> dropItemList = new ArrayList<DropItem>();

    public static void add(DropItem dropItem) {
        dropItemList.add(dropItem);
    }

    public static List<DropItem> get(){
        return dropItemList;
    }
}
