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
	public static void onPlayerTick(PlayerTickEvent event) {
		
		// Get player
		PlayerEntity thisPlayer = event.player;
		
		// Get armor worn
		currentHelmet = thisPlayer.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem();
		currentChestPiece = thisPlayer.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem();
		currentLegs = thisPlayer.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem();
		currentBoots = thisPlayer.getItemStackFromSlot(EquipmentSlotType.FEET).getItem();
		
		// helmet
		if ((currentHelmet.getRegistryName() != empty.getRegistryName()) && (currentHelmet.getRegistryName() != lastHelmet.getRegistryName())) {
			lastHelmet = currentHelmet;
			MinecraftForge.EVENT_BUS.post(new HelmetEquipEvent(thisPlayer, lastHelmet));
			
		} else if ((currentHelmet.getRegistryName() == empty.getRegistryName()) && (lastHelmet.getRegistryName() != empty.getRegistryName())) {
			MinecraftForge.EVENT_BUS.post(new HelmetUnequipEvent(thisPlayer, lastHelmet));
			lastHelmet = empty;
		}
		
		// chestpiece
		if ((currentChestPiece.getRegistryName() != empty.getRegistryName()) && (currentChestPiece != lastChestPiece)) {
			lastChestPiece = currentChestPiece;
			MinecraftForge.EVENT_BUS.post(new ChestPieceEquipEvent(thisPlayer, lastChestPiece));
			
		} else if ((currentChestPiece.getRegistryName() == empty.getRegistryName()) && (lastChestPiece.getRegistryName() != empty.getRegistryName())) {
			MinecraftForge.EVENT_BUS.post(new ChestPieceUnequipEvent(thisPlayer, lastChestPiece));
			lastChestPiece = empty;
		}
		
		// leg piece
		if ((currentLegs.getRegistryName() != empty.getRegistryName()) && (currentLegs != lastLegs)) {
			lastLegs = currentLegs;
			MinecraftForge.EVENT_BUS.post(new LeggingsEquipEvent(thisPlayer, lastLegs));
			
		} else if ((currentLegs.getRegistryName() == empty.getRegistryName()) && (lastLegs.getRegistryName() != empty.getRegistryName())) {
			MinecraftForge.EVENT_BUS.post(new LeggingsUnequipEvent(thisPlayer, lastLegs));
			lastLegs = empty;
		}
		
		// boots
		if ((currentBoots.getRegistryName() != empty.getRegistryName()) && (currentBoots != lastBoots)) {
			lastBoots = currentBoots;
			MinecraftForge.EVENT_BUS.post(new BootsEquipEvent(thisPlayer, lastBoots));
			
		} else if ((currentBoots.getRegistryName() == empty.getRegistryName()) && (lastBoots.getRegistryName() != empty.getRegistryName())) {
			MinecraftForge.EVENT_BUS.post(new BootsUnequipEvent(thisPlayer, lastBoots));
			lastBoots = empty;
		}
	}
}
