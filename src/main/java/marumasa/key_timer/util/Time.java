package marumasa.key_timer.util;

import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;

public class Time {
    public static Component toText(final long tick) {//actionbar

        int ms, sec, min, hour;

        hour = (int) (tick / 20) / 3600;
        min = (int) ((tick / 20) % 3600) / 60;
        sec = (int) (tick / 20) % 60;
        ms = (int) (tick % 20) * 5;

        return Component.translatable("actionbar.key_timer.timer",
                String.format("%01d", hour),
                String.format("%02d", min),
                String.format("%02d", sec),
                String.format("%02d", ms)
        );
    }

    public static Component toTextChat(final long tick) {//ChatText

        int ms, sec, min, hour;

        hour = (int) (tick / 20) / 3600;
        min = (int) ((tick / 20) % 3600) / 60;
        sec = (int) (tick / 20) % 60;
        ms = (int) (tick % 20) * 5;

        Style style = Style.EMPTY;
        style = style.withClickEvent(//クリックしたらタイマーのテキストをクリックボードにコピー イベント
                new ClickEvent(
                        ClickEvent.Action.COPY_TO_CLIPBOARD,
                        Component.translatable("actionbar.key_timer.timer",
                                String.format("%01d", hour),
                                String.format("%02d", min),
                                String.format("%02d", sec),
                                String.format("%02d", ms)
                        ).getString()
                )
        );

        style = style.withHoverEvent(//テキストに触れたら表示する文字 イベント
                new HoverEvent(
                        HoverEvent.Action.SHOW_TEXT,
                        Component.translatable("hover.key_timer.copy")
                )
        );

        return Component.translatable("actionbar.key_timer.timer",
                String.format("%01d", hour),
                String.format("%02d", min),
                String.format("%02d", sec),
                String.format("%02d", ms)
        ).setStyle(style);
    }
}