package cookierun;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;

public class Util {
	public static int [] getSize(String src) throws Exception {
		File imgf = new File(src);
		BufferedImage img = ImageIO.read(imgf);
		int width = img.getWidth();
		int height = img.getHeight();
		int[] tempSize = {width,height};
		return tempSize;
	}
	
	
	public static int[][] getpic(String src) throws Exception{ // 색값을 가져오는 메소드
		File imgf = new File(src); // 매개변수로 받은 String를 넣어준다
		BufferedImage img = ImageIO.read(imgf); // 버퍼이미지 
		int width = img.getWidth(); // 버퍼된 이미지의 너비
		int height = img.getHeight();// 버퍼된 이미지의 높이
		int[]pixels = new int[width*height]; // int 배열로 너비*높이 선언
		
		PixelGrabber grab = new PixelGrabber(img, 0, 0, width, height, pixels,0,width);// 이미지 축소 로직
		grab.grabPixels(); // 픽셀 전송을 시작하도록 요청하고 모든 픽셀이 전송될때까지 기다립니다.
		
		int [][] picture = new int[width][height];
		for(int i=0;i<pixels.length;i++) {
			picture[i%width][i/width] = pixels[i]+16777216; // ?? 
		}
		return picture; // 버퍼된 이미지를 for를 거쳐서  [i%width][i/width] = pixels[i]+16777216; 처리후 내보냄
	}
	
	
		
	// 현재시간 가져오기
	public static long getTime() {
		return Timestamp.valueOf(LocalDateTime.now()).getTime(); 
	}
}
