package io.github.arcane_intervention.anxiousaetherores.datagen;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.registry.ModBiomeTags;
import io.github.arcane_intervention.anxiousaetherores.registry.ModOres;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {

    public static void bootstrap(
            BootstrapContext<BiomeModifier> context) {

        HolderGetter<Biome> biomes =
                context.lookup(Registries.BIOME);

        HolderGetter<PlacedFeature> placedFeatures =
                context.lookup(Registries.PLACED_FEATURE);

        for (OreDefinition ore : ModOres.ORES) {

            ResourceKey<BiomeModifier> key = ResourceKey.create(
                    NeoForgeRegistries.Keys.BIOME_MODIFIERS,
                    Identifier.fromNamespaceAndPath(
                            ArcanesAnxiousAetherOres.MODID,
                            "add_" + ore.oreType + "_ore"
                    )
            );

            context.register(
                    key,
                    new AddFeaturesBiomeModifier(
                            biomes.getOrThrow(
                                    ModBiomeTags.AETHER_ORE_GENERATION
                            ),
                            HolderSet.direct(
                                    placedFeatures.getOrThrow(
                                            ModPlacedFeatures.key(ore)
                                    )
                            ),
                            GenerationStep.Decoration.UNDERGROUND_ORES
                    )
            );
        }
    }
}