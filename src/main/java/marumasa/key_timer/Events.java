package marumasa.key_timer;

import marumasa.key_timer.keybind.ModKeyBind;
import marumasa.key_timer.util.Time;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class Events {
    private static final Minecraft mc = Minecraft.getInstance();
    private static long timer = 0;

    /* status

    0 タイマーが停止 初期状態
    1 タイマーが起動中
    2 タイマーが一時停止

     */
    private int status = 0;

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            switch (status) {
                case 0:
                    break;
                case 1:
                    mc.gui.setOverlayMessage(Time.toText(timer), false);
                    timer++;
                    break;
                case 2:
                    mc.gui.setOverlayMessage(Time.toText(timer), false);
                    break;
            }
        }
    }

    @SubscribeEvent
    public void KeyInputEvent(InputEvent.Key event) {

        ChatComponent chat = mc.gui.getChat();

        if (ModKeyBind.start_stop.isDown()) {

            switch (status) {
                case 0 -> {
                    chat.addMessage(Component.translatable("chat.key_timer.start"));
                    status = 1;
                }
                case 1 -> {
                    chat.addMessage(Component.translatable("chat.key_timer.stop").append(
                            Time.toTextChat(timer)
                    ));
                    status = 2;
                }
                case 2 -> {
                    chat.addMessage(Component.translatable("chat.key_timer.restart"));
                    status = 1;
                }
            }
        } else if (ModKeyBind.clear.isDown()) {
            if (status != 0) {
                mc.gui.setOverlayMessage(Component.empty(), false);
                chat.addMessage(Component.translatable("chat.key_timer.clear").append(
                        Time.toTextChat(timer)
                ));
                timer = 0;
                status = 0;
            }
        }
    }
}