package ml.ikwid.banharmingtwoarrows;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Banharmingtwoarrows implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("Bantippedarrows");
    @Override
    public void onInitialize() {
        LOGGER.info("banning certain tipped arrows");
    }
}
