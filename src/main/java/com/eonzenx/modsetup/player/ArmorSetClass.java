package com.eonzenx.modsetup.player;

import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;

public class ArmorSetClass {
	private String armorSetNameString;
	private ItemStack[] armorSetPieces;
	private EffectInstance[] armorSetBonuses;
	private EffectInstance[] armorSetReverseBonuses;
	
	public ArmorSetClass(String armorSetNameString, ItemStack[] armorSetPieces, EffectInstance[] armorSetBonuses) {
		this.armorSetNameString = armorSetNameString;
		this.armorSetPieces = armorSetPieces;
		this.armorSetBonuses = armorSetBonuses;
		this.armorSetReverseBonuses = null;
	}
	public ArmorSetClass(String armorSetNameString, ItemStack[] armorSetPieces, EffectInstance[] armorSetBonuses, EffectInstance[] armorSetReverseBonuses) {
		this.armorSetNameString = armorSetNameString;
		this.armorSetPieces = armorSetPieces;
		this.armorSetBonuses = armorSetBonuses;
		this.armorSetReverseBonuses = armorSetReverseBonuses;
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
	public EffectInstance[] getarmorSetReverseBonuses() {
		/*	potion, duration, amplifier, ambient, showParticles, showIcon	*/
			return armorSetReverseBonuses;
		}
}
