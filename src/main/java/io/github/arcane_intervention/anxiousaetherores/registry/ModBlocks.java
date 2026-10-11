package io.github.arcane_intervention.anxiousaetherores.registry;

import java.util.Locale;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.datagen.OreDefinition;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;


// As with the variants in OreDefinition.java, I simply pretend I do not see it
public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(
                    ArcanesAnxiousAetherOres.MODID
            );

    static {

        for (OreDefinition ore : ModOres.ORES) {

            for (OreDefinition.Variant variant : ore.variants) {

            	String blockName =
            	        (variant.name() + "_" + ore.oreType + "_ore")
            	                .toLowerCase(Locale.ROOT);

                DeferredBlock<Block> registeredBlock =
                        BLOCKS.registerBlock(
                                blockName,
                                properties -> new DropExperienceBlock(
                                        ore.experience,
                                        properties
                                ),
                                () -> BlockBehaviour.Properties.ofFullCopy(
                                        ore.sourceBlock
                                )
                        );

                variant.bindBlock(registeredBlock);
            }
        }
    }
}