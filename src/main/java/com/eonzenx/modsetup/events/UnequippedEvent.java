package com.eonzenx.modsetup.events;

import com.eonzenx.tats.TATsMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;

public class UnequippedEvent extends Event {
	
	protected PlayerEntity player;
	protected Item equippedItem;
	
	public UnequippedEvent(PlayerEntity player, Item equippedItem) {
		super();
		this.player = player;
		this.equippedItem = equippedItem;
		
		TATsMod.LOGGER.debug("INFO: Unequipped " + equippedItem.getRegistryName().toString());
	}
	
	public PlayerEntity getPlayer() {
		return this.player;
	}
	public Item getEquippedItem() {
		return this.equippedItem;
	}
}
