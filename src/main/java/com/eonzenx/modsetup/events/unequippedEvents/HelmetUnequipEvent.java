package com.eonzenx.modsetup.events.unequippedEvents;

import com.eonzenx.modsetup.events.UnequippedEvent;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

public class HelmetUnequipEvent extends UnequippedEvent {

	public HelmetUnequipEvent(PlayerEntity player, Item unequippedItem) {
		super(player, unequippedItem);
	}
}
