package com.eonzenx.modsetup.events.unequippedEvents;

import com.eonzenx.modsetup.events.UnequipArmorSetEvent;

import net.minecraft.entity.player.PlayerEntity;

public class FullSetUnequipped extends UnequipArmorSetEvent {
	
	public FullSetUnequipped(PlayerEntity player, String armorSetName) {
		super(player, armorSetName);
	}
}
