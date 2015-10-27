package desktop.app;

import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws FontFormatException, IOException {
		String fontFieName = "festus.ttf";
		MyFont font = new MyFont(fontFieName);
		MyTree myTree = new MyTree(font);
		JFrame myWindow = new Window(myTree.getTree());
		myWindow.pack();
	}

}
