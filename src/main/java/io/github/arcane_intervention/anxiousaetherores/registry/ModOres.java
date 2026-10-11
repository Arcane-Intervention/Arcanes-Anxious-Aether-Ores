package io.github.arcane_intervention.anxiousaetherores.registry;

import com.aetherteam.aetherii.AetherIITags;
import com.aetherteam.aetherii.block.AetherIIBlocks;

import io.github.arcane_intervention.anxiousaetherores.datagen.OreDefinition;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

// Creates OreDefinition Objects, each object defines one type of ore (e.g. Iron, Copper, Diamond) and all of its variants for datagen

public class ModOres {
	
	public static final OreDefinition[] ORES = {
	
			new OreDefinition(
					"iron",
					Blocks.IRON_ORE,
					new OreDefinition.Variant[] {
							new OreDefinition.Variant(
									"holystone",
									() -> new TagMatchTest(AetherIITags.Blocks.HOLYSTONE)),
					
							new OreDefinition.Variant(
									"undershale",
									() -> new BlockMatchTest(AetherIIBlocks.UNDERSHALE.get())
								)
							}
						)			
		};
}