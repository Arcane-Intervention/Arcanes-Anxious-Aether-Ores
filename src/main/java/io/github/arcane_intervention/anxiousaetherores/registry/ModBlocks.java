package io.github.arcane_intervention.anxiousaetherores.registry;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

	public static final DeferredRegister.Blocks BLOCKS = 
			DeferredRegister.createBlocks(ArcanesAnxiousAetherOres.MODID);
			
	public static final DeferredBlock<Block> HOLYSTONE_IRON_ORE =
			BLOCKS.registerSimpleBlock(
					"holystone_iron_ore",
					() -> BlockBehaviour.Properties.of()
						.destroyTime(3.0F)
						.explosionResistance(3.0F)
					);
}