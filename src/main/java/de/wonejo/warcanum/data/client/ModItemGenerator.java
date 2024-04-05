package de.wonejo.warcanum.data.client;

import de.wonejo.warcanum.lib.data.BaseItemModelProvider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemGenerator extends BaseItemModelProvider {

    public ModItemGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, existingFileHelper);
    }

    protected void registerModels() {

    }
}
