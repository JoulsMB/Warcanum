package de.wonejo.warcanum.data.server;

import de.wonejo.warcanum.core.ModSounds;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundsGenerator extends SoundDefinitionsProvider {

    public ModSoundsGenerator(PackOutput output, ExistingFileHelper helper) {
        super(output, Constants.MOD_ID, helper);
    }

    public void registerSounds() {

    }

    private SoundDefinition.Sound warcaumSound (String pPath) {
        ResourceLocation path = new ResourceLocation(Constants.MOD_ID, pPath);
        return sound(path);
    }
}
