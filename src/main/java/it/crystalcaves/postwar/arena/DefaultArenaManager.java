package it.crystalcaves.postwar.arena;

import it.crystalcaves.postwar.PostWar;
import it.crystalcaves.postwar.util.SerializationUtils;
import it.crystalcaves.postwar.yaml.YamlFile;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class DefaultArenaManager implements ArenaManager{
	
	private Map<String, Arena> arenas;
	private YamlFile configFile;
	private FileConfiguration config;
	
	public DefaultArenaManager() {
		arenas = new HashMap<String, Arena>();
		configFile = new YamlFile(PostWar.getInstance(), "arenas.yml");
		config = configFile.getConfig();
		loadAll();
	}
	
	private void loadAll(){
		for(String name: config.getKeys(false)){
				loadArena(name);
		}
	}
	
	@Override
	public boolean exists(String name) {
		return arenas.containsKey(name);
	}

	@Override
	public Arena create(String name) {
		return null;
	}

	@Override
	public Arena loadArena(String name) {
		if(!config.contains(name))
			return null;
		Location corner1 = SerializationUtils.stringToLocation(config.getString(name+".corner1"));
		Location corner2 = SerializationUtils.stringToLocation(config.getString(name+".corner2"));
		int maxPlayers = config.getInt(name+".max-players");
		String mode = config.getString(name+".mode");
		Arena arena = new Arena(corner1, corner2, maxPlayers, mode);
		arenas.put(name, arena);
		return arena;
	}

	@Override
	public Arena getArena(String name) {
		return arenas.get(name);
	}

	@Override
	public String getArenaName(Arena arena) {
		return null;
	}
	
	@Override
	public boolean unloadArena(String name) {
		if(!arenas.containsKey(name))
			return false;
		arenas.remove(name);
		return true;
	}

	@Override
	public boolean save(String name) {
		Arena arena = getArena(name);
		if(arena == null)
			return false;
		
		config.set(name+".corner1", SerializationUtils.locationToString(arena.getCorner1()));
		config.set(name+".corner2", SerializationUtils.locationToString(arena.getCorner2()));
		config.set(name+".max-players", arena.getMaxPlayers());
		config.set(name+".mode", arena.getMode());
		return true;
	}

}
