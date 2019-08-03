package com.eonzenx.modsetup.player;

import com.eonzenx.modsetup.events.equippedEvents.HelmetEquipEvent;
import com.eonzenx.modsetup.events.equippedEvents.ChestPieceEquipEvent;
import com.eonzenx.modsetup.events.equippedEvents.LeggingsEquipEvent;
import com.eonzenx.modsetup.events.unequippedEvents.HelmetUnequipEvent;
import com.eonzenx.modsetup.events.unequippedEvents.LeggingsUnequipEvent;
import com.eonzenx.modsetup.items.ModItemsList;
import com.eonzenx.modsetup.events.equippedEvents.BootsEquipEvent;
import com.eonzenx.tats.TATsMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = TATsMod.MOD_ID, bus = Bus.FORGE)
public class ModArmorEffects {
	
	// unequip item
	private static final Item empty = Items.AIR;
	
	// equipped items
	private static Item equippedHelmet = empty;
	private static Item equippedChestpiece = empty;
	private static Item equippedLeggings = empty;
	private static Item equippedBoots = empty;
	
	// armor sets
	private static Item[] redstoneSet = {empty, empty, empty, empty};
	private static Item[] emeraldSet = {empty, empty, empty, empty};
	private static Item[] lapisLazuliSet = {empty, empty, empty, empty};
	
	public static Item[] setRedstoneSet() {
		Item[] temp = {
				ModItemsList.REDSTONE_HELMET,
				ModItemsList.REDSTONE_CHESTPLATE,
				ModItemsList.REDSTONE_LEGGINGS,
				ModItemsList.REDSTONE_BOOTS};
		return temp;
	}
	public static Item[] setEmeraldSet() {
		Item[] temp = {
				ModItemsList.EMERALD_HELMET,
				ModItemsList.EMERALD_CHESTPLATE,
				ModItemsList.EMERALD_LEGGINGS,
				ModItemsList.EMERALD_BOOTS};
		return temp;
	}
	public static Item[] setLapisLazuliSet() {
		Item[] temp = {
				ModItemsList.LAPIS_LAZULI_HELMET,
				ModItemsList.LAPIS_LAZULI_CHESTPLATE,
				ModItemsList.LAPIS_LAZULI_LEGGINGS,
				ModItemsList.LAPIS_LAZULI_BOOTS};
		return temp;
	}
	
	public void init() {
		redstoneSet = setRedstoneSet();
		emeraldSet = setEmeraldSet();
		lapisLazuliSet = setLapisLazuliSet();
	}
	
/*	potion, duration, amplifier, ambient, showParticles, showIcon	*/
	
	public static void checkArmorSet(PlayerEntity playerEntity, Item helmet, Item chest, Item legs, Item boots) {
		TATsMod.LOGGER.info("Armor set was checked");
		
		TATsMod.LOGGER.info(helmet.getRegistryName().toString());
		TATsMod.LOGGER.info(chest.getRegistryName().toString());
		TATsMod.LOGGER.info(legs.getRegistryName().toString());
		TATsMod.LOGGER.info(boots.getRegistryName().toString());
		
		// redstone set
		if (helmet == redstoneSet[0]) {
			if ((chest == redstoneSet[1]) &&
				(legs == redstoneSet[2]) &&
				(boots == redstoneSet[3])
			) {
				TATsMod.LOGGER.info("Equipped full redstone set");
				playerEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 999999999, 0, false, false, true));
				playerEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 999999999, 1, false, false, true));
			}
		} else {
			playerEntity.removeActivePotionEffect(Effects.SPEED);
			playerEntity.removeActivePotionEffect(Effects.JUMP_BOOST);
		}
		
		// emerald set
		if (helmet == emeraldSet[0]) {
			if ((chest == emeraldSet[1]) &&
					(legs == emeraldSet[2]) &&
					(boots == emeraldSet[3])
				) {
					TATsMod.LOGGER.info("Equipped full emerald set");
					playerEntity.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 999999999, 0, false, false, true));
					playerEntity.addPotionEffect(new EffectInstance(Effects.LUCK, 999999999, 0, false, false, true));
				}
		} else {
			playerEntity.removeActivePotionEffect(Effects.HERO_OF_THE_VILLAGE);
			playerEntity.removeActivePotionEffect(Effects.LUCK);
		}
		
		// lapis lazuli set
		if (helmet == lapisLazuliSet[0]) {
			if ((chest == lapisLazuliSet[1]) &&
					(legs == lapisLazuliSet[2]) &&
					(boots == lapisLazuliSet[3])
				) {
					TATsMod.LOGGER.info("Equipped full lapis lazuli set");
					playerEntity.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 999999999, 0, false, false, true));
					playerEntity.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 999999999, 0, false, false, true));
			}
		} else {
			playerEntity.removeActivePotionEffect(Effects.DOLPHINS_GRACE);
			playerEntity.removeActivePotionEffect(Effects.WATER_BREATHING);
		}
	}
	
	// equip methods
	@SubscribeEvent
	public static void helmetEquip(HelmetEquipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player just in case
		if ((playerEntity == null) || (equippedItem == null)) {
			TATsMod.LOGGER.error("Player or Item == null, skipping...");
		} else {
			checkArmorSet(playerEntity, equippedItem, equippedChestpiece, equippedLeggings, equippedBoots);
			equippedHelmet = equippedItem;
		}
	}
	@SubscribeEvent
	public static void chestPieceEquip(ChestPieceEquipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if ((playerEntity == null) || (equippedItem == null)) {
			TATsMod.LOGGER.error("Player or Item == null, skipping...");
		} else {
			checkArmorSet(playerEntity, equippedHelmet, equippedItem, equippedLeggings, equippedBoots);
			equippedChestpiece = equippedItem;
		}
	}
	@SubscribeEvent
	public static void leggingsEquip(LeggingsEquipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if ((playerEntity == null) || (equippedItem == null)) {
			TATsMod.LOGGER.error("Player or Item == null, skipping...");
		} else {
			equippedLeggings = equippedItem;
			checkArmorSet(playerEntity, equippedHelmet, equippedChestpiece, equippedItem, equippedBoots);
		}
	}
	@SubscribeEvent
	public static void bootsEquip(BootsEquipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if ((playerEntity == null) || (equippedItem == null)) {
			TATsMod.LOGGER.error("Player or Item == null, skipping...");
		} else {
			checkArmorSet(playerEntity, equippedHelmet, equippedChestpiece, equippedLeggings, equippedItem);
			equippedBoots = equippedItem;
		}
	}
	
	// unequip methods
	@SubscribeEvent
	public static void helmetUnequip(HelmetUnequipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if ((playerEntity == null) || (equippedItem == null)) {
			TATsMod.LOGGER.error("Player or Item == null, skipping...");
		} else {
			checkArmorSet(playerEntity, empty, equippedChestpiece, equippedLeggings, equippedBoots);
			equippedHelmet = empty;
		}
	}
	@SubscribeEvent
	public static void chestPieceUnequip(ChestPieceEquipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if ((playerEntity == null) || (equippedItem == null)) {
			TATsMod.LOGGER.error("Player or Item == null, skipping...");
		} else {
			checkArmorSet(playerEntity, equippedHelmet, empty, equippedLeggings, equippedBoots);
			equippedChestpiece = empty;
		}
	}
	@SubscribeEvent
	public static void leggingsUnequip(LeggingsUnequipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if ((playerEntity == null) || (equippedItem == null)) {
			TATsMod.LOGGER.error("Player or Item == null, skipping...");
		} else {
			equippedLeggings = empty;
			checkArmorSet(playerEntity, equippedHelmet, equippedChestpiece, empty, equippedBoots);
		}
	}
	@SubscribeEvent
	public static void bootsUnequip(BootsEquipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if ((playerEntity == null) || (equippedItem == null)) {
			TATsMod.LOGGER.error("Player or Item == null, skipping...");
		} else {
			checkArmorSet(playerEntity, equippedHelmet, equippedChestpiece, equippedLeggings, empty);
			equippedBoots = empty;
		}
	}
}
