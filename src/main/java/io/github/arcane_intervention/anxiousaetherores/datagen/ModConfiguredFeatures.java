package io.github.arcane_intervention.anxiousaetherores.datagen;

import java.util.List;

import com.aetherteam.aetherii.AetherIITags;
import com.aetherteam.aetherii.block.AetherIIBlocks;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.registry.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

public class ModConfiguredFeatures {
	
	public static final ResourceKey<ConfiguredFeature<?, ?>> IRON_ORE = 
			ResourceKey.create(
					Registries.CONFIGURED_FEATURE, 
					Identifier.fromNamespaceAndPath(
							ArcanesAnxiousAetherOres.MODID, 
							"iron_ore"));
	
	public static void bootstrap(
			BootstrapContext<ConfiguredFeature<?, ?>> context) {
		
		var targets = List.of(
				
				OreConfiguration.target(
						new TagMatchTest(AetherIITags.Blocks.HOLYSTONE), 
						ModBlocks.HOLYSTONE_IRON_ORE
							.get()
							.defaultBlockState()
				),
				
				OreConfiguration.target(
						new BlockMatchTest(AetherIIBlocks.UNDERSHALE.get()), 
						ModBlocks.UNDERSHALE_IRON_ORE
						.get()
						.defaultBlockState()
				)
			);
		
		context.register(IRON_ORE, new ConfiguredFeature<>(
				Feature.ORE,
				new OreConfiguration(
						targets,
						9,
						0.25F)
				)
			);
	}
	
}