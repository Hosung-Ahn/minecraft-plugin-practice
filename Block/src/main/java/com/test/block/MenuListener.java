package com.test.block;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class MenuListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (ChatColor.translateAlternateColorCodes('&', event.getView().getTitle())
                .equals(ChatColor.RED.toString() + ChatColor.BOLD + "Menu")
                && event.getCurrentItem() != null){
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            switch (event.getRawSlot()) {
                case 0 :
                    break;
                case 22: // start
                    makePuzzle(player.getLocation());
                    break;
                default :
                    return;
            }
            player.closeInventory();
        }
    }

    private void makePuzzle(Location location) {
        int startX = location.getBlockX() - 5;
        int startY = location.getBlockY() - 1;
        int startZ = location.getBlockZ() + 8;


        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 9; y++) {
                for (int z = 12; z >= 0; z--) {
                    if (x == 0 || x == 10 || y == 0 || y == 8 || z == 12 || z == 0) {
                        if ((x + y + z) % 2 == 0)
                            location.getWorld().getBlockAt(startX + x, startY + y, startZ - z).setType(Material.GOLD_BLOCK);
                        else
                            location.getWorld().getBlockAt(startX + x, startY + y, startZ - z).setType(Material.GLOWSTONE);
                    } else {
                        location.getWorld().getBlockAt(startX + x, startY + y, startZ - z).setType(Material.AIR);
                    }
                }
            }
        }

        int puzzleX = location.getBlockX() - 3;
        int puzzleY = location.getBlockY();
        int puzzleZ = location.getBlockZ() + 6;
        int[][] board = {
                {3, 3, 3, 3, 3, 3, 3},
                {3, 1, 1, 0, 1, 1, 3},
                {3, 0, 2, 0, 2, 1, 3},
                {3, 0, 1, 2, 0, 2, 3},
                {3, 0, 2, 0, 1, 0, 3},
                {3, 1, 1, 0, 2, 1, 3},
                {3, 3, 3, 3, 3, 3, 3}
        };

        int playerX = location.getBlockX();
        int playerY = location.getBlockY();
        int playerZ = location.getBlockZ() + 6;

        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                switch (board[y][x]) {
                    case 0:
                        location.getWorld().getBlockAt(playerX + x, playerY + y, playerZ).setType(Material.AIR);
                        break;
                    case 1:
                        location.getWorld().getBlockAt(playerX + x, playerY + y, playerZ).setType(Material.WHITE_CONCRETE);
                        break;
                    case 2:
                        location.getWorld().getBlockAt(playerX + x, playerY + y, playerZ).setType(Material.BLACK_CONCRETE);
                        break;
                    case 3:
                        location.getWorld().getBlockAt(playerX + x, playerY + y, playerZ).setType(Material.GOLD_BLOCK);
                        break;
                }
            }
        }

        Block buttomBlock = location.getWorld().getBlockAt(puzzleX - 2, puzzleY, puzzleZ);
        buttomBlock.setType(Material.GOLD_BLOCK);
        buttomBlock.getRelative(BlockFace.NORTH).setType(Material.STONE_BUTTON);

        Block buttomBlock = location.getWorld().getBlockAt(puzzleX - 2, puzzleY, puzzleZ);
        buttomBlock.setType(Material.GOLD_BLOCK);
        buttomBlock.getRelative(BlockFace.NORTH).setType(Material.STONE_BUTTON);

    }
}
