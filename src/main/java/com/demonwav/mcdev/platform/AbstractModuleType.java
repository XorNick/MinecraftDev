package com.demonwav.mcdev.platform;

import com.intellij.codeInspection.ex.EntryPointsManager;
import com.intellij.codeInspection.ex.EntryPointsManagerBase;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.util.JDOMExternalizableStringList;
import org.jetbrains.annotations.NotNull;

import javax.swing.Icon;
import java.util.List;

public abstract class AbstractModuleType<T extends AbstractModule> {

    @NotNull
    private final String groupId;
    @NotNull
    private final String artifactId;

    public AbstractModuleType(@NotNull final String groupId, @NotNull final String artifactId) {
        this.groupId = groupId;
        this.artifactId = artifactId;
    }

    @NotNull
    public String getGroupId() {
        return groupId;
    }

    @NotNull
    public String getArtifactId() {
        return artifactId;
    }

    public abstract PlatformType getPlatformType();

    public abstract Icon getBigIcon();

    public abstract Icon getIcon();

    public abstract String getId();

    @NotNull
    public abstract List<String> getIgnoredAnnotations();

    @NotNull
    public abstract List<String> getListenerAnnotations();

    @NotNull
    public abstract T generateModule(Module module);

    public void performCreationSettingSetup(@NotNull Module module) {
        JDOMExternalizableStringList annotations = ((EntryPointsManagerBase) EntryPointsManager.getInstance(module.getProject())).ADDITIONAL_ANNOTATIONS;
        getIgnoredAnnotations().stream().filter(annotation -> !annotations.contains(annotation)).forEach(annotations::add);
    }
}
