package io.github.arcane_intervention.anxiousaetherores.datagen;

import java.util.List;
import java.util.Set;

import io.github.arcane_intervention.anxiousaetherores.ArcanesAnxiousAetherOres;
import io.github.arcane_intervention.anxiousaetherores.registry.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

	@EventBusSubscriber(
	    modid = ArcanesAnxiousAetherOres.MODID
	)

public class DataGenerators {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent.Client event) {
		event.createProvider(ModBlockTagProvider::new);
		
		event.createProvider((output, lookupProvider) -> new LootTableProvider(
                output,
                Set.of(),
                List.of(
                        new LootTableProvider.SubProviderEntry(
                                ModBlockLootProvider::new,
                                LootContextParamSets.BLOCK
                        )
                ),
                lookupProvider
        ));
	}	
}