package com.spigotadvance;

import com.spigotadvance.gui.MenuCommand;
import com.spigotadvance.gui.MenuListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class SpigotAdvance extends JavaPlugin {
    private int count = 0; // 태스크가 실행된 횟수를 세는 변수
    private BukkitTask taskTimer; // 태스크를 클래스 필드로 저장

    @Override
    public void onEnable() {
//        runTask();
        getCommand("menu").setExecutor(new MenuCommand());
        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);

    }


    private void runTask() {
        // 30초 후에 모든 플레이어에게 메시지를 보냅니다.
        Bukkit.getScheduler().runTaskLater(this, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("Server has been up for 30 seconds!");
            }
        }, 600L);

        // 40초 후에 모든 플레이어에게 1초마다 메시지를 5번 보냅니다.
        taskTimer = Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage("Server has been up for 40 seconds! (1 second interval)");
            }
            count++; // 태스크를 실행할 때마다 카운트를 증가
            System.out.println(taskTimer);

            if (count >= 5) {
                taskTimer.cancel(); // 5번 실행된 후 태스크를 취소
            }
        }, 800L, 20L);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
