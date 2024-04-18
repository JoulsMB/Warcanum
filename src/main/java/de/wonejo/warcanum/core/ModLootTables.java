package de.wonejo.warcanum.core;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import de.wonejo.warcanum.util.Constants;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModLootTables {

    private static final Set<ResourceLocation> LOOT_TABLES = Sets.newHashSet();

    private static @NotNull ResourceLocation register ( @NotNull String pName ) {
        return register(new ResourceLocation(Constants.MOD_ID, pName));
    }

    private static @NotNull ResourceLocation register ( @NotNull ResourceLocation pResourceLocation ) {
        LOOT_TABLES.add(pResourceLocation);
        return pResourceLocation;
    }

    public static @NotNull Set<ResourceLocation> getLootTables () {
        return ImmutableSet.copyOf(LOOT_TABLES);
    }
}
