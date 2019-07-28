package com.eonzenx.modsetup.tools;

import com.eonzenx.tats.TATsMod;

import net.minecraft.item.IItemTier;
import net.minecraft.item.PickaxeItem;

public class ModPickaxe extends PickaxeItem {
	
	public ModPickaxe(String registryName, IItemTier tier, int attackDamage, float attackSpeed, Properties builder) {
		super(tier, attackDamage, attackSpeed, builder.group(TATsMod.setup.tatsmoditemgroup));
		setRegistryName(registryName);
	}
}
