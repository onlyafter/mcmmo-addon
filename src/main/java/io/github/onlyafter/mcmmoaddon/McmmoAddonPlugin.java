package io.github.onlyafter.mcmmoaddon;

import com.redebomba.framework.libraries.command.bukkit.BukkitFrame;
import io.github.onlyafter.mcmmoaddon.command.SkillsCommand;
import io.github.onlyafter.mcmmoaddon.listener.MMOListener;
import io.github.onlyafter.mcmmoaddon.view.RankingView;
import io.github.onlyafter.mcmmoaddon.view.SkillsView;
import lombok.Getter;
import me.saiintbrisson.minecraft.ViewFrame;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class McmmoAddonPlugin extends JavaPlugin {

    @Getter private static ViewFrame frame;

    @Override
    public void onEnable() {

        frame = new ViewFrame(this);
        frame.register(new RankingView(), new SkillsView());

        BukkitFrame bukkitFrame = new BukkitFrame(this);
        bukkitFrame.registerCommands(new SkillsCommand());

        Bukkit.getPluginManager().registerEvents(new MMOListener(), this);

    }
}
