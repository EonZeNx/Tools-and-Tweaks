package com.eonzenx.modsetup.events.unequippedEvents;

import com.eonzenx.modsetup.events.EquippedEvent;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

public class ChestPieceUnequipEvent extends EquippedEvent {

	public ChestPieceUnequipEvent(PlayerEntity player, Item unequippedItem) {
		super(player, unequippedItem);
		
		System.out.println("Unequipped " + unequippedItem.getRegistryName().toString());
	}
}
