package net.kiwi.intro_mod.item;

import net.kiwi.intro_mod.IntroMod;
import net.kiwi.intro_mod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS=
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IntroMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MOD_TABS.register("mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                    .title(Component.translatable("creative_tab.mod_tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModItems.ALEXANDRITE.get());
                        output.accept(ModItems.RAW_ALEXANDRITE.get());
                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModItems.KOHLRABI.get());
                        output.accept(ModItems.PEAT_BRICK.get());

                        output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.SOUND_BLOCK.get());

                        output.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.END_STONE_ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.NETHER_ALEXANDRITE_ORE.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
