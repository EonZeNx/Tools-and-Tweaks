package com.eonzenx.modsetup.events.equippedEvents;

import com.eonzenx.modsetup.events.EquippedEvent;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

public class ChestPieceEquipEvent extends EquippedEvent {

	public ChestPieceEquipEvent(PlayerEntity player, Item equippedItem) {
		super(player, equippedItem);
	}
}
