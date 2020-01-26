package horse.code.dynmap2discord;

import github.scarsz.discordsrv.DiscordSRV;
import github.scarsz.discordsrv.api.ApiManager;
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
		System.out.printf("received dynmap message: %s %s\n", event.getName(), event.getMessage());
		if (event.isCancelled()) return;
		System.out.println("not cancelled");

		String name = event.getName();
		String message = event.getMessage();

		this.discord.getMainTextChannel().sendMessageFormat("[WEB] %s >> %s", name, message).queue();
	}
}
