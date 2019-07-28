package com.eonzenx.modsetup.tools;

import com.eonzenx.tats.TATsMod;

import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;

public class ModSword extends SwordItem {
	
	public ModSword(String registryName, IItemTier tier, int attackDamage, float attackSpeed, Properties builder) {
		super(tier, attackDamage, attackSpeed, builder.group(TATsMod.setup.tatsmoditemgroup));
		setRegistryName(registryName);
	}
}
