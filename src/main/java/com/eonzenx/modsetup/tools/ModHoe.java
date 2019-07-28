package com.eonzenx.modsetup.tools;

import com.eonzenx.tats.TATsMod;

import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;

public class ModHoe extends HoeItem {
	
	public ModHoe(String registryName, IItemTier tier, float attackSpeed, Properties builder) {
		super(tier, attackSpeed, builder.group(TATsMod.setup.tatsmoditemgroup));
		setRegistryName(registryName);
	}
}
