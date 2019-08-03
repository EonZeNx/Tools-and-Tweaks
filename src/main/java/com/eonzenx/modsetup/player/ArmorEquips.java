package com.eonzenx.modsetup.player;

import com.eonzenx.modsetup.events.equippedEvents.BootsEquipEvent;
import com.eonzenx.modsetup.events.equippedEvents.ChestPieceEquipEvent;
import com.eonzenx.modsetup.events.equippedEvents.HelmetEquipEvent;
import com.eonzenx.modsetup.events.equippedEvents.LeggingsEquipEvent;
import com.eonzenx.modsetup.events.unequippedEvents.BootsUnequipEvent;
import com.eonzenx.modsetup.events.unequippedEvents.ChestPieceUnequipEvent;
import com.eonzenx.modsetup.events.unequippedEvents.HelmetUnequipEvent;
import com.eonzenx.modsetup.events.unequippedEvents.LeggingsUnequipEvent;
import com.eonzenx.tats.TATsMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@Mod.EventBusSubscriber(modid = TATsMod.MOD_ID, bus=Bus.FORGE)
public class ArmorEquips {
	
	// unequipped item
	private static final Item empty = Items.AIR;
	
	// old equips
	private static Item lastHelmet = empty;
	private static Item lastChestPiece = empty;
	private static Item lastLegs = empty;
	private static Item lastBoots = empty;
	
	// current equips
	private static Item currentHelmet = empty;
	private static Item currentChestPiece = empty;
	private static Item currentLegs = empty;
	private static Item currentBoots = empty;
	
	@SubscribeEvent
	public static void helmetCheck(PlayerTickEvent event) {
		// Get player
		PlayerEntity thisPlayer = event.player;
		
		// helmet
		currentHelmet = thisPlayer.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem();
		if ((currentHelmet != empty) && (currentHelmet != lastHelmet)) {
			lastHelmet = currentHelmet;
			MinecraftForge.EVENT_BUS.post(new HelmetEquipEvent(thisPlayer, currentHelmet));
		} else if ((currentHelmet == empty) && (lastHelmet != empty)) {
			MinecraftForge.EVENT_BUS.post(new HelmetUnequipEvent(thisPlayer, lastHelmet));
			lastHelmet = empty;
		}
	}
	@SubscribeEvent
	public static void chestpieceCheck(PlayerTickEvent event) {
		// Get player
		PlayerEntity thisPlayer = event.player;
		currentChestPiece = thisPlayer.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem();
		
		// chestpiece
		if ((currentChestPiece != empty) && (currentChestPiece != lastChestPiece)) {
			MinecraftForge.EVENT_BUS.post(new ChestPieceEquipEvent(thisPlayer, currentChestPiece));
			lastChestPiece = currentChestPiece;
		} else if ((currentChestPiece == empty) && (lastChestPiece != empty)) {
			MinecraftForge.EVENT_BUS.post(new ChestPieceUnequipEvent(thisPlayer, lastChestPiece));
			lastChestPiece = empty;
		}
	}
	@SubscribeEvent
	public static void leggingsCheck(PlayerTickEvent event) {
		// Get player
		PlayerEntity thisPlayer = event.player;
		currentLegs = thisPlayer.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem();
		
		// leg piece
		if ((currentLegs != empty) && (currentLegs != lastLegs)) {
			MinecraftForge.EVENT_BUS.post(new LeggingsEquipEvent(thisPlayer, currentLegs));
			lastLegs = currentLegs;
		} else if ((currentLegs == empty) && (lastLegs != empty)) {
			MinecraftForge.EVENT_BUS.post(new LeggingsUnequipEvent(thisPlayer, lastLegs));
			lastLegs = empty;
		}
	}
	@SubscribeEvent
	public static void bootsCheck(PlayerTickEvent event) {
		// Get player
		PlayerEntity thisPlayer = event.player;
		currentBoots = thisPlayer.getItemStackFromSlot(EquipmentSlotType.FEET).getItem();
		
		// boots
		if ((currentBoots != empty) && (currentBoots != lastBoots)) {
			MinecraftForge.EVENT_BUS.post(new BootsEquipEvent(thisPlayer, currentBoots));
			lastBoots = currentBoots;
		} else if ((currentBoots == empty) && (lastBoots != empty)) {
			MinecraftForge.EVENT_BUS.post(new BootsUnequipEvent(thisPlayer, lastBoots));
			lastBoots = empty;
		}
	}
}
