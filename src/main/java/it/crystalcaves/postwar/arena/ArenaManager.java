package it.crystalcaves.postwar.arena;

public interface ArenaManager {

	public boolean exists(String name);
	
	public Arena create(String name);
	
	public Arena loadArena(String name);
	
	public Arena getArena(String name);
	
	public String getArenaName(Arena arena);
	
	public boolean unloadArena(String name);
	
	public boolean save(String name);
	
}
