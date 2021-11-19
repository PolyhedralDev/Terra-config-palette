/*
 * Copyright (c) 2020-2021 Polyhedral Development
 *
 * The Terra Core Addons are licensed under the terms of the MIT License. For more details,
 * reference the LICENSE file in this module's root directory.
 */

package com.dfsek.terra.addons.palette;

import com.dfsek.terra.addons.palette.palette.NoisePalette;
import com.dfsek.terra.addons.palette.palette.PaletteLayerHolder;
import com.dfsek.terra.api.Platform;
import com.dfsek.terra.api.config.ConfigFactory;
import com.dfsek.terra.api.world.generator.Palette;


public class PaletteFactory implements ConfigFactory<PaletteTemplate, Palette> {
    @Override
    public Palette build(PaletteTemplate config, Platform platform) {
        NoisePalette palette = new NoisePalette(config.getNoise());
        for(PaletteLayerHolder layer : config.getPalette()) {
            palette.add(layer.getLayer(), layer.getSize(), layer.getSampler());
        }
        return palette;
    }
}
