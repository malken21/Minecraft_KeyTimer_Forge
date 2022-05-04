package com.Marumasa.timer_mod.keybind;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = "timer_mod", bus = Bus.MOD, value = Dist.CLIENT)
public class SetupEvent {
    @SubscribeEvent
    public static void Setup(FMLClientSetupEvent event) {
        ModKeyBind.register(event);
    }
}
