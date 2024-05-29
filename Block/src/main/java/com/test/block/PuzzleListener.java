//package com.test.block;
//
//import org.bukkit.Bukkit;
//import org.bukkit.Material;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.inventory.ItemStack;
//
//public class PuzzleListener implements Listener {
//    private final int startX = -135;
//    private final int startY = 66;
//    private final int startZ = -40;
//
//    private final Material movableBlock = Material.BLACK_CONCRETE;
//    private final Material immovableBlock = Material.WHITE_CONCRETE;
//
//    private final ItemStack startButton = new ItemCreator(Material.BAMBOO_BUTTON)
//            .displayName("Start")
//            .build();
//
//    private final ItemStack resetButton = new ItemCreator(Material.BAMBOO_BUTTON)
//            .displayName("Reset")
//            .build();
//
//    private final ItemStack upButton = new ItemCreator(Material.BAMBOO_BUTTON)
//            .displayName("Up")
//            .build();
//
//    private final ItemStack downButton = new ItemCreator(Material.BAMBOO_BUTTON)
//            .displayName("Down")
//            .build();
//    private final ItemStack leftButton = new ItemCreator(Material.BAMBOO_BUTTON)
//            .displayName("Left")
//            .build();
//
//    private final ItemStack rightButton = new ItemCreator(Material.BAMBOO_BUTTON)
//            .displayName("Right")
//            .build();
//
//    private final int[][] board = {
//            {1,1,0,1,1},
//            {0,2,0,2,1},
//            {0,1,2,0,2},
//            {0,2,0,1,0},
//            {1,1,0,2,1}
//    };
//
//
//    private void initializePuzzle() {
//        for (int y=0; y<5; y++) {
//            for (int x=0; x<5; x++) {
//                switch (board[y][x]) {
//                    case 0 :
//                        Bukkit.getWorld("world").getBlockAt(startX+x, startY, startZ+y).setType(Material.AIR);
//                        break;
//                    case 1 :
//                        Bukkit.getWorld("world").getBlockAt(startX+x, startY, startZ+y).setType(immovableBlock);
//                        break;
//                    case 2 :
//                        Bukkit.getWorld("world").getBlockAt(startX+x, startY, startZ+y).setType(movableBlock);
//                        break;
//                }
//            }
//        }
//    }
//    @EventHandler
//    public void onClickButton (Button)
//
//}
