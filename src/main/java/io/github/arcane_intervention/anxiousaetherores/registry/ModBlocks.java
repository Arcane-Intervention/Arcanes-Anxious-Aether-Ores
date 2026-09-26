package io.github.arcane_intervention.anxiousaetherores.registry;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

	public static final DeferredRegister.Blocks BLOCKS = 
			DeferredRegister.createBlocks(ArcanesAnxiousAetherOres.MODID);
			
	public static final DeferredBlock<Block> HOLYSTONE_IRON_ORE =
			BLOCKS.registerBlock(
					"holystone_iron_ore",
					properties -> new DropExperienceBlock(
							ConstantInt.ZERO,
							properties
							),
					() -> BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
					);
}