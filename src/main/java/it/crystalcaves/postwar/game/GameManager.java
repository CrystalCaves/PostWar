package it.crystalcaves.postwar.game;

import java.util.List;

import it.crystalcaves.postwar.arena.Arena;

import org.bukkit.entity.Player;

public interface GameManager {
	
	public boolean registerMode(String name, Class<? extends ArenaMode> mode);
	
	public boolean hasMode(String name);
	
	public boolean unregisterMode(String name);
	
	public boolean isPlaying(Player player);
	
	public Arena getArena(Player player);
	
	public List<Player> getPlayers(Arena arena);
	
}
