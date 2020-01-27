package horse.code.dynmap2discord;

import github.scarsz.discordsrv.DiscordSRV;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.dynmap.DynmapWebChatEvent;

public class DynmapChatListener implements Listener {
	private DiscordSRV discord;

	public DynmapChatListener(DiscordSRV discord) {
		this.discord = discord;
	}
	
	@EventHandler
	public void onDynmapMessage(DynmapWebChatEvent event) {
		if (event.isCancelled()) return;

		String name = event.getName();
		String message = event.getMessage();

		this.discord.getMainTextChannel().sendMessageFormat("**[WEB] %s:** %s", name, message).queue();
	}
}
