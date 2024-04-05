package de.wonejo.warcanum.data;

import de.wonejo.warcanum.data.client.ModBlockStateGenerator;
import de.wonejo.warcanum.data.client.ModItemGenerator;
import de.wonejo.warcanum.lib.util.Constants;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Constants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerator {

    public static void onGatherData (GatherDataEvent pEvent) {
        DataGenerator generator = pEvent.getGenerator();
        ExistingFileHelper existingFileHelper = pEvent.getExistingFileHelper();
        PackOutput packOutput = pEvent.getGenerator().getPackOutput();

        generator.addProvider(pEvent.includeClient(), new ModItemGenerator(packOutput, existingFileHelper));
        generator.addProvider(pEvent.includeClient(), new ModBlockStateGenerator(packOutput, existingFileHelper));

    }
}
