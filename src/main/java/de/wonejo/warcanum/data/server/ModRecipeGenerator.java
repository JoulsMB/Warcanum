package de.wonejo.warcanum.data.server;

import de.wonejo.warcanum.core.ModBlocks;
import de.wonejo.warcanum.core.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import org.jetbrains.annotations.NotNull;

public class ModRecipeGenerator extends RecipeProvider {

    public ModRecipeGenerator(PackOutput pOutput) {
        super(pOutput);
    }

    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        this.buildShapedRecipes(pRecipeOutput);
        this.buildShapelessRecipes(pRecipeOutput);
    }

    private void buildShapelessRecipes ( RecipeOutput pOutput ) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEAD_WOOD_PLANKS.get(), 4)
                .requires(ModTags.ItemTags.DEAD_LOGS)
                .unlockedBy("has_item", has(ModBlocks.DEAD_LOG.get()))
                .save(pOutput);
    }

    private void buildShapedRecipes ( RecipeOutput pOutput ) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEAD_LOG_WOOD.get())
                .pattern("##").pattern("##")
                .define('#', ModBlocks.DEAD_LOG.get())
                .unlockedBy("has_item", has(ModBlocks.DEAD_LOG.get())).save(pOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_DEAD_LOG_WOOD.get())
                .pattern("##").pattern("##")
                .define('#', ModBlocks.STRIPPED_DEAD_LOG.get())
                .unlockedBy("has_item", has(ModBlocks.STRIPPED_DEAD_LOG.get())).save(pOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEAD_WOOD_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModBlocks.DEAD_WOOD_PLANKS.get())
                .unlockedBy("has_item", has(ModBlocks.DEAD_WOOD_PLANKS.get())).save(pOutput);
    }
}
