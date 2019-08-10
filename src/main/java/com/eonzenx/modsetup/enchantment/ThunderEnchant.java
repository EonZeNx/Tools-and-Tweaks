package com.eonzenx.modsetup.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.inventory.EquipmentSlotType;

public class ThunderEnchant extends Enchantment {
	protected ThunderEnchant(EnchantmentType enchantableItems) {
		super(Enchantment.Rarity.UNCOMMON, enchantableItems, new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
		this.setRegistryName("thunder");
	}
	
	@Override
	public void onEntityDamaged(LivingEntity user, Entity target, int level) {
		LightningBoltEntity thisLightning = new LightningBoltEntity(target.world, target.posX, target.posY, target.posZ, false);
		target.getServer().getWorld(target.dimension).addLightningBolt(thisLightning);
	}
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 20;
	}
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		return 50;
	}
	@Override
	public int getMaxLevel() {
		return 1;
	}
}
