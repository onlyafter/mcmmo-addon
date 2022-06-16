package io.github.onlyafter.mcmmoaddon.listener;

import com.gmail.nossr50.api.ExperienceAPI;
import com.gmail.nossr50.events.experience.McMMOPlayerLevelUpEvent;
import com.gmail.nossr50.events.experience.McMMOPlayerXpGainEvent;
import io.github.onlyafter.mcmmoaddon.mcmmo.MMOUtils;
import io.github.onlyafter.mcmmoaddon.util.ActionbarUtil;
import io.github.onlyafter.mcmmoaddon.util.LuckPermsUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MMOListener implements Listener {

    @EventHandler
    void mmoXpGain(McMMOPlayerXpGainEvent event) {

        int xp = (int)((double)event.getRawXpGained() * MMOUtils.getBonusXP(event.getPlayer()));

        float percent = ExperienceAPI.getXPRaw(event.getPlayer(), event.getSkill().getName()) * 100.0F / (float)ExperienceAPI.getXPToNextLevel(event.getPlayer(), event.getSkill().getName());
        String string = "§a" + event.getSkill().getName() + " §f " + event.getSkillLevel();
        if (percent <= 10.0F) {
            string = string + " §f▌▌▌▌▌▌▌▌▌ ";
        } else if (percent <= 20.0F) {
            string = string + " §a▌§f▌▌▌▌▌▌▌▌ ";
        } else if (percent <= 30.0F) {
            string = string + " §a▌▌§f▌▌▌▌▌▌▌ ";
        } else if (percent <= 40.0F) {
            string = string + " §a▌▌▌§f▌▌▌▌▌▌ ";
        } else if (percent <= 50.0F) {
            string = string + " §a▌▌▌▌§f▌▌▌▌▌▌ ";
        } else if (percent <= 60.0F) {
            string = string + " §a▌▌▌▌▌§f▌▌▌▌▌ ";
        } else if (percent <= 70.0F) {
            string = string + " §a▌▌▌▌▌▌§f▌▌▌▌ ";
        } else if (percent <= 80.0F) {
            string = string + " §a▌▌▌▌▌▌▌§f▌▌▌ ";
        } else if (percent <= 90.0F) {
            string = string + " §a▌▌▌▌▌▌▌▌§f▌▌ ";
        } else if (percent <= 100.0F) {
            string = string + " §a▌▌▌▌▌▌▌▌▌§f▌ ";
        }

        string = string + "§a+" + event.getRawXpGained() + "XP ";
        ActionbarUtil.send(event.getPlayer(), string);

        event.setRawXpGained(xp);

    }

    @EventHandler
    void levelUp(McMMOPlayerLevelUpEvent event) {

        Player player = event.getPlayer();
        String level = String.valueOf(event.getSkillLevel());

        if (level.endsWith("00")) {
            Bukkit.broadcastMessage("");
            Bukkit.broadcastMessage(LuckPermsUtil.getColoredPrefixFrom(player.getName(), true) + "§f atingiu o nível §7" + event.getSkillLevel() + "§f em " + event.getSkill().getName() + ".");
            Bukkit.broadcastMessage("");
        }
    }

}
