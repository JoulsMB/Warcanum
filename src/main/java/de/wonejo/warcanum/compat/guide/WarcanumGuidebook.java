package de.wonejo.warcanum.compat.guide;

import de.wonejo.gapi.api.GuidebookAPI;
import de.wonejo.gapi.api.IGuidebook;
import de.wonejo.gapi.api.book.IBookBuilder;
import de.wonejo.gapi.api.book.components.IBookCategory;
import de.wonejo.gapi.api.impl.book.BookBuilder;
import de.wonejo.gapi.api.impl.book.BookInformationBuilder;
import de.wonejo.warcanum.lib.util.Constants;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

@GuidebookAPI
public final class WarcanumGuidebook implements IGuidebook {

    public IBookBuilder build() {
        return BookBuilder.of(new ResourceLocation(Constants.MOD_ID, "warcanum_guide"))
                .spawnWithBook()
                .information(BookInformationBuilder.of()
                        .title(Component.translatable("guide.warcanum.information.title"))
                        .description(Component.translatable("guide.warcanum.information.description"))
                        .credits(Component.translatable("guide.warcanum.information.credits"))
                        .modName(Component.literal("Warcanum"))
                        .build()
                ).itemName(Component.translatable("guide.warcanum.item.name"))
                .header(Component.translatable("guide.warcanum.header"))
                .author(Component.translatable("guide.warcanum.author"))
                .contentProvider(this::contentBuilder);
    }

    private void contentBuilder(List<IBookCategory> pBookCategories) {

    }

}
