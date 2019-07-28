package com.eonzenx.modsetup.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier {
	
	// Rock variants
	GRANITE(1, 170, 5.6F, 1.2F, 7, Items.GRANITE),
	ANDESITE(1, 180, 5.3F, 1F, 7, Items.ANDESITE),
	DIORITE(1, 190, 5F, 0.8F, 7, Items.DIORITE),
	
	// Ores
	EMERALD(3, 1059, 12F, 2.3F, 17, Items.EMERALD),
	REDSTONE(1, 203, 15F, 0.2F, 3, Items.REDSTONE_BLOCK),
	LAPIS_LAZULI(2, 872, 12F, 3F, 28, Items.LAPIS_LAZULI);
	
	/*
	Harvest Lvl		Dur		Spd		Dmg		Enchant Lvl
	WOOD	0		59		2.0F	0.0F	15
	STONE	1		131		4.0F	1.0F	5
	IRON	2		250		6.0F	2.0F	14
	DIAMOND	3		1561	8.0F	3.0F	10
	GOLD	0		32		12.0F	0.0F	22
	*/
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private ToolMaterialList(int harvestLevel, int durability, float efficiency, float attackDamage, int enchantability, Item repairMaterial) {
		this.harvestLevel = harvestLevel;
		this.durability = durability;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}
	
	@Override
	public float getAttackDamage() {
		return this.attackDamage;
	}
	@Override
	public float getEfficiency() {
		return this.efficiency;
	}
	@Override
	public int getMaxUses() {
		return this.durability;
	}
	@Override
	public int getHarvestLevel() {
		return this.harvestLevel;
	}
	@Override
	public int getEnchantability() {
		return this.enchantability;
	}
	@Override
	public Ingredient getRepairMaterial() {
		return Ingredient.fromItems(this.repairMaterial);
	}
}
