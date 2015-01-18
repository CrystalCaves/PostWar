package it.crystalcaves.postwar.game;

import it.crystalcaves.postwar.arena.Arena;

import java.util.List;

import org.bukkit.configuration.ConfigurationSection;
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

public interface ArenaMode {
	
	public void init(ConfigurationSection config, Arena arena);
	
	public ConfigurationSection getConfig();
	
	public void load();
	
	public Arena getArena();
	
	public List<Player> getPlayers();
	
	public boolean addPlayer(Player player);
	
	public void onPlayerAdd(Player player);
	
	public boolean containsPlayer(Player player);
	
	public boolean removePlayer(Player player);
	
	public boolean start();
	
	public boolean stop();
	
	public boolean isStarted();
	
	public void onPlayerChat(AsyncPlayerChatEvent event);
	
	public void onBlockBreak(BlockBreakEvent event);
	
	public void onBlockPlace(BlockPlaceEvent event);
	
	public void onBlockInteract(PlayerInteractEvent event);
	
	public void onPlayerInteractEntity(PlayerInteractEntityEvent event);
	
	public void onPlayerMove(PlayerMoveEvent event);
	
	public void onEntityDamage(EntityDamageEvent event);
	
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event);
	
	public void onPlayerDeath(PlayerDeathEvent event);
	
	public void onPlayerRemove(Player event); 
	
}
