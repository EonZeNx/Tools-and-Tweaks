package com.eonzenx.modsetup.setup;

import com.eonzenx.modsetup.items.ModItemsList;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TATsModSetup {
	
	public ItemGroup tatsmoditemgroup = new ItemGroup("tatsmodtab") {
		@Override
		public ItemStack createIcon() {
			return new ItemStack(ModItemsList.REDSTONE_PICKAXE);
		}
	};
	
	public void init() {
	}
}
