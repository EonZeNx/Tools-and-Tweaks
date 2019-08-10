package com.eonzenx.modsetup.events;

import com.eonzenx.tats.TATsMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@Mod.EventBusSubscriber(modid = TATsMod.MOD_ID, bus=Bus.FORGE)
public class ArmorEqsEventPoster {
	
	// unequipped item
	private static ItemStack empty;
	
	// old equips
	private static ItemStack oldHelmet;
	private static ItemStack oldChestpiece;
	private static ItemStack oldLeggings;
	private static ItemStack oldBoots;
	
	// current equips
	private static ItemStack newHelmet;
	private static ItemStack newChestpiece;
	private static ItemStack newLeggings;
	private static ItemStack newBoots;
	
	public void init() {
		empty = new ItemStack(Items.AIR);
		
		oldHelmet = empty;
		oldChestpiece = empty;
		oldLeggings = empty;
		oldBoots = empty;
		
		newHelmet = empty;
		newChestpiece = empty;
		newLeggings = empty;
		newBoots = empty;
	}
	
	@SubscribeEvent
	public static void checkArmorChange(PlayerTickEvent e) {
		PlayerEntity player = e.player;
		
		newHelmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		newChestpiece = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		newLeggings = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
		newBoots = player.getItemStackFromSlot(EquipmentSlotType.FEET);
		
		// Helmet eq methods
		if (!ItemStack.areItemsEqualIgnoreDurability(newHelmet, oldHelmet)) {
			if (newHelmet.isEmpty()) {
				MinecraftForge.EVENT_BUS.post(new UnequippedArmor(player, EquipmentSlotType.HEAD, oldHelmet));
			} else {
				MinecraftForge.EVENT_BUS.post(new EquippedArmor(player, EquipmentSlotType.HEAD, oldHelmet, newHelmet));
			}
		}
		// Chestpiece eq methods
		if (!ItemStack.areItemsEqualIgnoreDurability(newChestpiece, oldChestpiece)) {
			if (newChestpiece.isEmpty()) {
				MinecraftForge.EVENT_BUS.post(new UnequippedArmor(player, EquipmentSlotType.CHEST, oldChestpiece));
			} else {
				MinecraftForge.EVENT_BUS.post(new EquippedArmor(player, EquipmentSlotType.CHEST, oldChestpiece, newChestpiece));
			}
		}
		// Leggings eq methods
		if (!ItemStack.areItemsEqualIgnoreDurability(newLeggings, oldLeggings)) {
			if (newLeggings.isEmpty()) {
				MinecraftForge.EVENT_BUS.post(new UnequippedArmor(player, EquipmentSlotType.LEGS, oldLeggings));
			} else {
				MinecraftForge.EVENT_BUS.post(new EquippedArmor(player, EquipmentSlotType.LEGS, oldLeggings, newLeggings));
			}
		}
		// Boots eq methods
		if (!ItemStack.areItemsEqualIgnoreDurability(newBoots, oldBoots)) {
			if (newBoots.isEmpty()) {
				MinecraftForge.EVENT_BUS.post(new UnequippedArmor(player, EquipmentSlotType.FEET, oldBoots));
			} else {
				MinecraftForge.EVENT_BUS.post(new EquippedArmor(player, EquipmentSlotType.FEET, oldBoots, newBoots));
			}
		}
		
		oldHelmet = newHelmet;
		oldChestpiece = newChestpiece;
		oldLeggings = newLeggings;
		oldBoots = newBoots;
	}
}
