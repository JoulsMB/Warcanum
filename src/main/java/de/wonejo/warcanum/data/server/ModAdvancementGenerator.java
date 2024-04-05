package de.wonejo.warcanum.data.server;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementGenerator extends AdvancementProvider {

    public ModAdvancementGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper,
                List.of());
    }

    public interface AdvancementSubProvider {
        void generate (AdvancementHolder pRoot, HolderLookup.Provider pProvider, Consumer<AdvancementHolder> pConsumer);
    }
}
