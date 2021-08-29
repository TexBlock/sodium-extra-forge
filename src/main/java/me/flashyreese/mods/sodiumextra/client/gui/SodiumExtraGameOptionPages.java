package me.flashyreese.mods.sodiumextra.client.gui;

import com.google.common.collect.ImmutableList;
import me.flashyreese.mods.sodiumextra.client.gui.options.control.SliderControlExtended;
import me.flashyreese.mods.sodiumextra.client.gui.options.storage.SodiumExtraOptionsStorage;
import me.jellysquid.mods.sodium.client.gui.options.OptionFlag;
import me.jellysquid.mods.sodium.client.gui.options.OptionGroup;
import me.jellysquid.mods.sodium.client.gui.options.OptionImpl;
import me.jellysquid.mods.sodium.client.gui.options.OptionPage;
import me.jellysquid.mods.sodium.client.gui.options.control.ControlValueFormatter;
import me.jellysquid.mods.sodium.client.gui.options.control.SliderControl;
import me.jellysquid.mods.sodium.client.gui.options.control.TickBoxControl;

import java.util.ArrayList;
import java.util.List;

public class SodiumExtraGameOptionPages {
    public static final SodiumExtraOptionsStorage sodiumExtraOpts = new SodiumExtraOptionsStorage();

    public static OptionPage animation() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Animations")
                        .setTooltip("Toggle all animation")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.animation = value, opts -> opts.animationSettings.animation)
                        .build()
                )
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Animate Water")
                        .setTooltip("Toggle for water animation")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.animateWater = value, opts -> opts.animationSettings.animateWater)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Animate Lava")
                        .setTooltip("Toggle for lava animation")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.animateLava = value, opts -> opts.animationSettings.animateLava)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Animate Fire")
                        .setTooltip("Toggle for fire animation")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.animateFire = value, opts -> opts.animationSettings.animateFire)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Animate Portal")
                        .setTooltip("Toggle for portal animation")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.animationSettings.animatePortal = value, opts -> opts.animationSettings.animatePortal)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Block Animations")
                        .setTooltip("Process block animations")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.animationSettings.blockAnimations = value, options -> options.animationSettings.blockAnimations)
                        .build()
                )
                .build());
        return new OptionPage("Animations", ImmutableList.copyOf(groups));
    }

    public static OptionPage particle() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Particles")
                        .setTooltip("Toggle all particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.particles = value, opts -> opts.particleSettings.particles)
                        .build()
                )
                .build());

        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Rain Splash")
                        .setTooltip("Toggle for rain splash particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.rainSplash = value, opts -> opts.particleSettings.rainSplash)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Explosions")
                        .setTooltip("Toggle for explosion particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.explosion = value, opts -> opts.particleSettings.explosion)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Water")
                        .setTooltip("Toggle for water particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.water = value, opts -> opts.particleSettings.water)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Smoke")
                        .setTooltip("Toggle for smoke particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.smoke = value, opts -> opts.particleSettings.smoke)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Potions")
                        .setTooltip("Toggle for potion particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.potion = value, opts -> opts.particleSettings.potion)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Portal")
                        .setTooltip("Toggle for portal particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.portal = value, opts -> opts.particleSettings.portal)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Redstone")
                        .setTooltip("Toggle for redstone particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.redstone = value, opts -> opts.particleSettings.redstone)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Dripping Particles")
                        .setTooltip("Toggle for drip particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.drip = value, opts -> opts.particleSettings.drip)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Fireworks")
                        .setTooltip("Toggle for fireworks particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.firework = value, opts -> opts.particleSettings.firework)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Bubbles")
                        .setTooltip("Toggle for bubble particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.bubble = value, opts -> opts.particleSettings.bubble)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Environment")
                        .setTooltip("Toggle for environment particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.environment = value, opts -> opts.particleSettings.environment)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Villagers")
                        .setTooltip("Toggle for villagers particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.villagers = value, opts -> opts.particleSettings.villagers)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Composter")
                        .setTooltip("Toggle for composter particles")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.particleSettings.composter = value, opts -> opts.particleSettings.composter)
                        .build()
                )
                .build());
        return new OptionPage("Particles", ImmutableList.copyOf(groups));
    }

    public static OptionPage detail() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Rain & Snow")
                        .setTooltip("Toggle for rain & snow")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.detailSettings.rainSnow = value, opts -> opts.detailSettings.rainSnow)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Biome Colors")
                        .setTooltip("Biome colors change based on the biome")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.detailSettings.biomeColors = value, options -> options.detailSettings.biomeColors)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Sky Colors")
                        .setTooltip("Have sky colors change based on biome")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.detailSettings.skyColors = value, options -> options.detailSettings.skyColors)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .build());
        return new OptionPage("Details", ImmutableList.copyOf(groups));
    }

    public static OptionPage render() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Fog")
                        .setTooltip("If enabled, a fog effect will be used for terrain in the distance. Disabling this option will not change fog effects used underwater or in the Nether.")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderSettings.fog = value, opts -> opts.renderSettings.fog)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Light Updates")
                        .setTooltip("Process lighting updates")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.lightUpdates = value, options -> options.renderSettings.lightUpdates)
                        .build()
                )
                .build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Item Frames")
                        .setTooltip("Toggle to render item frames.")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.renderSettings.itemFrame = value, opts -> opts.renderSettings.itemFrame)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Armor Stands")
                        .setTooltip("Toggle to render armor stands.")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.armorStand = value, options -> options.renderSettings.armorStand)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Paintings")
                        .setTooltip("Toggle to render paintings.")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.painting = value, options -> options.renderSettings.painting)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Piston")
                        .setTooltip("Process piston animations")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.renderSettings.piston = value, options -> options.renderSettings.piston)
                        .build()
                )
                .build());
        return new OptionPage("Render", ImmutableList.copyOf(groups));
    }

    public static OptionPage extra() {
        List<OptionGroup> groups = new ArrayList<>();
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, SodiumExtraGameOptionPages.sodiumExtraOpts)
                        .setName("Use Fast Random")
                        .setTooltip("If enabled, a fast random function will be used for block rendering. This can affect the rotation of randomly rotated textures when compared to vanilla.")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.useFastRandom = value, options -> options.extraSettings.useFastRandom)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                ).build());
        groups.add(OptionGroup.createBuilder()
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Show FPS")
                        .setTooltip("Show current, max, average and min FPS on top left corner")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.extraSettings.showFps = value, opts -> opts.extraSettings.showFps)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Show Coordinates")
                        .setTooltip("Show coordinates on top left corner")
                        .setControl(TickBoxControl::new)
                        .setBinding((opts, value) -> opts.extraSettings.showCoords = value, opts -> opts.extraSettings.showCoords)
                        .build()
                )
                .add(OptionImpl.createBuilder(int.class, sodiumExtraOpts)
                        .setName("Cloud Height")
                        .setTooltip("Adjust height of clouds")
                        .setControl(option -> new SliderControl(option, 0, 255, 1, ControlValueFormatter.number()))
                        .setBinding((options, value) -> options.extraSettings.cloudHeight = value, options -> options.extraSettings.cloudHeight)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Toasts")
                        .setTooltip("Advancement and crafting recipe popups")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.toasts = value, options -> options.extraSettings.toasts)
                        .build())

                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Static FOV")
                        .setTooltip("Don't change FOV based on speed or effects")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.staticFov = value, options -> options.extraSettings.staticFov)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Instant Sneak")
                        .setTooltip("Don't lerp the camera to sneak")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.instantSneak = value, options -> options.extraSettings.instantSneak)
                        .build()
                )
                .add(OptionImpl.createBuilder(boolean.class, sodiumExtraOpts)
                        .setName("Prevent Shaders")
                        .setTooltip("Prevents any types of shaders from loading")
                        .setControl(TickBoxControl::new)
                        .setBinding((options, value) -> options.extraSettings.preventShaders = value, options -> options.extraSettings.preventShaders)
                        .setFlags(OptionFlag.REQUIRES_RENDERER_RELOAD)
                        .build()
                )
                .build());

        return new OptionPage("Extras", ImmutableList.copyOf(groups));
    }
}
