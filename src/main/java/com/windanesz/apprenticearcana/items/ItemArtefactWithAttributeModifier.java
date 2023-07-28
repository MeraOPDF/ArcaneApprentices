package com.windanesz.apprenticearcana.items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.windanesz.apprenticearcana.ApprenticeArcana;
import com.windanesz.apprenticearcana.client.gui.AAGuiHandler;
import com.windanesz.apprenticearcana.inventory.IItemWithSlots;
import electroblob.wizardry.item.ItemArtefact;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.UUID;

public class ItemArtefactWithAttributeModifier extends ItemArtefact implements IBauble {

	private static final UUID ATTACK_DAMAGE_MODIFIER = UUID.fromString("7E04BE40-F9C7-4342-8E7F-CF90F92B19AF");
	private static final String ATTACK_DAMAGE_MODIFIER_NAME = "AttackDamageBoost";


	public ItemArtefactWithAttributeModifier(EnumRarity rarity, Type type) {
		super(rarity, type);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemStack) {
		return BaubleType.BELT;
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		IAttributeInstance attribute = player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		AttributeModifier existingModifier = attribute.getModifier(ATTACK_DAMAGE_MODIFIER);
		if (existingModifier == null) {

			// Apply the +10% attack damage modifier to the player's attack damage attribute
			AttributeModifier modifier = new AttributeModifier(ATTACK_DAMAGE_MODIFIER, ATTACK_DAMAGE_MODIFIER_NAME, 2, 1);
			attribute.applyModifier(modifier);
		}
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		IAttributeInstance attribute = player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		AttributeModifier existingModifier = attribute.getModifier(ATTACK_DAMAGE_MODIFIER);
		if (existingModifier != null) {
			attribute.removeModifier(existingModifier);
		}
	}
}
