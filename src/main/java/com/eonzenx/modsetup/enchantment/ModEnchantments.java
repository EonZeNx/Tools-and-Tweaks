package com.eonzenx.modsetup.enchantment;

import com.eonzenx.tats.TATsMod;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.TridentItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = TATsMod.MOD_ID, bus=Bus.FORGE)
public class ModEnchantments {
	public static final EnchantmentType MELEE =
		EnchantmentType.create("melee", itemIn -> (itemIn instanceof SwordItem || itemIn instanceof TridentItem));
	public static final EnchantmentType PROJECTILE =
		EnchantmentType.create("projectile", itemIn -> (itemIn instanceof BowItem || itemIn instanceof CrossbowItem));
	public static final EnchantmentType ALL_WEAPONS =
		EnchantmentType.create("all_weapons",
			itemIn -> (itemIn instanceof SwordItem || itemIn instanceof TridentItem || itemIn instanceof BowItem || itemIn instanceof CrossbowItem));
	
	public static final ThunderEnchant THUNDER = new ThunderEnchant(ModEnchantments.PROJECTILE);
	public static final HealthMoveEnchant HEAL_POSITIVE = new HealthMoveEnchant(ModEnchantments.MELEE, HealthMoveEnchant.Type.PULL);
	public static final HealthMoveEnchant HEAL_NEGATIVE = new HealthMoveEnchant(ModEnchantments.MELEE, HealthMoveEnchant.Type.PUSH);
}
