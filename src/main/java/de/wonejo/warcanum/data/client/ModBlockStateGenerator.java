package de.wonejo.warcanum.data.client;

import de.wonejo.warcanum.lib.util.Constants;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateGenerator extends BlockStateProvider {

    public ModBlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Constants.MOD_ID, exFileHelper);
    }

    protected void registerStatesAndModels() {

    }
}
