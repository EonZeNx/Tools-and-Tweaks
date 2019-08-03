package com.eonzenx.modsetup.events;

import com.eonzenx.tats.TATsMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.Event;

public class ChangedArmor extends Event {
	
	protected static PlayerEntity player;
	protected static EquipmentSlotType eqSlot;
	protected static ItemStack oldEq;
	protected static ItemStack newEq;
	
	public ChangedArmor (PlayerEntity player, EquipmentSlotType eqSlot, ItemStack oldEq, ItemStack newEq) {
		ChangedArmor.player = player;
		ChangedArmor.eqSlot = eqSlot;
		ChangedArmor.oldEq = oldEq;
		ChangedArmor.newEq = newEq;
		
		TATsMod.LOGGER.info("Old armor piece: " + oldEq.getItem().getRegistryName().toString() + ", new armor piece: " + newEq.getItem().getRegistryName().toString());
	}
	
	public PlayerEntity getPlayer() {
		return player;
	}
	public EquipmentSlotType getEqSlot() {
		return eqSlot;
	}
	public ItemStack getOldEq() {
		return oldEq;
	}
	public ItemStack getNewEq() {
		return newEq;
	}
}
