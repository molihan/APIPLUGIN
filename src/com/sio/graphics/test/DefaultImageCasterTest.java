package com.sio.graphics.test;

import static org.junit.Assert.*;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sio.graphics.DefaultImageCaster;

public class DefaultImageCasterTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRaster() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("d:/01.bmp"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DefaultImageCaster caster = new DefaultImageCaster();
		caster.raster(image, 296, 128, DefaultImageCaster.BUTTONRIGHT, DefaultImageCaster.HORIZONTAL, true, false, 1);
	}

}
