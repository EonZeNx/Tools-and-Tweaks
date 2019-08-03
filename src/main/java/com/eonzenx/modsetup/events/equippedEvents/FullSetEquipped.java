package com.eonzenx.modsetup.events.equippedEvents;

import com.eonzenx.modsetup.events.FullArmorSetEvent;

import net.minecraft.entity.player.PlayerEntity;

public class FullSetEquipped extends FullArmorSetEvent {
	
	public FullSetEquipped(PlayerEntity player, String armorSetName) {
		super(player, armorSetName);
	}
}
