package de.wonejo.warcanum.data.client;

import de.wonejo.warcanum.core.ModBlocks;
import de.wonejo.warcanum.core.ModItems;
import de.wonejo.warcanum.data.provider.BaseItemModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.HashSet;
import java.util.Set;

public class ModItemGenerator extends BaseItemModelProvider {

    public ModItemGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, existingFileHelper);
    }

    protected void registerModels() {
        Set<Block> blocks = new HashSet<>(){{
         this.add(ModBlocks.DEAD_LOG.get());
         this.add(ModBlocks.DEAD_LOG_WOOD.get());
         this.add(ModBlocks.STRIPPED_DEAD_LOG.get());
         this.add(ModBlocks.STRIPPED_DEAD_LOG_WOOD.get());
         this.add(ModBlocks.DEAD_WOOD_PLANKS.get());
         this.add(ModBlocks.DEAD_WOOD_SLAB.get());
         this.add(ModBlocks.INFERTILE_DIRT.get());
        }};

        ModItems.getTabItems().stream().filter(item -> item.get() instanceof SpawnEggItem).forEach((item) -> this.spawnEgg((SpawnEggItem) item.get()));

        this.item(ModItems.GHOST_PLASMA.get());

        this.item(ModItems.IRON_KEY.get());
        this.item(ModItems.GOLDEN_KEY.get());
        this.item(ModItems.SPECTRAL_KEY.get());

        blocks.forEach(this::block);
    }
}
