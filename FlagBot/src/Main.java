import javax.security.auth.login.LoginException;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

public class Main {

	public static JDA jda;
	public static String prefix = "!";

	public static void main(String[] args) throws LoginException {

		jda = new JDABuilder(AccountType.BOT).setToken("/*INSERT TOKEN HERE*/").build();
		jda.getPresence().setStatus(OnlineStatus.ONLINE);
		jda.getPresence().setGame(Game.playing("!flagguesser"));

		// event listeners
		jda.addEventListener(new FlagGuesser());

	}

}
