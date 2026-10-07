package io.github.arcane_intervention.anxiousaetherores.registry;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeTags {

	public static final TagKey<Biome> AETHER_ORE_GENERATION = 
			TagKey.create(
					Registries.BIOME, 
					Identifier.fromNamespaceAndPath(
							ArcanesAnxiousAetherOres.MODID, 
							"aether_ore_generation")
					);
}