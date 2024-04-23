package de.wonejo.warcanum.data;

import de.wonejo.warcanum.data.client.ModBlockStateGenerator;
import de.wonejo.warcanum.data.client.ModItemGenerator;
import de.wonejo.warcanum.data.server.ModLootDataGenerator;
import de.wonejo.warcanum.data.server.ModRecipeGenerator;
import de.wonejo.warcanum.data.server.ModSoundsGenerator;
import de.wonejo.warcanum.data.server.ModTagGenerator;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {

    @SubscribeEvent
    public static void onGatherData (GatherDataEvent pEvent) {
        DataGenerator generator = pEvent.getGenerator();
        PackOutput packOutput = pEvent.getGenerator().getPackOutput();
        ExistingFileHelper existingFileHelper = pEvent.getExistingFileHelper();

        generator.addProvider(pEvent.includeClient(), new ModItemGenerator(packOutput, existingFileHelper));
        generator.addProvider(pEvent.includeClient(), new ModBlockStateGenerator(packOutput, existingFileHelper));
        generator.addProvider(pEvent.includeClient(), new ModSoundsGenerator(packOutput, existingFileHelper));

        generator.addProvider(pEvent.includeServer(), new ModRecipeGenerator(packOutput));
        generator.addProvider(pEvent.includeServer(), ModLootDataGenerator.generateProviders(packOutput));

        ModTagGenerator.generateTagsProvider(pEvent, generator, packOutput, existingFileHelper);
    }

}
