package com.eonzenx.modsetup.armor;

import com.eonzenx.tats.TATsMod;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;

public class ModArmor extends ArmorItem {

	public ModArmor(String registryName, IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
		super(materialIn, slot, builder.group(TATsMod.setup.tatsmoditemgroup));
		setRegistryName(registryName);
	}
}
