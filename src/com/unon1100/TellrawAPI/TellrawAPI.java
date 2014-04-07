package com.unon1100.TellrawAPI;

import net.minecraft.server.v1_7_R1.ChatSerializer;
import net.minecraft.server.v1_7_R1.IChatBaseComponent;
import net.minecraft.server.v1_7_R1.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TellrawAPI extends JavaPlugin{
	
	@Override
	public void onEnable(){
		getLogger().info("Tellraw API has been enabled!");
	}
	
	
	public static StringBuilder finalize(StringBuilder...sb){
		StringBuilder msg = new StringBuilder("{\"text\":\"\",\"extra\":[");
		for(int i=0; i<sb.length;i++){
			if(i==sb.length-1){
				msg.append(sb[i]+"]}");
			}else{
				msg.append(sb[i]+",");
			}
		}
		return msg;
	}
	
	public static StringBuilder finalize(TellrawParent...tr){
		StringBuilder msg = new StringBuilder("{\"text\":\"\",\"extra\":[");
		
		for(int i=0; i<tr.length;i++){
			if(i==tr.length-1){
				msg.append(tr[i].getStringBuilder()+"]}");
			}else{
				msg.append(tr[i].getStringBuilder()+",");
			}
		}
		return msg;
	}
	public static void sendToAll(StringBuilder msg){
		Bukkit.getLogger().info(msg.toString());
		for(Player p:Bukkit.getOnlinePlayers()){
			IChatBaseComponent comp = ChatSerializer.a(msg.toString());
			PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		}
	}

	public static void sendTo(StringBuilder msg, Player... players){
		for(Player p:players){
			IChatBaseComponent comp = ChatSerializer.a(msg.toString());
			PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		}
	}
	
	public static void sendToAll(String msg){
		for(Player p:Bukkit.getOnlinePlayers()){
			IChatBaseComponent comp = ChatSerializer.a(msg);
			PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		}
	}

	public static void sendTo(String msg, Player... players){
		for(Player p:players){
			IChatBaseComponent comp = ChatSerializer.a(msg);
			PacketPlayOutChat packet = new PacketPlayOutChat(comp, true);
			((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
		}
	}
}