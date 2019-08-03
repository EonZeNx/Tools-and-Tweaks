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
import net.minecraft.world.biome.Biome.TempCategory;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod("tatsmod")
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
	private static final Item[] redstoneSet = setRedstoneSet();
	private static final Item[] emeraldSet = setEmeraldSet();
	private static final Item[] lapisLazuliSet = setLapisLazuliSet();
	
	public static Item[] setRedstoneSet() {
		Item[] temp = {ModItemsList.REDSTONE_HELMET,
				ModItemsList.REDSTONE_CHESTPLATE,
				ModItemsList.REDSTONE_LEGGINGS,
				ModItemsList.REDSTONE_BOOTS};
		return temp;
	}
	public static Item[] setEmeraldSet() {
		Item[] temp = {ModItemsList.EMERALD_HELMET,
				ModItemsList.EMERALD_CHESTPLATE,
				ModItemsList.EMERALD_LEGGINGS,
				ModItemsList.EMERALD_BOOTS};
		return temp;
	}
	public static Item[] setLapisLazuliSet() {
		Item[] temp = {ModItemsList.LAPIS_LAZULI_HELMET,
				ModItemsList.LAPIS_LAZULI_CHESTPLATE,
				ModItemsList.LAPIS_LAZULI_LEGGINGS,
				ModItemsList.LAPIS_LAZULI_BOOTS};
		return temp;
	}
	
	/*
	this.potion = p_i48980_1_;
	this.duration = p_i48980_2_;
	this.amplifier = p_i48980_3_;
	this.ambient = p_i48980_4_;
	this.showParticles = p_i48980_5_;
	this.showIcon = p_i48980_6_;
	 */
	public static void checkArmorSet(PlayerEntity playerEntity, Item helmet, Item chest, Item legs, Item boots) {
		if (playerEntity == null || helmet == null || chest == null || legs == null || boots == null) {
			return;
		} else {
			if (redstoneSet[0] != null) {
				System.out.println("Redstone [0] != null");
			} else {
				System.out.println("Redstone [0] FUCKING EQUALS null FOR SOME REASON");
			}
			/*
			if (helmet.getRegistryName() == redstoneSet[0].getRegistryName()) {
				// redstone set
				if ((chest.getRegistryName() == redstoneSet[1].getRegistryName()) &&
					(legs.getRegistryName() == redstoneSet[2].getRegistryName()) &&
					(boots.getRegistryName() == redstoneSet[3].getRegistryName())
				) {
					playerEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 999999999, 0, false, false, true));
					playerEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 999999999, 1, false, false, true));
				}
			} else if (helmet.getRegistryName() == emeraldSet[0].getRegistryName()) {
				// emerald set
				if ((chest.getRegistryName() == emeraldSet[1].getRegistryName()) &&
						(legs.getRegistryName() == emeraldSet[2].getRegistryName()) &&
						(boots.getRegistryName() == emeraldSet[3].getRegistryName())
					) {
						playerEntity.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 999999999, 0, false, false, true));
						playerEntity.addPotionEffect(new EffectInstance(Effects.LUCK, 999999999, 0, false, false, true));
					}
			} else if (helmet.getRegistryName() == lapisLazuliSet[0].getRegistryName()) {
				// lapis lazuli set
				if ((chest.getRegistryName() == lapisLazuliSet[1].getRegistryName()) &&
						(legs.getRegistryName() == lapisLazuliSet[2].getRegistryName()) &&
						(boots.getRegistryName() == lapisLazuliSet[3].getRegistryName())
					) {
						playerEntity.addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, 999999999, 0, false, false, true));
						playerEntity.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 999999999, 0, false, false, true));
					}
			} else {
				return;
			}
			*/
		}
	}
	
	// equip methods
	@SubscribeEvent
	public static void helmetEquip(HelmetEquipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player just in case
		if (playerEntity == null) {
			System.out.println("Player that equipped helmet == null !!");
		} else {
			if (equippedItem == null) {
				System.out.println("Equipped helmet == null !!");
			} else {
				equippedHelmet = equippedItem;
				checkArmorSet(playerEntity, equippedHelmet, equippedChestpiece, equippedLeggings, equippedBoots);
			}
		}
	}
	@SubscribeEvent
	public static void chestPieceEquip(ChestPieceEquipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if (playerEntity == null) {
			System.out.println("Player that equipped chest piece == null !!");
		} else {
			if (equippedItem == null) {
				System.out.println("Equipped chest piece == null !!");
			} else {
				equippedChestpiece = equippedItem;
				checkArmorSet(playerEntity, equippedHelmet, equippedChestpiece, equippedLeggings, equippedBoots);
			}
		}
	}
	@SubscribeEvent
	public static void leggingsEquip(LeggingsEquipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if (playerEntity == null) {
			System.out.println("Player that equipped leggings == null !!");
		} else {
			if (equippedItem == null) {
				System.out.println("Equipped leggings == null !!");
			} else {
				equippedLeggings = equippedItem;
				checkArmorSet(playerEntity, equippedHelmet, equippedChestpiece, equippedLeggings, equippedBoots);
			}
		}
	}
	@SubscribeEvent
	public static void bootsEquip(BootsEquipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if (playerEntity == null) {
			System.out.println("Player that equipped boots == null !!");
		} else {
			if (equippedItem == null) {
				System.out.println("Equipped boots == null !!");
			} else {
				equippedBoots = equippedItem;
				checkArmorSet(playerEntity, equippedHelmet, equippedChestpiece, equippedLeggings, equippedBoots);
			}
		}
	}
	
	// unequip methods
	@SubscribeEvent
	public static void helmetUnequip(HelmetUnequipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if (playerEntity == null) {
			System.out.println("Player that unequipped helmet == null !!");
		} else {
			if (equippedItem == null) {
				System.out.println("Unequipped helmet == null !!");
			} else {
				equippedHelmet = empty;
				checkArmorSet(playerEntity, equippedHelmet, equippedChestpiece, equippedLeggings, equippedBoots);
			}
		}
	}
	@SubscribeEvent
	public static void chestPieceUnequip(ChestPieceEquipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if (playerEntity == null) {
			System.out.println("Player that unequipped chest piece == null !!");
		} else {
			if (equippedItem == null) {
				System.out.println("Unequipped chest piece == null !!");
			} else {
				equippedChestpiece = empty;
				checkArmorSet(playerEntity, equippedHelmet, equippedChestpiece, equippedLeggings, equippedBoots);
			}
		}
	}
	@SubscribeEvent
	public static void leggingsUnequip(LeggingsUnequipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if (playerEntity == null) {
			System.out.println("Player that unequipped leggings == null !!");
		} else {
			if (equippedItem == null) {
				System.out.println("Unequipped leggings == null !!");
			} else {
				equippedLeggings = empty;
				checkArmorSet(playerEntity, equippedHelmet, equippedChestpiece, equippedLeggings, equippedBoots);
			}
		}
	}
	@SubscribeEvent
	public static void bootsUnequip(BootsEquipEvent event) {
		PlayerEntity playerEntity = event.getPlayer();
		Item equippedItem = event.getEquippedItem();
		
		// Check player & the item, just in case
		if (playerEntity == null) {
			System.out.println("Player that unequipped boots == null !!");
		} else {
			if (equippedItem == null) {
				System.out.println("Unequipped boots == null !!");
			} else {
				equippedBoots = empty;
				checkArmorSet(playerEntity, equippedHelmet, equippedChestpiece, equippedLeggings, equippedBoots);
			}
		}
	}
}
