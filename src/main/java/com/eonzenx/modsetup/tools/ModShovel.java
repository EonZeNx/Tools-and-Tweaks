package com.eonzenx.modsetup.tools;

import com.eonzenx.tats.TATsMod;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;

public class ModShovel extends ShovelItem {
	
	public ModShovel(String registryName, IItemTier tier, float attackDamage, float attackSpeed, Properties builder) {
		super(tier, attackDamage, attackSpeed, builder.group(TATsMod.setup.tatsmoditemgroup));
		setRegistryName(registryName);
	}
}
