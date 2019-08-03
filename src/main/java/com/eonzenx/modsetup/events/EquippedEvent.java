package com.eonzenx.modsetup.events;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;

@Mod("tatsmod")
public class EquippedEvent extends Event {
	
	protected PlayerEntity player;
	protected Item equippedItem;
	
	public EquippedEvent(PlayerEntity player, Item equippedItem) {
		super();
		this.player = player;
		this.equippedItem = equippedItem;
	}
	
	public PlayerEntity getPlayer() {
		return this.player;
	}
	public Item getEquippedItem() {
		return this.equippedItem;
	}
}
