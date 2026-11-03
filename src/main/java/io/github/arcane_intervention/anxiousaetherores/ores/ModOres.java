package io.github.arcane_intervention.anxiousaetherores.ores;

import com.aetherteam.aetherii.AetherIITags;
import com.aetherteam.aetherii.block.AetherIIBlocks;

import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

// Creates OreDefinition Objects, each object defines one type of ore (e.g. Iron, Copper, Diamond) and all of its variants for datagen
// TLDR, add new ores here - the only other thing you need to do is include a blocktexture.

public class ModOres {
	
	public static final OreDefinition[] ORES = {
	
			new OreDefinition(
					"iron",
					Blocks.IRON_ORE,
					() -> Items.RAW_IRON,
					BlockTags.NEEDS_STONE_TOOL,
					new OreDefinition.Variant[] {
							new OreDefinition.Variant(
									"holystone",
									() -> new TagMatchTest(AetherIITags.Blocks.HOLYSTONE)),
					
							new OreDefinition.Variant(
									"undershale",
									() -> new BlockMatchTest(AetherIIBlocks.UNDERSHALE.get())
								)
							}
						),
			
			new OreDefinition (
					"copper",
					Blocks.COPPER_ORE,
					() -> Items.RAW_COPPER,
					BlockTags.NEEDS_STONE_TOOL,
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
			.dropCount(UniformGenerator.between(2, 5)),
			
			new OreDefinition (
					"coal",
					Blocks.COAL_ORE,
					() -> Items.COAL,
					null,
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
			.experience(UniformInt.of(0, 2)),
			
			new OreDefinition (
					"gold",
					Blocks.GOLD_ORE,
					() -> Items.RAW_GOLD,
					BlockTags.NEEDS_IRON_TOOL,
					new OreDefinition.Variant[] {
							new OreDefinition.Variant(
									"holystone", 
									() -> new TagMatchTest(AetherIITags.Blocks.HOLYSTONE)),
							
							new OreDefinition.Variant(
									"undershale", 
									() -> new BlockMatchTest(AetherIIBlocks.UNDERSHALE.get())
									)
					}
				),
			
			new OreDefinition (
					"lapis",
					Blocks.LAPIS_ORE,
					() -> Items.LAPIS_LAZULI,
					BlockTags.NEEDS_STONE_TOOL,
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
			.dropCount(UniformGenerator.between(4, 9))
			.experience(UniformInt.of(2, 5)),
			
			new OreDefinition (
					"diamond",
					Blocks.DIAMOND_ORE,
					() -> Items.DIAMOND,
					BlockTags.NEEDS_IRON_TOOL,
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
			.experience(UniformInt.of(3, 7)),
			
			new OreDefinition (
					"emerald",
					Blocks.EMERALD_ORE,
					() -> Items.EMERALD,
					BlockTags.NEEDS_IRON_TOOL,
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
			.experience(UniformInt.of(3, 7)),
			
// WARNING: Redstone is not fully implemented, this block does not demonstrate vanilla fortune behaviour or in-world emission mechanics.
			
			new OreDefinition (
					"redstone",
					Blocks.IRON_ORE,	//Used as a sub for Redstone Ore until I figure out what to do about exceptions. 
					() -> Items.REDSTONE,
					BlockTags.NEEDS_IRON_TOOL,
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
			.dropCount(UniformGenerator.between(4, 5))
			.experience(UniformInt.of(1, 5)),
			
		};
}