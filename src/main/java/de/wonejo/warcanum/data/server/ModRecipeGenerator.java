package de.wonejo.warcanum.data.server;

import de.wonejo.warcanum.core.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class ModRecipeGenerator extends RecipeProvider {

    public ModRecipeGenerator(PackOutput pOutput) {
        super(pOutput);
    }

    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GHOSTLY_ARMOR_HELMET.get())
                .pattern("###")
                .pattern("#$#")
                .define('#', ModItems.GHOSTLY_PLASMA.get())
                .define('$', Items.IRON_INGOT)
                .unlockedBy("has_item", has(ModItems.GHOSTLY_PLASMA.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GHOSTLY_ARMOR_CHESTPLATE.get())
                .pattern("# #")
                .pattern("#$#")
                .pattern("###")
                .define('#', ModItems.GHOSTLY_PLASMA.get())
                .define('$', Items.IRON_INGOT)
                .unlockedBy("has_item", has(ModItems.GHOSTLY_PLASMA.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GHOSTLY_ARMOR_LEGGINGS.get())
                .pattern("#$#")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.GHOSTLY_PLASMA.get())
                .define('$', Items.IRON_INGOT)
                .unlockedBy("has_item", has(ModItems.GHOSTLY_PLASMA.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.GHOSTLY_ARMOR_BOOTS.get())
                .pattern("#$#")
                .pattern("# #")
                .define('#', ModItems.GHOSTLY_PLASMA.get())
                .define('$', Items.IRON_INGOT)
                .unlockedBy("has_item", has(ModItems.GHOSTLY_PLASMA.get()))
                .save(pRecipeOutput);
    }
}
