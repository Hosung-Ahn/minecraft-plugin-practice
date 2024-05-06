package com.minecraftdev;

import java.util.HashMap;
import java.util.UUID;

public class RecentMessageFactory {
    private static final HashMap<UUID, UUID> recentMessage = new HashMap<>();

    public static void setRecentMessage(UUID sender, UUID receiver) {
        recentMessage.put(sender, receiver);
    }

    public static UUID getRecentMessage(UUID sender) {
        return recentMessage.get(sender);
    }

    public static boolean existsRecentMessage(UUID sender) {
        return recentMessage.containsKey(sender);
    }
}
