package com.test.customfile.CustomMap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class MapOpenListener implements Listener {
    @EventHandler
    public void onMapOpen(MapInitializeEvent event) {
        // 기존 지도 제거
        MapView map = event.getMap();

        for (MapRenderer renderer : map.getRenderers()) {
            map.removeRenderer(renderer);
        }

        map.addRenderer(new CustomMapRenderer());
    }
}
