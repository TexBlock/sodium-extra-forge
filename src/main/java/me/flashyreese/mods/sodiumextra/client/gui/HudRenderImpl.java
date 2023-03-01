package me.flashyreese.mods.sodiumextra.client.gui;

import me.flashyreese.mods.sodiumextra.client.SodiumExtraClientMod;
import me.flashyreese.mods.sodiumextra.mixin.gui.MinecraftClientAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.common.MinecraftForge;

public class HudRenderImpl {
    private final MinecraftClient client = MinecraftClient.getInstance();

    public void register() {
        MinecraftForge.EVENT_BUS.addListener((event) -> {
            if (event instanceof RenderGuiEvent.Pre renderGuiEvent) {
                HudRenderImpl.this.onHudRender(renderGuiEvent.getPoseStack(), renderGuiEvent.getPartialTick());
            }
        });
    }

    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        if (!this.client.options.debugEnabled) {
            //Gotta love hardcoding
            if (SodiumExtraClientMod.options().extraSettings.showFps && SodiumExtraClientMod.options().extraSettings.showCoords) {
                this.renderFPS(matrixStack);
                this.renderCoords(matrixStack);
            } else if (SodiumExtraClientMod.options().extraSettings.showFps) {
                this.renderFPS(matrixStack);
            } else if (SodiumExtraClientMod.options().extraSettings.showCoords) {
                this.renderCoords(matrixStack);
            }
            if (!SodiumExtraClientMod.options().renderSettings.lightUpdates) {
                this.renderLightUpdatesWarning(matrixStack);
            }
        }
    }

    //Should I make this OOP or just leave as it :> I don't think I will be adding any more than these 2.
    private void renderFPS(MatrixStack matrices) {
        int currentFPS = MinecraftClientAccessor.getCurrentFPS();

        Text text = Text.translatable("sodium-extra.overlay.fps", currentFPS);

        if (SodiumExtraClientMod.options().extraSettings.showFPSExtended)
            text = Text.literal(String.format("%s %s", text.getString(), Text.translatable("sodium-extra.overlay.fps_extended", SodiumExtraClientMod.getClientTickHandler().getHighestFps(), SodiumExtraClientMod.getClientTickHandler().getAverageFps(),
                    SodiumExtraClientMod.getClientTickHandler().getLowestFps()).getString()));

        int x, y;
        switch (SodiumExtraClientMod.options().extraSettings.overlayCorner) {
            case TOP_LEFT -> {
                x = 2;
                y = 2;
            }
            case TOP_RIGHT -> {
                x = this.client.getWindow().getScaledWidth() - this.client.textRenderer.getWidth(text) - 2;
                y = 2;
            }
            case BOTTOM_LEFT -> {
                x = 2;
                y = this.client.getWindow().getScaledHeight() - this.client.textRenderer.fontHeight - 2;
            }
            case BOTTOM_RIGHT -> {
                x = this.client.getWindow().getScaledWidth() - this.client.textRenderer.getWidth(text) - 2;
                y = this.client.getWindow().getScaledHeight() - this.client.textRenderer.fontHeight - 2;
            }
            default ->
                    throw new IllegalStateException("Unexpected value: " + SodiumExtraClientMod.options().extraSettings.overlayCorner);
        }

        this.drawString(matrices, text, x, y);
    }

    private void renderCoords(MatrixStack matrices) {
        if (this.client.player == null) return;
        if (this.client.hasReducedDebugInfo()) return;
        Vec3d pos = this.client.player.getPos();

        Text text = Text.translatable("sodium-extra.overlay.coordinates", String.format("%.2f", pos.x), String.format("%.2f", pos.y), String.format("%.2f", pos.z));

        int x, y;
        switch (SodiumExtraClientMod.options().extraSettings.overlayCorner) {
            case TOP_LEFT -> {
                x = 2;
                y = 12;
            }
            case TOP_RIGHT -> {
                x = this.client.getWindow().getScaledWidth() - this.client.textRenderer.getWidth(text) - 2;
                y = 12;
            }
            case BOTTOM_LEFT -> {
                x = 2;
                y = this.client.getWindow().getScaledHeight() - this.client.textRenderer.fontHeight - 12;
            }
            case BOTTOM_RIGHT -> {
                x = this.client.getWindow().getScaledWidth() - this.client.textRenderer.getWidth(text) - 2;
                y = this.client.getWindow().getScaledHeight() - this.client.textRenderer.fontHeight - 12;
            }
            default ->
                    throw new IllegalStateException("Unexpected value: " + SodiumExtraClientMod.options().extraSettings.overlayCorner);
        }

        this.drawString(matrices, text, x, y);
    }

    private void renderLightUpdatesWarning(MatrixStack matrices) {
        Text text = Text.translatable("sodium-extra.overlay.light_updates");

        int x, y;
        switch (SodiumExtraClientMod.options().extraSettings.overlayCorner) {
            case TOP_LEFT -> {
                x = 2;
                y = 22;
            }
            case TOP_RIGHT -> {
                x = this.client.getWindow().getScaledWidth() - this.client.textRenderer.getWidth(text) - 2;
                y = 22;
            }
            case BOTTOM_LEFT -> {
                x = 2;
                y = this.client.getWindow().getScaledHeight() - this.client.textRenderer.fontHeight - 22;
            }
            case BOTTOM_RIGHT -> {
                x = this.client.getWindow().getScaledWidth() - this.client.textRenderer.getWidth(text) - 2;
                y = this.client.getWindow().getScaledHeight() - this.client.textRenderer.fontHeight - 22;
            }
            default ->
                    throw new IllegalStateException("Unexpected value: " + SodiumExtraClientMod.options().extraSettings.overlayCorner);
        }

        this.drawString(matrices, text, x, y);
    }

    private void drawString(MatrixStack matrices, Text text, int x, int y) {
        if (SodiumExtraClientMod.options().extraSettings.textContrast == SodiumExtraGameOptions.TextContrast.NONE) {
            this.client.textRenderer.draw(matrices, text, x, y, 0xffffffff);
        } else if (SodiumExtraClientMod.options().extraSettings.textContrast == SodiumExtraGameOptions.TextContrast.BACKGROUND) {
            DrawableHelper.fill(matrices, x - 1, y - 1, x + this.client.textRenderer.getWidth(text) + 1, y + this.client.textRenderer.fontHeight, -1873784752);
            this.client.textRenderer.draw(matrices, text, x, y, 0xffffffff);
        } else if (SodiumExtraClientMod.options().extraSettings.textContrast == SodiumExtraGameOptions.TextContrast.SHADOW) {
            this.client.textRenderer.drawWithShadow(matrices, text, x, y, 0xffffffff);
        }
    }
}
