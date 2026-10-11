package io.github.arcane_intervention.anxiousaetherores.datagen;

import java.util.List;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.registry.ModOres;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.TrapezoidHeight;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;


public class ModPlacedFeatures {

    public static ResourceKey<PlacedFeature> key(OreDefinition ore) {

        return ResourceKey.create(
                Registries.PLACED_FEATURE,
                Identifier.fromNamespaceAndPath(
                        ArcanesAnxiousAetherOres.MODID,
                        ore.oreType + "_ore"
                )
        );
    }

    public static void bootstrap(
            BootstrapContext<PlacedFeature> context) {

        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures =
                context.lookup(Registries.CONFIGURED_FEATURE);

        for (OreDefinition ore : ModOres.ORES) {

            context.register(
                    key(ore),
                    new PlacedFeature(
                            configuredFeatures.getOrThrow(
                                    ModConfiguredFeatures.key(ore)
                            ),
                            List.of(
                                    CountPlacement.of(ore.attemptsPerChunk),
                                    InSquarePlacement.spread(),
                                    HeightRangePlacement.of(
                                            TrapezoidHeight.of(
                                                    ore.minHeight,
                                                    ore.maxHeight,
                                                    ore.plateau
                                            )
                                    ),
                                    BiomeFilter.biome()
                            )
                    )
            );
        }
    }
}