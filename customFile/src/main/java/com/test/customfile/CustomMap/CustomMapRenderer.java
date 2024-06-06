package com.test.customfile.CustomMap;

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class CustomMapRenderer extends MapRenderer {
    @Override
    public void render(MapView map, MapCanvas canvas, Player player) {
        try {
            BufferedImage read = ImageIO.read(new URL("https://cuni.cz/newlayout/images/instagram.png"));
            canvas.drawImage(0, 0, read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
