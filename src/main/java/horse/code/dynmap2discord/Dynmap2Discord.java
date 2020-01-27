package horse.code.dynmap2discord;

import github.scarsz.discordsrv.DiscordSRV;
import org.bukkit.plugin.java.JavaPlugin;
import org.dynmap.DynmapAPI;

public class Dynmap2Discord extends JavaPlugin {
	private DynmapAPI dynmap;
	private DiscordSRV discord;
	private DiscordChatListener fromDiscord;

	@Override
	public void onEnable() {
		this.dynmap = (DynmapAPI) getServer().getPluginManager().getPlugin("dynmap");
		this.discord = (DiscordSRV) getServer().getPluginManager().getPlugin("DiscordSRV");

		this.fromDiscord = new DiscordChatListener(this.dynmap);
		this.discord.api.subscribe(this.fromDiscord);

		getServer().getPluginManager().registerEvents(new DynmapChatListener(this.discord), this);

		getLogger().info("Dynmap2Discord loaded successfully!");
	}

	@Override
	public void onDisable() {
		if (this.discord != null && this.fromDiscord != null) {
			this.discord.api.unsubscribe(this.fromDiscord);
			this.discord = null;
			this.fromDiscord = null;
		}
	}
}
