package io.github.arcane_intervention.anxiousaetherores.datagen;

import java.util.List;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.TrapezoidHeight;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
	
	public static final ResourceKey<PlacedFeature> IRON_ORE = 
			ResourceKey.create(
					Registries.PLACED_FEATURE, 
					Identifier.fromNamespaceAndPath(
							ArcanesAnxiousAetherOres.MODID, 
							"iron_ore"));
	
	public static void bootstrap (
			BootstrapContext<PlacedFeature> context) {
		
		HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures =
			context.lookup(Registries.CONFIGURED_FEATURE);
			
		context.register(
				IRON_ORE, 
				new PlacedFeature(
						configuredFeatures.getOrThrow(
								ModConfiguredFeatures.IRON_ORE),
						List.of(
								CountPlacement.of(20),
								InSquarePlacement.spread(),
								HeightRangePlacement.of(
										TrapezoidHeight.of(
												VerticalAnchor.absolute(32),
												VerticalAnchor.absolute(192),
												32)
										),
								
								BiomeFilter.biome()
								)
						)
				);
	}
	
}