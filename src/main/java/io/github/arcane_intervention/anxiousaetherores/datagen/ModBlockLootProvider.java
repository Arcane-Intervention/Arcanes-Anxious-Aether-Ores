package io.github.arcane_intervention.anxiousaetherores.datagen;

import java.util.Set;

import io.github.arcane_intervention.anxiousaetherores.registry.ModBlocks;
import io.github.arcane_intervention.anxiousaetherores.registry.ModOres;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;

public class ModBlockLootProvider extends BlockLootSubProvider {
	
	public ModBlockLootProvider(HolderLookup.Provider lookupProvider) {
		super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
	}
	
	public LootTable.Builder standardOreLoot(OreDefinition ore, Block block) {

	    var enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

	    return this.createSilkTouchDispatchTable(
	            block,
	            this.applyExplosionDecay(
	                    block,
	                    LootItem.lootTableItem(ore.dropItem)
	                            .apply(SetItemCountFunction.setCount(ore.dropCount))
	                            .apply(ApplyBonusCount.addOreBonusCount(
	                                    enchantments.getOrThrow(Enchantments.FORTUNE)
	                            ))
	            )
	    );
	}
	
	@Override
	protected void generate() {
	    for (OreDefinition ore : ModOres.ORES) {

	        for (OreDefinition.Variant variant : ore.variants) {

	            Block block = variant.oreBlock().get();

	            this.add(
	                block,
	                b -> ore.lootStrategy.build(this, ore, b)
	            );
	        }
	    }
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ModBlocks.BLOCKS.getEntries()
				.stream()
				.map(Holder::value)
				.toList();
	}
}