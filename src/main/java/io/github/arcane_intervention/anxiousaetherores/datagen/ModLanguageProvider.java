package io.github.arcane_intervention.anxiousaetherores.datagen;

import java.util.Arrays;
import java.util.stream.Collectors;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.registry.ModOres;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
	
	public ModLanguageProvider(PackOutput output) {
		super(output, ArcanesAnxiousAetherOres.MODID, "en_us");
	}
	
	@Override
	protected void addTranslations() {

	    for (OreDefinition ore : ModOres.ORES) {

	        for (OreDefinition.Variant variant : ore.variants) {

	            String name = variant.name() + " " + ore.oreType + " Ore";

	            String displayName = Arrays.stream(name.split("_| "))
	                    .map(word -> Character.toUpperCase(word.charAt(0))
	                            + word.substring(1))
	                    .collect(Collectors.joining(" "));

	            this.addBlock(
	                    variant.oreBlock(),
	                    displayName
	            );
	        }
	    }
	}
}
	