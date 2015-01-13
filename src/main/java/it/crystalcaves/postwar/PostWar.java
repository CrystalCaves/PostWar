package it.crystalcaves.postwar;

import it.crystalcaves.postwar.arena.ArenaManager;
import it.crystalcaves.postwar.arena.DefaultArenaManager;
import it.crystalcaves.postwar.game.DefaultGameManager;
import it.crystalcaves.postwar.game.GameManager;
import lombok.Getter;

import org.bukkit.plugin.java.JavaPlugin;

public class PostWar extends JavaPlugin{

	@Getter private static PostWar instance;
	@Getter private ArenaManager arenaManager;
	@Getter private GameManager gameManager;
	
	@Override
	public void onLoad(){
		instance = this;
	}
	
	@Override
	public void onEnable(){
		arenaManager = new DefaultArenaManager();
		gameManager = new DefaultGameManager();
	}
	
	@Override
	public void onDisable(){
		
	}
	
}
