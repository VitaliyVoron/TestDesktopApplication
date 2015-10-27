package desktop.app;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class MyFont {

	private Font myFont;
	private String fontFileName;

	public MyFont(String fontFileName) throws FontFormatException, IOException {
		this.fontFileName = fontFileName;
		addFont();
	}

	public Font getFont() {
		return myFont;
	}

	public void addFont() throws FontFormatException, IOException {
		
		Font font = null;

		try {
			font = Font.createFont(0, new File(fontFileName));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		myFont = font.deriveFont(1, 16f);
	}

}
