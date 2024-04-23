package de.wonejo.warcanum.data.client;

import de.wonejo.warcanum.core.ModBlocks;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateGenerator extends BlockStateProvider {

    public ModBlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Constants.MOD_ID, exFileHelper);
    }

    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.DEAD_WOOD_PLANKS.get());
        simpleBlock(ModBlocks.INFERTILE_DIRT.get());

        logBlock(ModBlocks.DEAD_LOG.get());
        logBlock(ModBlocks.STRIPPED_DEAD_LOG.get());

        axisBlock(ModBlocks.STRIPPED_DEAD_LOG_WOOD.get(), blockTexture(ModBlocks.STRIPPED_DEAD_LOG.get()), blockTexture(ModBlocks.STRIPPED_DEAD_LOG.get()));
        axisBlock(ModBlocks.DEAD_LOG_WOOD.get(), blockTexture(ModBlocks.DEAD_LOG.get()), blockTexture(ModBlocks.DEAD_LOG.get()));

        slabBlock(ModBlocks.DEAD_WOOD_SLAB.get(), blockTexture(ModBlocks.DEAD_WOOD_PLANKS.get()), blockTexture(ModBlocks.DEAD_WOOD_PLANKS.get()));
    }

}
