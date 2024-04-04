package pl.marcin.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class DropUserUtil {

    public static List<DropUser> dropUserList = new ArrayList<DropUser>();

    public static void add(DropUser dropUser) {
        dropUserList.add(dropUser);
    }

    public static DropUser get(UUID uuid) {
        for(DropUser dropUser : dropUserList) {
            if(dropUser.getUUID().equals(uuid)) {
                return dropUser;
            }
        }
        return null;
    }
}
