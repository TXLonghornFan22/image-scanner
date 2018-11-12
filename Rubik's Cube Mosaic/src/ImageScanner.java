import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Arrays;
import java.lang.Math;
import javax.swing.*;
import java.awt.*;

public class ImageScanner {
	public static void main(String[] args) throws IOException {
		BufferedImage img = null;
		File f = null;

		try {
			f = new File("C:\\Users\\TXLon\\OneDrive\\Desktop\\ImageScanner\\Kirby-Mario-Hat.jpg");
			img = ImageIO.read(f);
		} catch (IOException e) {
		}
		int x = 0;
		int y = 0;
		int width = img.getWidth();
		int height = img.getHeight();
		// int x = width - 3; - testing
		// System.out.println(width + " " + height);
		int[][] imageR;
		int[][] imageG;
		int[][] imageB;
		int[][] CubeColor;
		imageR = new int[height][width];
		imageG = new int[height][width];
		imageB = new int[height][width];

		CubeColor = new int[6][3];
		// Red = 0, Orange = 1, Green = 2, Blue = 3, White = 4, Yellow = 5.
		CubeColor[0][0] = 255;
		CubeColor[0][1] = 78;
		CubeColor[0][2] = 72; // Red
		CubeColor[1][0] = 255;
		CubeColor[1][1] = 127;
		CubeColor[1][2] = 61; // Orange
		CubeColor[2][0] = 77;
		CubeColor[2][1] = 182;
		CubeColor[2][2] = 77; // Green
		CubeColor[3][0] = 52;
		CubeColor[3][1] = 170;
		CubeColor[3][2] = 208; // Blue
		CubeColor[4][0] = 255;
		CubeColor[4][1] = 255;
		CubeColor[4][2] = 255; // White
		CubeColor[5][0] = 255;
		CubeColor[5][1] = 220;
		CubeColor[5][2] = 16; // Yellow

		while (x < width) {
			if (x < 328) {
				int p = img.getRGB(x, y);
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = p & 0xff;
				// System.out.println("While loop");

				imageR[y][x] = r;
				imageG[y][x] = g;
				imageB[y][x] = b;
				x++;
			} else {
				x = 0;
				y++;
				// System.out.println("if 1");
				if (y > height - 1) {
					// System.out.println("if 2");
					break;
				}
				// System.out.println("else");

			}
		}
		//System.out.print(imageR[164][170] + ", ");
		//System.out.print(imageG[164][170] + ", ");
		//System.out.print(imageB[164][170]);
		
		x = 0;
		y = 0;
		double r; double g; double b;
		double white; double yellow; double green; double blue; double red; double orange;
		double min;
		String newImage[][];
		newImage = new String[height][width];
		double average;
		String color = null;
		int windowSizex;
		int windowSizey;
		
		
		JFrame window = new JFrame();
		window.setTitle("Mosaic");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		Container pane = window.getContentPane();
		window.setVisible(true);
		
		
		
		
		while(x < width) {
			r = Math.abs(CubeColor[0][0] - imageR[x][y]);
			g = Math.abs(CubeColor[0][1] - imageG[x][y]);
			b = Math.abs(CubeColor[0][2] - imageB[x][y]);
			red = (r + g + b) / 3;
			r = Math.abs(CubeColor[1][1] - imageR[x][y]);
			g = Math.abs(CubeColor[1][2] - imageG[x][y]);
			b = Math.abs(CubeColor[1][3] - imageB[x][y]);
			orange = (r + g + b) / 3;
			r = Math.abs(CubeColor[2][1] - imageR[x][y]);
			g = Math.abs(CubeColor[2][2] - imageG[x][y]);
			b = Math.abs(CubeColor[2][3] - imageB[x][y]);
			green = (r + g + b) / 3;
			r = Math.abs(CubeColor[3][1] - imageR[x][y]);
			g = Math.abs(CubeColor[3][2] - imageG[x][y]);
			b = Math.abs(CubeColor[3][3] - imageB[x][y]);
			blue = (r + g + b) / 3;
			r = Math.abs(CubeColor[4][1] - imageR[x][y]);
			g = Math.abs(CubeColor[4][2] - imageG[x][y]);
			b = Math.abs(CubeColor[4][3] - imageB[x][y]);
			white = (r + g + b) / 3;
			r = Math.abs(CubeColor[5][1] - imageR[x][y]);
			g = Math.abs(CubeColor[5][2] - imageG[x][y]);
			b = Math.abs(CubeColor[5][3] - imageB[x][y]);
			yellow = (r + g + b) / 3;
			
			min = Math.min(red, Math.min(orange, (Math.min(green, Math.min(blue, Math.min(white, yellow))))));
			
			if(min == red) {
				color = "Red";
			}
			else if(min == orange) {
				color = "Orange";
			}
			else if(min == white) {
				color = "White";
			}
			else if(min == yellow) {
				color = "Yellow";
			}
			else if(min == blue) {
				color = "Blue";
			}
			else if(min == green) {
				color = "Green";
			}
			newImage[y][x] = color;
			
			// Take abs value (cube r, g, b subtracted by picture r, g, b). Then add the
			// color rgb and which ever one is the lowest is what it becomes.
		}
	}
}
