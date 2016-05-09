package com.sio.util;

import com.sio.graphics.DimensionSelector;
import com.sio.graphics.DirectionChooser;
import com.sio.graphics.PixelRaster;

public abstract class ImageCasterDelegatesFactory {
	protected static DirectionChooser directionChooser;
	protected static DimensionSelector dimensionSelector;
	protected static PixelRaster pixelRaster;
	
	public ImageCasterDelegatesFactory() {
	}

	public static DirectionChooser getDirectionChooser() {
		return directionChooser;
	}

	public static void setDirectionChooser(DirectionChooser directionChooser) {
		ImageCasterDelegatesFactory.directionChooser = directionChooser;
	}

	public static DimensionSelector getDimensionSelector() {
		return dimensionSelector;
	}

	public static void setDimensionSelector(DimensionSelector dimensionSelector) {
		ImageCasterDelegatesFactory.dimensionSelector = dimensionSelector;
	}

	public static PixelRaster getPixelRaster() {
		return pixelRaster;
	}

	public static void setPixelRaster(PixelRaster pixelRaster) {
		ImageCasterDelegatesFactory.pixelRaster = pixelRaster;
	}

	protected abstract void initialPixelRaster();
	
	protected abstract void initialDirectionChooser();
	
	protected abstract void initialDimensionSelector();
}
