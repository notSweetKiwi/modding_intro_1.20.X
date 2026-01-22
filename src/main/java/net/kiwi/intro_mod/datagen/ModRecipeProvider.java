package net.kiwi.intro_mod.datagen;

import net.kiwi.intro_mod.block.ModBlocks;
import net.kiwi.intro_mod.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public static final List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(), ModBlocks.ALEXANDRITE_ORE.get(),
            ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(), ModBlocks.END_STONE_ALEXANDRITE_ORE.get(), ModBlocks.NETHER_ALEXANDRITE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy("has_alexandrite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ALEXANDRITE.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy("has_alexandrite_block", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.ALEXANDRITE_BLOCK.get()).build()))
                .save(pWriter);

        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), RecipeCategory.MISC, ModBlocks.RAW_ALEXANDRITE_BLOCK.get());

        oreSmelting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.2f, 200, "alexandrite");
        oreBlasting(pWriter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.2f, 100, "alexandrite");
    }
}
