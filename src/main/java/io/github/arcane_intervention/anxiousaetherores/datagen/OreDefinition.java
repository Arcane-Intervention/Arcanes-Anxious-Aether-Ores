package io.github.arcane_intervention.anxiousaetherores.datagen;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

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
	public final String oreType;
	public List<TagKey<Block>> oreTags = List.of();
	public final Block sourceBlock;
	
	// Full disclosure this update of Variant to allow registration from ModOres.java is vibecoded and I do NOT understand it well enough.
	public static class Variant {

	    private final String name;
	    private final Supplier<RuleTest> targetRule;
	    private DeferredBlock<Block> oreBlock;

	    public Variant(String name, Supplier<RuleTest> targetRule) {
	        this.name = name;
	        this.targetRule = targetRule;
	    }

	    public String name() {
	        return name;
	    }

	    public Supplier<RuleTest> targetRule() {
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
	// I mostly understand things again from below this line. Mostly.
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
	public Item dropItem;
	public NumberProvider dropCount = ConstantValue.exactly(1);
	public LootStrategy lootStrategy = (provider, ore, block) -> {

	    if (ore.dropItem == null) {
	        return LootTable.lootTable();
	    }

	    return provider.standardOreLoot(ore, block);
	};
	public IntProvider experience = ConstantInt.of(0);
	
	public TagKey<Block> requiredToolTag;
	
	// Generation
	public int veinSize = 9;
	public float discardChance = 0.25F;
	public IntProvider attemptsPerChunk = ConstantInt.of(20);
	public VerticalAnchor minHeight = VerticalAnchor.absolute(32);
	public VerticalAnchor maxHeight = VerticalAnchor.absolute(192);
	public int plateau = 32;
	
	// Constructor
	public OreDefinition(String oreType, Block sourceBlock, Variant[] variants) {
			this.oreType = oreType;
			this.sourceBlock = sourceBlock;
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

// You see, its a mess because I dont know what I'm doing :)'