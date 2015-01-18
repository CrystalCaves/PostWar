package it.crystalcaves.postwar.game.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import it.crystalcaves.postwar.arena.Arena;
import it.crystalcaves.postwar.game.ArenaMode;

public abstract class SimpleMode implements ArenaMode{

	@Getter protected ConfigurationSection config;
	@Getter protected Arena arena;
	@Getter protected List<Player> players;
	
	@Override
	public void init(ConfigurationSection config, Arena arena){
		this.config=config;
		this.arena=arena;
		players=new ArrayList<Player>();
		load();
	}
	
	@Override
	public boolean addPlayer(Player player){
		if(players.contains(player)){
			return false;
		}
		players.add(player);
		onPlayerAdd(player);
		return true;
	}
	
	@Override
	public boolean containsPlayer(Player player){
		return players.contains(player);
	}
	
	@Override
	public boolean removePlayer(Player player){
		if(!players.contains(player)){
			return false;
		}
		players.remove(player);
		onPlayerRemove(player);
		return true;
	}
	
}
