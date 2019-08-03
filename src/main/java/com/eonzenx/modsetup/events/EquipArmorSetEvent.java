package com.eonzenx.modsetup.events;

import com.eonzenx.tats.TATsMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.eventbus.api.Event;

public class EquipArmorSetEvent extends Event {
	
	protected PlayerEntity player;
	protected String armorSetName;
	
	public EquipArmorSetEvent(PlayerEntity player, String armorSetName) {
		super();
		this.player = player;
		this.armorSetName = armorSetName;
		
		TATsMod.LOGGER.info("Equipped " + armorSetName + " set");
	}
	
	public PlayerEntity getPlayer() {
		return this.player;
	}
	public String getArmorSetName() {
		return this.armorSetName;
	}
}