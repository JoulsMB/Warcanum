package de.wonejo.warcanum.core;

import net.neoforged.bus.api.IEventBus;
public class WarcanumRegistryHandler {

    private final IEventBus bus;

    public WarcanumRegistryHandler ( IEventBus pBus ) {
        this.bus = pBus;
    }

    public void setupRegistries () {
        ModAdvancementsTrigger.registerAdvancementTriggers(this.bus);
        ModAttachments.registerAttachments(this.bus);
        ModEntities.registerEntities(this.bus);
        ModBlocks.registerBlocks(this.bus);
        ModItems.registerItems(this.bus);
        ModEffects.registerEffects(this.bus);
        ModPotions.registerPotions(this.bus);
        ModSounds.registerSounds(this.bus);
        ModTiles.registerTiles(this.bus);

        ModCreativeTabs.registerCreativeTabs(this.bus);
    }

}
