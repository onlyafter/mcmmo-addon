package io.github.onlyafter.mcmmoaddon.util;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;
import net.luckperms.api.query.QueryOptions;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class LuckPermsUtil {

    private static final LuckPerms PROVIDER;

    public static String getColoredPrefixFrom(final Player player, final boolean withName) {
        final CachedMetaData metaData = getCachedMetadata(player.getName());
        if (metaData == null) {
            return "";
        }
        if (metaData.getPrefix() == null) {
            return "";
        }
        return ChatColor.translateAlternateColorCodes('&', metaData.getPrefix() + (withName ? player.getName() : ""));
    }

    public static String getColoredPrefixFrom(final String name, final boolean withName) {
        final CachedMetaData metaData = getCachedMetadata(name);
        if (metaData == null) {
            return "";
        }
        if (metaData.getPrefix() == null) {
            return "";
        }
        return ChatColor.translateAlternateColorCodes('&', metaData.getPrefix() + (withName ? name : ""));
    }

    public static String getColoredSuffixFrom(final Player player, final boolean withName) {
        final CachedMetaData metaData = getCachedMetadata(player.getName());
        if (metaData == null) {
            return "";
        }
        if (metaData.getSuffix() == null) {
            return "";
        }
        return ChatColor.translateAlternateColorCodes('&', metaData.getSuffix() + (withName ? player.getName() : ""));
    }

    public static String getColoredSuffixFrom(final String name, final boolean withName) {
        final CachedMetaData metaData = getCachedMetadata(name);
        if (metaData == null) {
            return "";
        }
        if (metaData.getSuffix() == null) {
            return "";
        }
        return ChatColor.translateAlternateColorCodes('&', metaData.getSuffix() + (withName ? name : ""));
    }

    public static String getPrefixColorFrom(final Player player, final boolean withName) {
        final CachedMetaData metaData = getCachedMetadata(player.getName());
        if (metaData == null) {
            return "";
        }
        if (metaData.getSuffix() == null) {
            return "";
        }
        return ChatColor.translateAlternateColorCodes('&', metaData.getSuffix().substring(0, 2) + (withName ? player.getName() : ""));
    }

    public static String getPrefixColorFrom(final String name, final boolean withName) {
        final CachedMetaData metaData = getCachedMetadata(name);
        if (metaData == null) {
            return "";
        }
        if (metaData.getSuffix() == null) {
            return "";
        }
        return ChatColor.translateAlternateColorCodes('&', metaData.getSuffix().substring(0, 2) + (withName ? name : ""));
    }

    private static CachedMetaData getCachedMetadata(final String userName) {
        final User user = LuckPermsUtil.PROVIDER.getUserManager().getUser(userName);
        if (user == null) {
            return null;
        }
        return user.getCachedData().getMetaData(QueryOptions.defaultContextualOptions());
    }

    static {
        PROVIDER = LuckPermsProvider.get();
    }
}