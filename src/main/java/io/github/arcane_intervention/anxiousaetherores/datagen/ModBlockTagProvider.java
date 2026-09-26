package io.github.arcane_intervention.anxiousaetherores.datagen;

import java.util.concurrent.CompletableFuture;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

public class ModBlockTagProvider extends BlockTagsProvider {
	
	public ModBlockTagProvider(
			PackOutput output,
			CompletableFuture<HolderLookup.Provider> lookupProvider) {
		
		super(output, lookupProvider, ArcanesAnxiousAetherOres.MODID);
	}
	
	@Override
	protected void addTags(HolderLookup.Provider lookupProvider) {
		
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(ModBlocks.HOLYSTONE_IRON_ORE.get());
		
		this.tag(BlockTags.NEEDS_STONE_TOOL)
				.add(ModBlocks.HOLYSTONE_IRON_ORE.get());
	}
}