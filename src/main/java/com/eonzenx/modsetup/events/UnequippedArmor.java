package com.eonzenx.modsetup.events;

import com.eonzenx.tats.TATsMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = TATsMod.MOD_ID, bus=Bus.FORGE)
public class UnequippedArmor extends Event {
	protected static PlayerEntity player;
	protected static EquipmentSlotType eqSlot;
	protected static ItemStack oldEq;
	
	public UnequippedArmor (PlayerEntity player, EquipmentSlotType eqSlot, ItemStack oldEq) {
		UnequippedArmor.player = player;
		UnequippedArmor.eqSlot = eqSlot;
		UnequippedArmor.oldEq = oldEq;
		
		TATsMod.LOGGER.info("Unequipped: " + oldEq.getItem().getRegistryName().toString());
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
}
