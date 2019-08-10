package com.eonzenx.modsetup.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.DamageSource;

public class HealthMoveEnchant extends Enchantment {
	private final HealthMoveEnchant.Type healthType;
	
	public HealthMoveEnchant(EnchantmentType enchantableItems, HealthMoveEnchant.Type typeIn) {
		super(Enchantment.Rarity.RARE, enchantableItems,  new EquipmentSlotType[]{EquipmentSlotType.MAINHAND});
		healthType = typeIn;
		
		switch (healthType) {
			case PULL:
				this.setRegistryName("health_move_pos");
				break;
			case PUSH:
				this.setRegistryName("health_move_neg");
				break;
		}
	}
	
	@Override
	public float calcDamageByCreature(int level, CreatureAttribute creatureType) {
		if (healthType == Type.PULL) {
			return 0;
		} else if (healthType == Type.PUSH) {
			return -100.0F;
		} else {
			return 0;
		}
	}
	@Override
	public void onEntityDamaged(LivingEntity user, Entity target, int level) {
		if (target instanceof LivingEntity) {
			LivingEntity livingTarget = (LivingEntity) target;
			switch (healthType) {
				case PULL:
					user.heal(livingTarget.getHealth()*(level / 2));
					break;
				case PUSH:
					float dmgAmount = user.getHealth()*(level / 2);
					livingTarget.heal(dmgAmount);
					user.attackEntityFrom(new DamageSource("HEAL Enchant"), dmgAmount);
					break;
			}
		}
	}
	@Override
	public int getMinEnchantability(int enchantmentLevel) {
		return 1 + 10 * (enchantmentLevel - 1);
	}
	@Override
	public int getMaxEnchantability(int enchantmentLevel) {
		   return super.getMinEnchantability(enchantmentLevel) + 50;
	}
	@Override
	public int getMaxLevel() {
		return 3;
	}
	public static enum Type {
		PULL("positive", 1, 5),
		PUSH("negative", 1, 5);
		
		private final String typeName;
		private final int minEnchant;
		private final int levelCost;
		
		private Type(String name, int minEnchant, int levelCost) {
			this.typeName = name;
			this.minEnchant = minEnchant;
			this.levelCost = levelCost;
		}
		
		public int getminEnchant() {
			return this.minEnchant;
		}
		public int getEnchantIncreasePerLevel() {
			return this.levelCost;
		}
	}
}
