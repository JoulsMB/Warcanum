package de.wonejo.warcanum.data.provider;

import de.wonejo.warcanum.util.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

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

    protected ItemModelBuilder spawnEgg (SpawnEggItem pSpawnEgg) {
        return this.withExistingParent(BuiltInRegistries.ITEM.getKey(pSpawnEgg).getPath(), "minecraft:item/template_spawn_egg");
    }

}
