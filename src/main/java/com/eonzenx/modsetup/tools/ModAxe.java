package com.eonzenx.modsetup.tools;

import com.eonzenx.tats.TATsMod;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;

public class ModAxe extends AxeItem {
	
	public ModAxe(String registryName, IItemTier tier, float attackDamage, float attackSpeed, Properties builder) {
		super(tier, attackDamage, attackSpeed, builder.group(TATsMod.setup.tatsmoditemgroup));
		setRegistryName(registryName);
	}
}
