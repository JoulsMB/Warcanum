package de.wonejo.warcanum.data.provider;

import de.wonejo.warcanum.util.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public abstract class BaseItemModelProvider extends ItemModelProvider {

    public BaseItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Constants.MOD_ID, existingFileHelper);
    }

    protected abstract void registerModels();

    public void spawnEgg (SpawnEggItem pItem) {
        this.withExistingParent(BuiltInRegistries.ITEM.getKey(pItem).getPath(), "minecraft:template_spawn_egg");
    }

    public ItemModelBuilder block(Block name) {
        return block(name, BuiltInRegistries.BLOCK.getKey(name).getPath());
    }

    public ItemModelBuilder block(Block name, String path) {
        try {
            return super.withExistingParent(BuiltInRegistries.BLOCK.getKey(name).getPath(), this.modid + ":block/" + path);
        } catch (IllegalStateException e) {
            return getBuilder(BuiltInRegistries.BLOCK.getKey(name).getPath()).parent(new ModelFile.UncheckedModelFile(this.modid + ":block/" + path));
        }
    }

    @NotNull
    @Override
    public String getName() {
        return this.modid + " Item Models";
    }

    public ItemModelBuilder item(Item item) {
        return withExistingParent(item, mcLoc("item/generated")).texture("layer0", this.modid + ":item/" + BuiltInRegistries.ITEM.getKey(item).getPath());
    }

    public ItemModelBuilder item(Item item, ResourceLocation... texture) {
        return item(BuiltInRegistries.ITEM.getKey(item).getPath(), texture);
    }

    public ItemModelBuilder item(String item, ResourceLocation @NotNull... texture) {
        ItemModelBuilder model = withExistingParent(item, mcLoc("item/generated"));
        for (int i = 0; i < texture.length; i++) {
            model.texture("layer" + i, texture[i]);
        }
        return model;
    }

    @NotNull
    public ItemModelBuilder withExistingParent(Item name, Item parent) {
        return this.withExistingParent(name, BuiltInRegistries.ITEM.getKey(parent));
    }

    @NotNull
    public ItemModelBuilder withExistingParent(Block name, ResourceLocation parent) {
        return super.withExistingParent(BuiltInRegistries.BLOCK.getKey(name).getPath(), parent);
    }

    @NotNull
    public ItemModelBuilder withExistingParent(Item name, ResourceLocation parent) {
        return super.withExistingParent(BuiltInRegistries.ITEM.getKey(name).getPath(), parent);
    }

}
