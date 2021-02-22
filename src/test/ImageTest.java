package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

class ImageTest {

	@Test
	void test() {
		try {
//			一个image的引用,已经指向这个图片了,这个图片已经被加载至内存了
			BufferedImage image = ImageIO.read(new File("C:/Users/1/Desktop/timg.jpg"));
//			这两种都ok
//			BufferedImage image = ImageIO.read(new File("‪C:/Users/1/Desktop/timg.jpg"));
//			断言 判断条件成不成立,如果条件成立,则通过,条件不成立,则不通过    this.getClass()也可以  == ImageTest.class
			BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("test/image/80389869_957775897943014_6026160315417231360_o.jpg"));
			assertNotNull(image);
			assertNotNull(image2);
	
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}



}
