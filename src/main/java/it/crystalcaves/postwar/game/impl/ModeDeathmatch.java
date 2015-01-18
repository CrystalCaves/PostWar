package it.crystalcaves.postwar.game.impl;

import it.crystalcaves.postwar.util.SerializationUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class ModeDeathmatch extends SimpleMode{

	private List<Location> spawns;
	private boolean isStart = false;
	private List<Block> blockPlaced;
	private HashMap<Location,Block> blockBroken;
	/*
	 * (non-Javadoc)
	 * @see it.crystalcaves.postwar.game.ArenaMode#load()
	 */
	@Override
	public void load() {
		for(String spawn : config.getStringList("spawns"))
			spawns.add(SerializationUtils.stringToLocation(spawn));
	}

	@Override
	public void onPlayerAdd(Player player) {
		Location rndSpawn = spawns.get((int) (Math.random()*spawns.size()));
		player.teleport(rndSpawn);
	}
	
	@Override
	public void onPlayerDeath(PlayerDeathEvent event) {
		Location rndSpawn = spawns.get((int) (Math.random()*spawns.size()));
		((Player) event.getEntity()).teleport(rndSpawn);
	}

	@Override
	public void onPlayerRemove(Player event) {
		Location rndSpawn = spawns.get((int) (Math.random()*spawns.size()));
		event.getPlayer().teleport(rndSpawn);
	}
	
	@Override
	public boolean start() {
		if(!isStart){
			isStart = true;
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean stop() {
		if(isStart){
			for(Block block : blockPlaced)
				block.setType(Material.AIR);
			
			for(Map.Entry<Location, Block> entry : blockBroken.entrySet())
				entry.getKey().getBlock().setType(entry.getValue().getType());
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean isStarted() {
		return isStart;
	}

	@Override
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBlockBreak(BlockBreakEvent event) {
		blockBroken.put(event.getBlock().getLocation(), event.getBlock());
	}

	@Override
	public void onBlockPlace(BlockPlaceEvent event) {
		blockPlaced.add(event.getBlock());
		
	}

	@Override
	public void onBlockInteract(PlayerInteractEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEntityDamage(EntityDamageEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		// TODO Auto-generated method stub
		
	}

}
