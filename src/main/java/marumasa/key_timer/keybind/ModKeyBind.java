package marumasa.key_timer.keybind;

import marumasa.key_timer.minecraft;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import java.awt.event.KeyEvent;

@Mod.EventBusSubscriber(modid = minecraft.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ModKeyBind {
    public static final KeyMapping start_stop = crate("key.key_timer.start_stop", KeyEvent.VK_I);
    public static final KeyMapping clear = crate("key.key_timer.clear", KeyEvent.VK_O);

    public static KeyMapping crate(String lang, int key) {
        return new KeyMapping(lang, key, "key.category.key_timer");
    }

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) {
        event.register(start_stop);
        event.register(clear);
    }
}