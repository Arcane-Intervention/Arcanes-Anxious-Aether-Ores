package io.github.arcane_intervention.anxiousaetherores.datagen;

import java.util.ArrayList;
import java.util.List;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.registry.ModOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ModConfiguredFeatures {

    public static ResourceKey<ConfiguredFeature<?, ?>> key(OreDefinition ore) {

        return ResourceKey.create(
                Registries.CONFIGURED_FEATURE,
                Identifier.fromNamespaceAndPath(
                        ArcanesAnxiousAetherOres.MODID,
                        ore.oreType + "_ore"
                )
        );
    }

    public static void bootstrap(
            BootstrapContext<ConfiguredFeature<?, ?>> context) {

        for (OreDefinition ore : ModOres.ORES) {

            List<OreConfiguration.TargetBlockState> targets =
                    new ArrayList<>();

            for (OreDefinition.Variant variant : ore.variants) {

                targets.add(
                        OreConfiguration.target(
                                variant.targetRule().get(),
                                variant.oreBlock().get().defaultBlockState()
                        )
                );
            }

            context.register(
                    key(ore),
                    new ConfiguredFeature<>(
                            Feature.ORE,
                            new OreConfiguration(
                                    targets,
                                    ore.veinSize,
                                    ore.discardChance
                            )
                    )
            );
        }
    }
}