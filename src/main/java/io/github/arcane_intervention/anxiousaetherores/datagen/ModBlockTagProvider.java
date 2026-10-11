package io.github.arcane_intervention.anxiousaetherores.datagen;

import java.util.concurrent.CompletableFuture;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.registry.ModOres;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

public class ModBlockTagProvider extends BlockTagsProvider {
	
	public ModBlockTagProvider(
			PackOutput output,
			CompletableFuture<HolderLookup.Provider> lookupProvider) {
		
		super(output, lookupProvider, ArcanesAnxiousAetherOres.MODID);
	}
	
	@Override
	protected void addTags(HolderLookup.Provider lookupProvider) {
		
		for (OreDefinition ore : ModOres.ORES) {

	        TagKey<Block> materialOreTag = TagKey.create(
	                Registries.BLOCK,
	                Identifier.fromNamespaceAndPath(
	                        "c",
	                        "ores/" + ore.oreType)
	        );

	        for (OreDefinition.Variant variant : ore.variants) {

	            Block block = variant.oreBlock().get();

	            this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
	                    .add(block);

	            if (ore.requiredToolTag != null) {
	                this.tag(ore.requiredToolTag)
	                        .add(block);
	            }

	            this.tag(Tags.Blocks.ORES)
	                    .add(block);

	            this.tag(materialOreTag)
	                    .add(block);

	            for (TagKey<Block> tag : ore.oreTags) {
	                this.tag(tag)
	                        .add(block);
	            }
	        }
	    }
	}
}