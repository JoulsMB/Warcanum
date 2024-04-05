package de.wonejo.warcanum.lib.data;

import de.wonejo.warcanum.lib.util.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public abstract class BaseItemModelProvider extends ItemModelProvider {

    public BaseItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Constants.MOD_ID, existingFileHelper);
    }

    protected abstract void registerModels();

    protected ItemModelBuilder block (Block pBlock) {
        return this.withExistingParent(
                BuiltInRegistries.BLOCK.getKey(pBlock).getPath(),
                BuiltInRegistries.BLOCK.getKey(pBlock).getNamespace() + ":block/" + BuiltInRegistries.BLOCK.getKey(pBlock).getPath());
    }

}
