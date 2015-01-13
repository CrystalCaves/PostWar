package it.crystalcaves.postwar.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class SerializationUtils {

	public static Location stringToLocation(String strLoc){
		strLoc = strLoc.replace('|', '.');
		String[] coord = strLoc.split(",");
		double[] parse = new double[3];
		for(int a = 0; a < 3; a++)
			parse[a] = Double.parseDouble(coord[a+1]);
		return new Location(Bukkit.getWorld(coord[0]), parse[0], parse[1], parse[2]);
	}
	
	public static String locationToString(Location loc){
		StringBuilder builder = new StringBuilder();
		builder.append(loc.getWorld().getName()).append(',');
		builder.append(loc.getX()).append(',');
		builder.append(loc.getY()).append(',');
		builder.append(loc.getZ());
		return builder.toString().replace('.', '|');
	}
	
}
