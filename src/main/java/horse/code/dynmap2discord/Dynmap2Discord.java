package horse.code.dynmap2discord;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.api.ApiManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.dynmap.DynmapAPI;

public class Dynmap2Discord extends JavaPlugin {
	@Override
	public void onEnable() {
		DynmapAPI dynmap = (DynmapAPI) getServer().getPluginManager().getPlugin("dynmap");
		DiscordSRV discord = (DiscordSRV) getServer().getPluginManager().getPlugin("DiscordSRV");

		DiscordChatListener fromDiscord = new DiscordChatListener(dynmap);
		discord.api.subscribe(fromDiscord);

		getServer().getPluginManager().registerEvents(new DynmapChatListener(discord), this);

		getLogger().info("Dynmap2Discord loaded successfully!");
	}
}
