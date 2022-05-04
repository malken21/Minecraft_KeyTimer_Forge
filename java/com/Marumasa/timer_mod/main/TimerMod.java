package com.Marumasa.timer_mod.main;

import com.Marumasa.timer_mod.init.Events;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;


@Mod("timer_mod")
public class TimerMod {
    public static final String MOD_ID = "timer_mod";
    public TimerMod(){
        MinecraftForge.EVENT_BUS.register((new Events()));
    }
}
