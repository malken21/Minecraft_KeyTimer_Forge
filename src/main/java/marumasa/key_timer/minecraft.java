package marumasa.key_timer;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(minecraft.MODID)
public class minecraft {
    public static final String MODID = "key_timer";

    public minecraft() {
        MinecraftForge.EVENT_BUS.register(new Events());
    }
}