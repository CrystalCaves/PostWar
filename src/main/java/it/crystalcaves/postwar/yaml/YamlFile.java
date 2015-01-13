package it.crystalcaves.postwar.yaml;

import java.io.File;
import java.io.IOException;

import lombok.Getter;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class YamlFile {

	private JavaPlugin plugin;
	private File file;
	@Getter private FileConfiguration config;
	
	public YamlFile(JavaPlugin plugin, File datafolder, String name) {
		this.plugin = plugin;
		file = new File(datafolder, name);
		plugin.saveResource(name, false);
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	public YamlFile(JavaPlugin plugin, String name){
		this(plugin, plugin.getDataFolder(), name);
	}
	
	public void save(){
		try{
			config.save(file);
		}catch(IOException ex){
			plugin.getLogger().warning("Could not save config "+file.getName());
			ex.printStackTrace();
		}
	}

}