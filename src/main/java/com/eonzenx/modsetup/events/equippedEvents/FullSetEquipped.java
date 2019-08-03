package com.eonzenx.modsetup.events.equippedEvents;

import com.eonzenx.modsetup.events.EquipArmorSetEvent;

import net.minecraft.entity.player.PlayerEntity;

public class FullSetEquipped extends EquipArmorSetEvent {
	
	public FullSetEquipped(PlayerEntity player, String armorSetName) {
		super(player, armorSetName);
	}
}
