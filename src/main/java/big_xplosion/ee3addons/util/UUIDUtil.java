package big_xplosion.ee3addons.util;

import net.minecraft.entity.player.EntityPlayer;

import java.util.UUID;

public class UUIDUtil {

	public static String getPlayerUUIDString(EntityPlayer player) {
		return player != null && player.getGameProfile() != null ? getUUIDString(player.getGameProfile().getId()) : "";
	}

	public static String getUUIDString(UUID uuid) {
		return uuid != null ? uuid.toString() : "";
	}
}
