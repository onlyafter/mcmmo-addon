package io.github.onlyafter.mcmmoaddon.command;

import com.redebomba.framework.libraries.command.common.annotation.Command;
import com.redebomba.framework.libraries.command.common.command.Context;
import io.github.onlyafter.mcmmoaddon.McmmoAddonPlugin;
import io.github.onlyafter.mcmmoaddon.view.SkillsView;
import org.bukkit.entity.Player;

public class SkillsCommand {

    @Command(
            name = "skill",
            aliases = { "mctop", "stats", "skills" }
    )
    public void skillsCommand(Context<Player> context) {

        McmmoAddonPlugin.getFrame().open(SkillsView.class, context.getSender());

    }

}
