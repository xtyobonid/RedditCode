import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SymbolDrawing extends JPanel {
	private static final int CANVAS_WIDTH = 1000;
	private static final int CANVAS_HEIGHT = 1000;

	private static final int SYMBOL_WIDTH = 50;

	private static final Random RANDOM = new Random();

	private static final String CODE_TEXT = "i have a dream that one day even the state of mississippi, a state sweltering with the heat of injustice, sweltering with the heat of oppression will be transformed into an oasis of freedom and justice. i have a dream that my four little children will one day live in a nation where they will not be judged by the color of their skin, but by the content of their character. i have a dream today.";

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBackground(g);

		int symbolsPerLine = CANVAS_WIDTH/SYMBOL_WIDTH;

		for (int i = 0; i < CODE_TEXT.length(); i++) {
			int symbolNumber = getSymbolNumber(CODE_TEXT.substring(i, i+1));
			drawSymbol(g, symbolNumber, (i % symbolsPerLine) * SYMBOL_WIDTH, (i / symbolsPerLine) * SYMBOL_WIDTH);
		}
	}

	private void drawSymbol(Graphics g, int symbolNumber, int xAdj, int yAdj) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(84, 64, 53));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setStroke(new BasicStroke(2));

		int centerX = SYMBOL_WIDTH / 2;
		int centerY = SYMBOL_WIDTH / 2;
		
		int calculatedSymbolNumber = symbolNumber;

		// Segment 8
		if (calculatedSymbolNumber >= 128) {
			calculatedSymbolNumber -= 128;

			int radius = SYMBOL_WIDTH/5*2;
			g2d.drawOval(centerX - radius + xAdj, centerY - radius + yAdj - 1, radius * 2, radius * 2+2);
		}

		// Segment 7
		if (calculatedSymbolNumber >= 64) {
			calculatedSymbolNumber -= 64;

			int radius = SYMBOL_WIDTH/4;
			g2d.drawArc(centerX - radius + xAdj, centerY - radius + yAdj + 1, radius * 2, radius * 2, 135, 90);
		}

		// Segment 6
		if (calculatedSymbolNumber >= 32) {
			calculatedSymbolNumber -= 32;

			int radius = SYMBOL_WIDTH/5;
			g2d.drawLine(centerX + (int)(radius/Math.sqrt(2)) + xAdj + 1, centerY + (int)(radius/Math.sqrt(2)) + yAdj + 2, centerX + xAdj + 2, centerY + (int)((radius*2)/Math.sqrt(2)) + yAdj + 1);
		}

		// Segment 5
		if (calculatedSymbolNumber >= 16) {
			calculatedSymbolNumber -= 16;

			int radius = SYMBOL_WIDTH/5*2;
			g2d.drawLine(centerX - (int)(radius/Math.sqrt(2)) + xAdj, centerY + (int)(radius/Math.sqrt(2)) + yAdj, centerX + (int)(radius/Math.sqrt(2)) + xAdj, centerY - (int)(radius/Math.sqrt(2)) + yAdj);
		}

		// Segment 4
		if (calculatedSymbolNumber >= 8) {
			calculatedSymbolNumber -= 8;

			int radius = (int)(((float)SYMBOL_WIDTH)/4f);
			g2d.drawArc(centerX - radius + xAdj + 1, centerY - radius + yAdj, radius * 2, radius * 2, 315, 85);
		}

		// Segment 3
		if (calculatedSymbolNumber >= 4) {
			calculatedSymbolNumber -= 4;

			int radius = SYMBOL_WIDTH/5;
			g2d.drawLine(centerX - (int)(radius/Math.sqrt(2)) + xAdj - 1, centerY - (int)(radius/Math.sqrt(2)) + yAdj - 2, centerX + xAdj - 2, centerY - (int)((radius*2)/Math.sqrt(2)) + yAdj - 1);
		}

		// Segment 2
		if (calculatedSymbolNumber >= 2) {
			calculatedSymbolNumber -= 2;

			int radius = SYMBOL_WIDTH/5*2;
			g2d.drawLine(centerX - (int)(radius/Math.sqrt(2)) + xAdj, centerY - (int)(radius/Math.sqrt(2)) + yAdj, centerX + (int)(radius/Math.sqrt(2)) + xAdj, centerY + (int)(radius/Math.sqrt(2)) + yAdj);
		}
		
		// Segment 1
		if (calculatedSymbolNumber >= 1) {
			calculatedSymbolNumber -= 1;

			int radius = SYMBOL_WIDTH/10;
			g2d.fillOval(centerX - radius + xAdj + 1, centerY - radius + yAdj + 1, radius * 2 - 1, radius * 2 - 1);
		}
		
		if (calculatedSymbolNumber != 0) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("Invalid boolean conversion! Final calculation is " + calculatedSymbolNumber);
			System.out.println("Original number was: " + symbolNumber);
		}
	}

	private void drawBackground(Graphics g) {
		Random rand = new Random();
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				int colorValue = 130 + rand.nextInt(40);
				g.setColor(new Color(colorValue, colorValue, colorValue));
				g.drawLine(x, y, x, y);
			}
		}
	}

	private BufferedImage createImage() {
        	BufferedImage bufferedImage = new BufferedImage(CANVAS_WIDTH, CANVAS_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        	Graphics2D g2d = bufferedImage.createGraphics();
        	this.paintComponent(g2d); // Calls your existing paintComponent method
        	g2d.dispose();
        	return bufferedImage;
    	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Symbol Drawing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SymbolDrawing panel = new SymbolDrawing();
		panel.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// Save the image after the frame is visible
		BufferedImage image = panel.createImage();
        	try {
            		ImageIO.write(image, "png", new File("output.png"));
        	} catch (IOException e) {
            		e.printStackTrace();
        	}
	}

	private int getSymbolNumber(String letter) {
		int[] symbols = SymbolDefinitions.SYMBOLS.get(letter);
        	if (symbols == null) {
            		throw new IllegalArgumentException("Invalid character: " + letter);
        	}
        	return symbols[RANDOM.nextInt(symbols.length)];		
	}
}