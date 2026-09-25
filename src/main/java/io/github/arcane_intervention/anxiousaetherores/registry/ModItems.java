package io.github.arcane_intervention.anxiousaetherores.registry;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

	public static final DeferredRegister.Items ITEMS = 
			DeferredRegister.Items.createItems(ArcanesAnxiousAetherOres.MODID);
	
	public static final DeferredItem<BlockItem> HOLYSTONE_IRON_ORE_ITEM = 
			ITEMS.registerSimpleBlockItem(
					ModBlocks.HOLYSTONE_IRON_ORE);
			
}