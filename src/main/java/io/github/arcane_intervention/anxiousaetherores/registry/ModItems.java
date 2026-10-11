package io.github.arcane_intervention.anxiousaetherores.registry;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.datagen.OreDefinition;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(
                    ArcanesAnxiousAetherOres.MODID
            );

    static {

        for (OreDefinition ore : ModOres.ORES) {

            for (OreDefinition.Variant variant : ore.variants) {

                ITEMS.registerSimpleBlockItem(
                        variant.oreBlock()
                );
            }
        }
    }
}