package io.github.arcane_intervention.anxiousaetherores.datagen;

import java.util.concurrent.CompletableFuture;

import com.aetherteam.aetherii.AetherIITags;
import com.aetherteam.aetherii.data.resources.registries.holyisles.HolyIslesBiomes;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.registry.ModBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;

public class ModBiomeTagsProvider extends BiomeTagsProvider {
	
	public ModBiomeTagsProvider(
	        PackOutput output,
	        CompletableFuture<HolderLookup.Provider> lookupProvider) {

	    super(
	            output,
	            lookupProvider,
	            ArcanesAnxiousAetherOres.MODID
	    );
	}
	
	@Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
	    this.tag(ModBiomeTags.AETHER_ORE_GENERATION)
        	.addTag(AetherIITags.Biomes.THE_AETHER)
        	.add(HolyIslesBiomes.HESTVEIL_CAVERNS);
    }
	
}