package com.test.firstplugin;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;

public class PunishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // 명령어 실행자가 플레이어가 아니라면 처리하지 않음
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This command can only be used by a player.");
            return true;
        }

        // 올바른 인자 개수 확인
        if (args.length < 2) {
            sender.sendMessage(ChatColor.RED + "Usage: /punish <kick|ban|tempban> <playerName> [duration in minutes]");
            return true;
        }

        // 대상 플레이어 가져오기
        Player target = Bukkit.getPlayerExact(args[1]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Player not found.");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "kick":
                target.kickPlayer(ChatColor.RED + "You have been kicked from the server.");
                sender.sendMessage(ChatColor.GREEN + "Player kicked successfully.");
                break;
            case "ban":
                Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), "You have been banned from the server.", null, null);
                target.kickPlayer(ChatColor.RED + "You have been banned from the server.");
                sender.sendMessage(ChatColor.GREEN + "Player banned successfully.");
                break;
            case "tempban":
                if (args.length < 3) {
                    sender.sendMessage(ChatColor.RED + "Please specify the duration for the tempban in minutes.");
                    return true;
                }
                try {
                    int duration = Integer.parseInt(args[2]);
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.MINUTE, duration); // 현재 시간에 입력받은 분을 더함

                    Bukkit.getBanList(org.bukkit.BanList.Type.NAME).addBan(target.getName(), "You have been temporarily banned from the server.", calendar.getTime(), null);
                    target.kickPlayer(ChatColor.RED + "You have been temporarily banned from the server.");
                    sender.sendMessage(ChatColor.GREEN + "Player temporarily banned for " + duration + " minutes.");
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "Invalid duration. Please enter a valid number.");
                }
                break;
            default:
                sender.sendMessage(ChatColor.RED + "Invalid action. Use kick, ban, or tempban.");
                return true;
        }

        return true; // 명령어 처리 성공
    }
}
