package io.github.arcane_intervention.anxiousaetherores.datagen;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.registry.ModBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
	
	public ModModelProvider(PackOutput output) {
		super(output, ArcanesAnxiousAetherOres.MODID);	
	}
	
	@Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
		
		blockModels.createTrivialCube(ModBlocks.HOLYSTONE_IRON_ORE.get());
		blockModels.createTrivialCube(ModBlocks.UNDERSHALE_IRON_ORE.get());
	}
}