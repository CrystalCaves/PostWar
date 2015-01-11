package it.crystalcaves.postwar;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class PostWar extends JavaPlugin{

	@Getter private PostWar instance;
	
	@Override
	public void onLoad(){
		instance=this;
	}
	
	@Override
	public void onEnable(){
		
	}
	
	@Override
	public void onDisable(){
		
	}
	
}
