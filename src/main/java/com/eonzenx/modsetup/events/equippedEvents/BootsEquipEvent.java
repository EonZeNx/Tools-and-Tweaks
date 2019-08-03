package com.eonzenx.modsetup.events.equippedEvents;

import com.eonzenx.modsetup.events.EquippedEvent;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

public class BootsEquipEvent extends EquippedEvent {

	public BootsEquipEvent(PlayerEntity player, Item equippedItem) {
		super(player, equippedItem);

		System.out.println("Equipped " + equippedItem.getRegistryName().toString());
	}
}
