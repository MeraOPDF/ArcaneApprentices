//package com.windanesz.arcaneapprentices.client;
//
//import com.windanesz.arcaneapprentices.ApprenticeArcana;
//import com.windanesz.arcaneapprentices.packet.MSPacketHandler;
//import com.windanesz.arcaneapprentices.packet.PacketToggleAbility;
//import net.minecraft.client.Minecraft;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.gameevent.TickEvent;
//import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
//import net.minecraftforge.fml.relauncher.Side;
//
//@Mod.EventBusSubscriber(Side.CLIENT)
//public class ControlHandler {
//
//	static boolean abilityKeyPressed = false;
//
//	@SubscribeEvent
//	public static void onTickEvent(TickEvent.ClientTickEvent event) {
//
//		if (event.phase == TickEvent.Phase.END) {
//			return; // Only really needs to be once per tick
//		}
//
//		if (ApprenticeArcana.proxy instanceof com.windanesz.arcaneapprentices.client.ClientProxy) {
//
//			EntityPlayer player = Minecraft.getMinecraft().player;
//
//			if (player != null) {
//
//				if (ClientProxy.KEY_ACTIVATE_MORPH_ABILITY.isKeyDown() && Minecraft.getMinecraft().inGameHasFocus) {
//					if (!abilityKeyPressed) {
//						abilityKeyPressed = true;
//						toggleAbility(player);
//					}
//				} else {
//					abilityKeyPressed = false;
//				}
//			}
//		}
//	}
//
//	private static void toggleAbility(EntityPlayer player) {
//		System.out.println("Ability toggled");
//		IMessage msg = new PacketToggleAbility.Message();
//		MSPacketHandler.net.sendToServer(msg);
//	}
//}
