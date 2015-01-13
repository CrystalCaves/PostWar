package it.crystalcaves.postwar.arena;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.bukkit.Location;

@NoArgsConstructor
@AllArgsConstructor
public class Arena {
	
	@Getter @Setter private Location corner1;
	@Getter @Setter private Location corner2;
	@Getter @Setter private int maxPlayers;
	@Getter @Setter private String mode;
	
}
