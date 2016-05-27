package com.demonwav.mcdev.platform.bukkit;

import com.demonwav.mcdev.asset.PlatformAssets;
import com.demonwav.mcdev.platform.PlatformType;

import com.intellij.openapi.module.Module;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;

public class SpigotModuleType extends BukkitModuleType {

    private static final String ID = "SPIGOT_MODULE_TYPE";
    private static final SpigotModuleType instance = new SpigotModuleType();

    private SpigotModuleType() {
        super(ID, "org.spigotmc", "spigot-api");
    }

    protected SpigotModuleType(final String ID, final String groupId, final String artifactId) {
        super(ID, groupId, artifactId);
    }

    public static SpigotModuleType getInstance() {
        return instance;
    }

    @Override
    public PlatformType getPlatformType() {
        return PlatformType.SPIGOT;
    }

    @Override
    public Icon getBigIcon() {
        return PlatformAssets.SPIGOT_ICON_2X;
    }

    @Override
    public Icon getIcon() {
        return PlatformAssets.SPIGOT_ICON;
    }

    @Override
    public String getId() {
        return ID;
    }

    @NotNull
    @Override
    public BukkitModule generateModule(Module module) {
        return new BukkitModule<>(module, this);
    }
}
