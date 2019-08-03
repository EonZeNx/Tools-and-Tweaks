package com.eonzenx.modsetup.player;

import com.eonzenx.modsetup.events.ChangedArmor;
import com.eonzenx.modsetup.items.ModItemsList;
import com.eonzenx.tats.TATsMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = TATsMod.MOD_ID, bus = Bus.FORGE)
public class ModArmorEffects {
	
	// unequip item
	private static final ItemStack empty = new ItemStack(Items.AIR);
	
	// equipped items
	private static ItemStack eqHelmet = empty;
	private static ItemStack eqChestpiece = empty;
	private static ItemStack eqLeggings = empty;
	private static ItemStack eqBoots = empty;
	
	// armor sets
	private static ItemStack[] redstoneSet = {empty, empty, empty, empty};
	private static ItemStack[] emeraldSet = {empty, empty, empty, empty};
	private static ItemStack[] lapisLazuliSet = {empty, empty, empty, empty};
	
	public static ItemStack[] setRedstoneSet() {
		ItemStack[] temp = {
				new ItemStack(ModItemsList.REDSTONE_HELMET),
				new ItemStack(ModItemsList.REDSTONE_CHESTPLATE),
				new ItemStack(ModItemsList.REDSTONE_LEGGINGS),
				new ItemStack(ModItemsList.REDSTONE_BOOTS)};
		return temp;
	}
	public static ItemStack[] setEmeraldSet() {
		ItemStack[] temp = {
				new ItemStack(ModItemsList.EMERALD_HELMET),
				new ItemStack(ModItemsList.EMERALD_CHESTPLATE),
				new ItemStack(ModItemsList.EMERALD_LEGGINGS),
				new ItemStack(ModItemsList.EMERALD_BOOTS)};
		return temp;
	}
	public static ItemStack[] setLapisLazuliSet() {
		ItemStack[] temp = {
			new ItemStack(ModItemsList.LAPIS_LAZULI_HELMET),
			new ItemStack(ModItemsList.LAPIS_LAZULI_CHESTPLATE),
			new ItemStack(ModItemsList.LAPIS_LAZULI_LEGGINGS),
			new ItemStack(ModItemsList.LAPIS_LAZULI_BOOTS)};
		return temp;
	}
	
	public void init() {
		redstoneSet = setRedstoneSet();
		emeraldSet = setEmeraldSet();
		lapisLazuliSet = setLapisLazuliSet();
	}
	
/*	potion, duration, amplifier, ambient, showParticles, showIcon	*/
	
	public static void checkArmorSet(PlayerEntity playerEntity, ItemStack helmet, ItemStack chest, ItemStack legs, ItemStack boots) {
		if (playerEntity == null) {
			return;
		}
		TATsMod.LOGGER.info("---");
		TATsMod.LOGGER.info("Helmet: " + helmet.getItem().getRegistryName().toString());
		TATsMod.LOGGER.info("Chest: " + chest.getItem().getRegistryName().toString());
		TATsMod.LOGGER.info("Legs: " + legs.getItem().getRegistryName().toString());
		TATsMod.LOGGER.info("Boots: " + boots.getItem().getRegistryName().toString());
		TATsMod.LOGGER.info("---");
		
		// redstone set
		if (ItemStack.areItemsEqualIgnoreDurability(helmet, redstoneSet[0]) &&
				ItemStack.areItemsEqualIgnoreDurability(chest, redstoneSet[1]) &&
				ItemStack.areItemsEqualIgnoreDurability(legs, redstoneSet[2]) &&
				ItemStack.areItemsEqualIgnoreDurability(boots, redstoneSet[3])
			) {
				TATsMod.LOGGER.info("Equipped full redstone set");
				playerEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 999999999, 0, false, false, true));
				playerEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 999999999, 1, false, false, true));
		} else {
			playerEntity.removeActivePotionEffect(Effects.SPEED);
			playerEntity.removeActivePotionEffect(Effects.JUMP_BOOST);
		}
		
		// emerald set
		if (ItemStack.areItemsEqualIgnoreDurability(helmet, emeraldSet[0]) &&
				ItemStack.areItemsEqualIgnoreDurability(chest, emeraldSet[1]) &&
				ItemStack.areItemsEqualIgnoreDurability(legs, emeraldSet[2]) &&
				ItemStack.areItemsEqualIgnoreDurability(boots, emeraldSet[3])
			) {
				TATsMod.LOGGER.info("Equipped full emerald set");
				playerEntity.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 999999999, 0, false, false, true));
				playerEntity.addPotionEffect(new EffectInstance(Effects.LUCK, 999999999, 0, false, false, true));
		} else {
			playerEntity.removeActivePotionEffect(Effects.HERO_OF_THE_VILLAGE);
			playerEntity.removeActivePotionEffect(Effects.LUCK);
		}
		
		// lapis lazuli set
		if (ItemStack.areItemsEqualIgnoreDurability(helmet, lapisLazuliSet[0]) &&
				ItemStack.areItemsEqualIgnoreDurability(chest, lapisLazuliSet[1]) &&
				ItemStack.areItemsEqualIgnoreDurability(legs, lapisLazuliSet[2]) &&
				ItemStack.areItemsEqualIgnoreDurability(boots, lapisLazuliSet[3])
			) {
				TATsMod.LOGGER.info("Equipped full lapisLazuli set");
				playerEntity.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 999999999, 0, false, false, true));
				playerEntity.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 999999999, 0, false, false, true));
		} else {
			playerEntity.removeActivePotionEffect(Effects.DOLPHINS_GRACE);
			playerEntity.removeActivePotionEffect(Effects.WATER_BREATHING);
		}
	}
	
	// equip methods
	@SubscribeEvent
	public static void changedArmorPiece(ChangedArmor e) {
		PlayerEntity player = e.getPlayer();
		EquipmentSlotType eqSlot = e.getEqSlot();
		ItemStack newEq = e.getNewEq();
		
		// Check player just in case
		switch (eqSlot) {
			case HEAD:
				eqHelmet = newEq;
				break;
			case CHEST:
				eqChestpiece = newEq;
				break;
			case LEGS:
				eqLeggings = newEq;
				break;
			case FEET:
				eqBoots = newEq;
				break;
			default:
				break;
		}
		checkArmorSet(player, eqHelmet, eqChestpiece, eqLeggings, eqBoots);
	}
}
