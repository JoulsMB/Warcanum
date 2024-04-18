package de.wonejo.warcanum.data.client;

import de.wonejo.warcanum.core.ModBlocks;
import de.wonejo.warcanum.core.ModItems;
import de.wonejo.warcanum.data.provider.BaseItemModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.SpawnEggItem;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemGenerator extends BaseItemModelProvider {

    public ModItemGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, existingFileHelper);
    }

    protected void registerModels() {
        ModItems.getTabItems().stream().filter(item -> item.get() instanceof SpawnEggItem).forEach((item) -> this.spawnEgg((SpawnEggItem) item.get()));

        basicItem(ModItems.GHOSTLY_PLASMA.get());
        basicItem(ModItems.GHOSTLY_ARMOR_HELMET.get());
        basicItem(ModItems.GHOSTLY_ARMOR_CHESTPLATE.get());
        basicItem(ModItems.GHOSTLY_ARMOR_LEGGINGS.get());
        basicItem(ModItems.GHOSTLY_ARMOR_BOOTS.get());
    }
}
