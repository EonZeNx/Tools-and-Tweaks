package com.eonzenx.modsetup.events.equippedEvents;

import com.eonzenx.modsetup.events.EquippedEvent;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

public class LeggingsEquipEvent extends EquippedEvent {

	public LeggingsEquipEvent(PlayerEntity player, Item equippedItem) {
		super(player, equippedItem);

		System.out.println("Equipped " + equippedItem.getRegistryName().toString());
	}
}
