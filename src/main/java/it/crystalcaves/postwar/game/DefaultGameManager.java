package it.crystalcaves.postwar.game;

import it.crystalcaves.postwar.PostWar;
import it.crystalcaves.postwar.arena.Arena;
import it.crystalcaves.postwar.yaml.YamlFile;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class DefaultGameManager implements GameManager{
	
	private YamlFile configFile;
	private FileConfiguration config;
	
	public DefaultGameManager(){
		configFile = new YamlFile(PostWar.getInstance(), "arenas.yml");
		config = configFile.getConfig();
	}
	
	@Override
	public boolean registerMode(String name, Class<? extends ArenaMode> mode) {
		return false;
	}

	@Override
	public boolean hasMode(String name) {
		return false;
	}

	@Override
	public boolean unregisterMode(String name) {
		return false;
	}

	@Override
	public boolean isPlaying(Player player) {
		return false;
	}

	@Override
	public Arena getArena(Player player) {
		return null;
	}

	@Override
	public List<Player> getPlayers(Arena arena) {
		return null;
	}
	
}