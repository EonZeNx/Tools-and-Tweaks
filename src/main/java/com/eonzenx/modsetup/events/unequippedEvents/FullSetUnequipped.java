package com.eonzenx.modsetup.events.unequippedEvents;

import com.eonzenx.modsetup.events.FullArmorSetEvent;

import net.minecraft.entity.player.PlayerEntity;

public class FullSetUnequipped extends FullArmorSetEvent {
	
	public FullSetUnequipped(PlayerEntity player, String armorSetName) {
		super(player, armorSetName);
		
		System.out.println("Equipped " + armorSetName);
	}
}
