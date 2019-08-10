package com.eonzenx.modsetup.player;

import com.eonzenx.modsetup.events.EquippedArmor;
import com.eonzenx.modsetup.events.UnequippedArmor;
import com.eonzenx.modsetup.items.ModItemsList;
import com.eonzenx.tats.TATsMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = TATsMod.MOD_ID, bus = Bus.FORGE)
public class ModArmorEffects {
	
	// unequipped item
	private static final ItemStack empty = new ItemStack(Items.AIR);
	
	// equipped items
	private static ItemStack[] eqItemStack = new ItemStack[4];
	
	// armor sets
	private static ArmorSet redstoneArmorSet;
	private static ArmorSet emeraldArmorSet;
	private static ArmorSet lapisLazuliArmorSet;
	private static ArmorSet[] allArmorSets = new ArmorSet[3];
	
	// methods to stop ItemStack getting null due to delayed registering
	private static ArmorSet setRedstoneSet() {
		EffectInstance[] setBonuses = {
				new EffectInstance(Effects.SPEED, 999999999, 0, false, false, true),
				new EffectInstance(Effects.JUMP_BOOST, 999999999, 1, false, false, true)
		};
		ItemStack[] setPieceArray = {
				new ItemStack(ModItemsList.REDSTONE_HELMET),
				new ItemStack(ModItemsList.REDSTONE_CHESTPLATE),
				new ItemStack(ModItemsList.REDSTONE_LEGGINGS),
				new ItemStack(ModItemsList.REDSTONE_BOOTS)};
		return new ArmorSet("Redstone", setPieceArray, setBonuses);
	}
	private static ArmorSet setEmeraldSet() {
		EffectInstance[] setBonuses = {
				new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 999999999, 0, false, false, true),
				new EffectInstance(Effects.LUCK, 999999999, 0, false, false, true)
		};
		ItemStack[] setPieceArray = {
				new ItemStack(ModItemsList.EMERALD_HELMET),
				new ItemStack(ModItemsList.EMERALD_CHESTPLATE),
				new ItemStack(ModItemsList.EMERALD_LEGGINGS),
				new ItemStack(ModItemsList.EMERALD_BOOTS)};
		return new ArmorSet("Emerald", setPieceArray, setBonuses);
	}
	private static ArmorSet setLapisLazuliSet() {
		EffectInstance[] setBonuses = {
				new EffectInstance(Effects.DOLPHINS_GRACE, 999999999, 0, false, false, true),
				new EffectInstance(Effects.WATER_BREATHING, 999999999, 0, false, false, true)
		};
		ItemStack[] setPieceArray = {
				new ItemStack(ModItemsList.LAPIS_LAZULI_HELMET),
				new ItemStack(ModItemsList.LAPIS_LAZULI_CHESTPLATE),
				new ItemStack(ModItemsList.LAPIS_LAZULI_LEGGINGS),
				new ItemStack(ModItemsList.LAPIS_LAZULI_BOOTS)};
		return new ArmorSet("Lapis Lazuli", setPieceArray, setBonuses);
	}
	public void init() {
		redstoneArmorSet = setRedstoneSet();
		emeraldArmorSet = setEmeraldSet();
		lapisLazuliArmorSet = setLapisLazuliSet();
		
		eqItemStack[0] = eqItemStack[1] = eqItemStack[2] = eqItemStack[3] = empty;
		
		allArmorSets[0] = redstoneArmorSet;
		allArmorSets[1] = emeraldArmorSet;
		allArmorSets[2] = lapisLazuliArmorSet;
	}
	
	// Apply set bonus
	private static void applySetBonus(PlayerEntity player, ArmorSet thisArmorSet) {
		TATsMod.LOGGER.info("Applying " + thisArmorSet.getArmorSetName() + " armor set bonuses...");
		for (EffectInstance fx : thisArmorSet.getArmorSetBonuses()) {
			player.addPotionEffect(fx);
		}
	}
	// Remove set bonus methods
	public static void removeSetBonus(PlayerEntity player, ArmorSet thisArmorSet) {
		for (EffectInstance fx : thisArmorSet.getArmorSetBonuses()) {
			player.removeActivePotionEffect(fx.getPotion());
		}
	}
	public static void removeAllSetBonuses(PlayerEntity player, ArmorSet[] allArmorSets) {
		for (ArmorSet thisArmorSet : allArmorSets) {
			removeSetBonus(player, thisArmorSet);
		}
	}
	// Log current worn items
	public static void logWornItems(ItemStack[] eqItemStack) {
		ItemStack helmet = eqItemStack[0];
		ItemStack chest = eqItemStack[1];
		ItemStack legs = eqItemStack[2];
		ItemStack boots = eqItemStack[3];
		
		TATsMod.LOGGER.info("\n\t\t---" +
				"\n\t\tHelmet: " + helmet.getItem().getRegistryName().toString() +
				"\n\t\tChest: " + chest.getItem().getRegistryName().toString() +
				"\n\t\tLegs: " + legs.getItem().getRegistryName().toString() +
				"\n\t\tBoots: " + boots.getItem().getRegistryName().toString() +
				"\n\t\t---");
	}
	
	// Check armor set/s
	public static void checkArmorSet(ArmorSet thisArmorSet, PlayerEntity player, ItemStack[] eqItemStack) {
		ItemStack[] setPieceArray = thisArmorSet.getArmorSetPieces();
		
		if (ItemStack.areItemsEqualIgnoreDurability(eqItemStack[0], setPieceArray[0]) &&
				ItemStack.areItemsEqualIgnoreDurability(eqItemStack[1], setPieceArray[1]) &&
				ItemStack.areItemsEqualIgnoreDurability(eqItemStack[2], setPieceArray[2]) &&
				ItemStack.areItemsEqualIgnoreDurability(eqItemStack[3], setPieceArray[3])
			) {
				removeAllSetBonuses(player, allArmorSets);
				applySetBonus(player, thisArmorSet);
		}
	}
	public static void checkAllArmorSets(PlayerEntity player, ItemStack[] eqItemStack) {
		if (player == null) {
			TATsMod.LOGGER.error("checkArmorSet: Player == null");
			return;
		}
		
		// if not wearing armor in a slot, definitely no set bonus
		if ((eqItemStack[0].isEmpty() || eqItemStack[1].isEmpty() ||
				eqItemStack[2].isEmpty() || eqItemStack[3].isEmpty())) {
			TATsMod.LOGGER.info("Not wearing armor in every slot...");
			removeAllSetBonuses(player, allArmorSets);
		} else {
			for (ArmorSet thisArmorSet : allArmorSets) {
				checkArmorSet(thisArmorSet, player, eqItemStack);
			}
		}
	}
	
	@SubscribeEvent
	public static void eqArmorPiece(EquippedArmor e) {
		ItemStack newEq = e.getNewEq();
		
		switch (e.getEqSlot()) {
			case HEAD:
				eqItemStack[0] = newEq;
				break;
			case CHEST:
				eqItemStack[1] = newEq;
				break;
			case LEGS:
				eqItemStack[2] = newEq;
				break;
			case FEET:
				eqItemStack[3] = newEq;
				break;
			default:
				break;
		}
		logWornItems(eqItemStack);
		checkAllArmorSets(e.getPlayer(), eqItemStack);
	}
	@SubscribeEvent
	public static void uneqArmorPiece(UnequippedArmor e) {
		switch (e.getEqSlot()) {
			case HEAD:
				eqItemStack[0] = empty;
				break;
			case CHEST:
				eqItemStack[1] = empty;
				break;
			case LEGS:
				eqItemStack[2] = empty;
				break;
			case FEET:
				eqItemStack[3] = empty;
				break;
			default:
				break;
		}
		logWornItems(eqItemStack);
		removeAllSetBonuses(e.getPlayer(), allArmorSets);
	}
}








