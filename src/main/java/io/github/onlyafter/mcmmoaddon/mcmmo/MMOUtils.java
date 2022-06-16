package io.github.onlyafter.mcmmoaddon.mcmmo;

import com.gmail.nossr50.datatypes.skills.*;
import com.gmail.nossr50.datatypes.database.*;
import com.gmail.nossr50.database.*;
import io.github.onlyafter.mcmmoaddon.util.LuckPermsUtil;
import org.bukkit.entity.Player;

import java.util.*;

public class MMOUtils {

    private static final DatabaseManager DATABASE_MANAGER = DatabaseManagerFactory.getDatabaseManager();

    public static List<String> getTopLore(SkillType skillType) {

        List<String> lore = new ArrayList<>();

        readTop(skillType, 10).stream().sorted((o1, o2) -> Integer.compare(o2.statVal, o1.statVal)).forEach($ -> lore.add(LuckPermsUtil.getColoredPrefixFrom($.name, false) + $.name + ": §f" + $.statVal));

        return lore;
    }

    public static int getPlayerPosition(String name, SkillType skillType) {

        Map<SkillType, Integer> skillTypeIntegerMap = DATABASE_MANAGER.readRank(name);

        if (skillTypeIntegerMap == null
                || !skillTypeIntegerMap.containsKey(skillType)) {
            return 0;
        }

        return skillTypeIntegerMap.get(skillType);
    }

    private static List<PlayerStat> readTop(SkillType skillType, int range) {
        return DATABASE_MANAGER.readLeaderboard(skillType, 1, range);
    }

    public static String getFirst(SkillType skillType) {

        Optional<PlayerStat> first = Optional.empty();

        Iterator<PlayerStat> iterator = readTop(skillType, 1).iterator();

        if (iterator.hasNext()) {
            PlayerStat playerStat = iterator.next();
            first = Optional.of(playerStat);
        }

        return first.map(playerStat -> LuckPermsUtil.getColoredPrefixFrom(playerStat.name, false) + playerStat.name).orElse("Ninguém");
    }

    public static String getFirst() {

        Optional<PlayerStat> first = Optional.empty();

        Iterator<PlayerStat> iterator = readTop(null, 1).iterator();

        if (iterator.hasNext()) {
            PlayerStat playerStat = iterator.next();
            first = Optional.of(playerStat);
        }

        return first.map(playerStat -> LuckPermsUtil.getColoredPrefixFrom(playerStat.name, false) + playerStat.name).orElse("Ninguém");
    }

    public static Double getBonusXP(Player player) {

        if (player.hasPermission("group.vip+")) { return 1.25; }

        if (player.hasPermission("group.mvp")) { return 1.5; }

        if (player.hasPermission("group.mvp+")) { return 1.75; }

        if (player.hasPermission("group.bomba")) { return 2.0; } else { return 1.0; }
    }
}