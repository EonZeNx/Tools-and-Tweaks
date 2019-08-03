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
public class ModArmorEquipChecks {
	
	// unequipped item
	private static final ItemStack empty = new ItemStack(Items.AIR);
	
	// old equips
	private static ItemStack oldHelmet = empty;
	private static ItemStack oldChestpiece = empty;
	private static ItemStack oldLeggings = empty;
	private static ItemStack oldBoots = empty;
	
	// current equips
	private static ItemStack newHelmet = empty;
	private static ItemStack newChestpiece = empty;
	private static ItemStack newLeggings = empty;
	private static ItemStack newBoots = empty;
	
	@SubscribeEvent
	public static void checkArmorChange(PlayerTickEvent e) {
		PlayerEntity player = e.player;
		
		newHelmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
		newChestpiece = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
		newLeggings = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
		newBoots = player.getItemStackFromSlot(EquipmentSlotType.FEET);
		
		if (!ItemStack.areItemsEqualIgnoreDurability(newHelmet, oldHelmet)) {
			MinecraftForge.EVENT_BUS.post(new ChangedArmor(player, EquipmentSlotType.HEAD, oldHelmet, newHelmet));
		}
		if (!ItemStack.areItemsEqualIgnoreDurability(newChestpiece, oldChestpiece)) {
			MinecraftForge.EVENT_BUS.post(new ChangedArmor(player, EquipmentSlotType.CHEST, oldChestpiece, newChestpiece));
		}
		if (!ItemStack.areItemsEqualIgnoreDurability(newLeggings, oldLeggings)) {
			MinecraftForge.EVENT_BUS.post(new ChangedArmor(player, EquipmentSlotType.LEGS, oldLeggings, newLeggings));
		}
		if (!ItemStack.areItemsEqualIgnoreDurability(newBoots, oldBoots)) {
			MinecraftForge.EVENT_BUS.post(new ChangedArmor(player, EquipmentSlotType.FEET, oldBoots, newBoots));
		}
		
		oldHelmet = newHelmet;
		oldChestpiece = newChestpiece;
		oldLeggings = newLeggings;
		oldBoots = newBoots;
	}
}
