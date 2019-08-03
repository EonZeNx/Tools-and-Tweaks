package com.eonzenx.modsetup.events.unequippedEvents;

import com.eonzenx.modsetup.events.EquippedEvent;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

public class BootsUnequipEvent extends EquippedEvent {

	public BootsUnequipEvent(PlayerEntity player, Item unequippedItem) {
		super(player, unequippedItem);

		System.out.println("Unequipped " + unequippedItem.getRegistryName().toString());
	}
}
