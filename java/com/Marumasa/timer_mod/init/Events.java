package com.Marumasa.timer_mod.init;

import com.Marumasa.timer_mod.keybind.ModKeyBind;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.NewChatGui;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDateTime;

public class Events {
    public Date date = null;

    @SubscribeEvent
    public void KeyInputEvent(InputEvent.KeyInputEvent event) {
        NewChatGui newchatgui = Minecraft.getInstance().gui.getChat();
        if (ModKeyBind.ModKeys[0].isDown()) {
            newchatgui.addMessage(new TranslationTextComponent("timer.timermod.start"));

            date = new Date();
            newchatgui.addMessage(new StringTextComponent(date.toString()));
        }

        if (ModKeyBind.ModKeys[1].isDown()) {
            if (date == null) {
                return;
            }
            newchatgui.addMessage(new TranslationTextComponent("timer.timermod.end"));

            LocalDateTime start = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
            LocalDateTime end = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());

            Duration result = Duration.between(start, end);
            String result_string = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.MIDNIGHT.plus(result));
            newchatgui.addMessage(new StringTextComponent(result_string));
        }
    }
}
