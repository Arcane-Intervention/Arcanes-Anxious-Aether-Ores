package io.github.arcane_intervention.anxiousaetherores.ores;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import io.github.arcane_intervention.anxiousaetherores.datagen.ModBlockLootProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.NumberProvider;
import net.neoforged.neoforge.registries.DeferredBlock;

// In theory maybe all of these should be final but I cannot be fucked working around that,
// if you change these after datagen they're not doing to do anything.
// Don't try using these for anything other their intended purpose. 

public class OreDefinition {
	// Block Definitions
	public final String oreType; // Ore type (e.g. iron, diamond, uranium, etc
	public List<TagKey<Block>> oreTags = List.of();
	public final Block sourceBlock; // Supply a block to copy the block properties of for in world behaviour (blast resistance, mining speed, etc) - I should probably add overrides for this
	

	public static class Variant {

	    private final String name; 
	    private final Supplier<RuleTest> targetRule; 
	    private DeferredBlock<Block> oreBlock; 

	    public Variant(String name, Supplier<RuleTest> targetRule) { 
	        this.name = name;
	        this.targetRule = targetRule;
	    }

	    public String name() { // Variant name, use the name of the base block to "replace" (e.g. holystone for holystone iron ore, undershale for undershale iron ore) - doesnt impact targeting
	        return name;
	    }

	    public Supplier<RuleTest> targetRule() { // Per-ore-variant target rule (e.g. target all blocks tagged holystone for the holystone variant)
	        return targetRule;
	    }

	    public DeferredBlock<Block> oreBlock() {
	        if (oreBlock == null) {
	            throw new IllegalStateException(
	                    "Ore variant has not been registered: " + name
	            );
	        }
	        return oreBlock;
	    }

	    public void bindBlock(DeferredBlock<Block> block) {
	        if (this.oreBlock != null) {
	            throw new IllegalStateException(
	                    "Ore variant already registered: " + name
	            );
	        }
	        this.oreBlock = Objects.requireNonNull(block);
	    }
	}

	public final Variant[] variants;
	
	// Loot
	@FunctionalInterface
	public interface LootStrategy {
	    LootTable.Builder build(
	            ModBlockLootProvider provider,
	            OreDefinition ore,
	            Block block
	    );
	}
	public Item dropItem; // Item to drop when broken with correct tool, unless silktouch is used
	public NumberProvider dropCount = ConstantValue.exactly(1); // Base value for the amount of the above item to drop - modified by fortune based on LootStrategy
	public LootStrategy lootStrategy = (provider, ore, block) -> {

	    if (ore.dropItem == null) {
	        return LootTable.lootTable();
	    }

	    return provider.standardOreLoot(ore, block);
	};
	public IntProvider experience = ConstantInt.of(0); // Amount of XP to drop when the block is broken with the correct tool
	
	public TagKey<Block> requiredToolTag; // Block tag(s) detailing the tier of tool required, normally using REQUIRES_XXX_TOOL helpers instead of a slew of "not suitable for X" tags
										  // Pickaxe (or other) requirement tag is already applied based on the supplier block
	
	// Generation
	public int veinSize = 9;
	public float discardChance = 0.25F;
	public IntProvider attemptsPerChunk = ConstantInt.of(20);
	public VerticalAnchor minHeight = VerticalAnchor.absolute(32);
	public VerticalAnchor maxHeight = VerticalAnchor.absolute(192);
	public int plateau = 32;
	
	// Constructor
	public OreDefinition(String oreType, Block sourceBlock, Item dropItem, TagKey<Block> requiredToolTag, Variant[] variants) {
			this.oreType = oreType;
			this.sourceBlock = sourceBlock;
			this.dropItem = dropItem;
			this.requiredToolTag = requiredToolTag;
			this.variants = variants.clone();
	}
	
	// Overwrite methods

	public OreDefinition drop(Item item) {
	    this.dropItem = item;
	    return this;
	}

	public OreDefinition dropCount(NumberProvider count) {
	    this.dropCount = count;
	    return this;
	}

	public OreDefinition lootStrategy(LootStrategy strategy) {
	    this.lootStrategy = strategy;
	    return this;
	}

	public OreDefinition experience(IntProvider experience) {
	    this.experience = experience;
	    return this;
	}


	public OreDefinition toolTag(TagKey<Block> tag) {
	    this.requiredToolTag = tag;
	    return this;
	}

	public OreDefinition oreTags(List<TagKey<Block>> tags) {
	    this.oreTags = List.copyOf(tags);
	    return this;
	}


	public OreDefinition veinSize(int size) {
	    this.veinSize = size;
	    return this;
	}

	public OreDefinition discardChance(float chance) {
	    this.discardChance = chance;
	    return this;
	}

	public OreDefinition attemptsPerChunk(IntProvider attempts) {
	    this.attemptsPerChunk = attempts;
	    return this;
	}

	public OreDefinition heightRange(
	        VerticalAnchor minimum,
	        VerticalAnchor maximum,
	        int plateau) {

	    this.minHeight = minimum;
	    this.maxHeight = maximum;
	    this.plateau = plateau;
	    return this;
	}
}