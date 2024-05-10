package com.playground.commandTabComplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class FruitTab implements TabCompleter {
    private final List<String> fruits = List.of(
            "apple", "apricot", "avocado",
            "banana", "blackberry", "blueberry", "boysenberry",
            "cantaloupe", "cherimoya", "cherry", "clementine", "crabapple",
            "currant", "blackcurrant", "breadfruit",
            "cranberry", "cucumber", "custard apple",
            "blood orange", "bilberry"
    );
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
//            return StringUtil.copyPartialMatches(args[0], fruits, new ArrayList<>());

            String input = args[0];
            List<String> result = new ArrayList<>();
            for (String fruit : fruits) {
                if (fruit.startsWith(input)) {
                    result.add(fruit);
                }
            }
            return result;
        }
        return List.of();
    }
}
