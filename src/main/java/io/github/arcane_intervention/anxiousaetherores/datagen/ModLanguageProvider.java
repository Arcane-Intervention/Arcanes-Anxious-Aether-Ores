package io.github.arcane_intervention.anxiousaetherores.datagen;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
	
	public ModLanguageProvider(PackOutput output) {
		super(output, ArcanesAnxiousAetherOres.MODID, "en_us");
	}
	
	@Override
	protected void addTranslations() {
		this.addBlock(ModBlocks.HOLYSTONE_IRON_ORE, "Holystone Iron Ore");
		this.addBlock(ModBlocks.UNDERSHALE_IRON_ORE, "Undershale Iron Ore");
	}
}
	