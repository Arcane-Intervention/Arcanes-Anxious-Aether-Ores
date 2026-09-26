package io.github.arcane_intervention.anxiousaetherores.datagen;

import java.util.Set;

import io.github.arcane_intervention.anxiousaetherores.registry.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

public class ModBlockLootProvider extends BlockLootSubProvider {
	
	public ModBlockLootProvider(HolderLookup.Provider lookupProvider) {
		super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
	}
	
	@Override
	protected void generate() {
		this.add(ModBlocks.HOLYSTONE_IRON_ORE.get(),
				block -> createOreDrop(block, Items.RAW_IRON));
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModBlocks.BLOCKS.getEntries()
				.stream()
				.map(Holder::value)
				.toList();
	}
}