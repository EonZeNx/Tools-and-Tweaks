package com.eonzenx.modsetup.player;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;

public class ArmorSet {
	private String armorSetNameString;
	private ItemStack[] armorSetPieces;
	private EffectInstance[] armorSetBonuses;
	
	public ArmorSet(String armorSetNameString, ItemStack[] armorSetPieces, EffectInstance[] armorSetBonuses) {
		this.armorSetNameString = armorSetNameString;
		this.armorSetPieces = armorSetPieces;
		this.armorSetBonuses = armorSetBonuses;
	}
	
	public String getArmorSetName() {
		return armorSetNameString;
	}
	public ItemStack[] getArmorSetPieces() {
		return armorSetPieces;
	}
	public EffectInstance[] getArmorSetBonuses() {
	/*	potion, duration, amplifier, ambient, showParticles, showIcon	*/
		return armorSetBonuses;
	}
}
