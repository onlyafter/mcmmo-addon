package io.github.onlyafter.mcmmoaddon.view;

import com.gmail.nossr50.datatypes.skills.SkillType;
import com.redebomba.framework.item.ItemBuilder;
import io.github.onlyafter.mcmmoaddon.McmmoAddonPlugin;
import io.github.onlyafter.mcmmoaddon.mcmmo.MMOUtils;
import me.saiintbrisson.minecraft.View;
import me.saiintbrisson.minecraft.ViewContext;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class RankingView extends View {

    public RankingView() {

        super(6, "Ranking de Skills");

        setCancelOnClick(true);
        setCancelOnDrag(true);
        setCancelOnDrop(true);
        setCancelOnPickup(true);
        setCancelOnShiftClick(true);
        setCloseOnOutsideClick(true);

    }

    @Override
    protected void onRender(@NotNull ViewContext context) {

        context.slot(13, new ItemBuilder(Material.BOOK)
                .name("§eRanking Global")
                .lore(MMOUtils.getTopLore(null))
                .build());

        context.slot(20, new ItemBuilder(Material.DIAMOND_SWORD)
                .name("§eEspadas")
                .lore(MMOUtils.getTopLore(SkillType.SWORDS))
                .build());

        context.slot(21, new ItemBuilder(Material.DIAMOND_AXE)
                .name("§eMachados")
                .lore(MMOUtils.getTopLore(SkillType.AXES))
                .build());

        context.slot(22, new ItemBuilder(Material.DIAMOND_BOOTS)
                .name("§eAcrobacias")
                .lore(MMOUtils.getTopLore(SkillType.ACROBATICS))
                .build());

        context.slot(23, new ItemBuilder(Material.DIAMOND_PICKAXE)
                .name("§eMineração")
                .lore(MMOUtils.getTopLore(SkillType.MINING))
                .build());

        context.slot(24, new ItemBuilder(Material.DIAMOND_SPADE)
                .name("§eEscavação")
                .lore(MMOUtils.getTopLore(SkillType.EXCAVATION))
                .build());

        context.slot(31, new ItemBuilder(Material.SEEDS)
                .name("§eHerbalismo")
                .lore(MMOUtils.getTopLore(SkillType.HERBALISM))
                .build());

        context.slot(49, new ItemBuilder(Material.ARROW)
                .name("§aVoltar")
                .build())
                .onClick(clickContext -> McmmoAddonPlugin.getFrame().open(SkillsView.class, clickContext.getPlayer()));


    }
}
