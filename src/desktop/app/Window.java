package desktop.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private int xSize, ySize, xLoc, yLoc;
	private Dimension screenSize;

	private JPanel panel;
	private JScrollPane pan;

	private int sum;

	private JLabel label;

	private JCheckBox num1 = new JCheckBox("12");
	private JCheckBox num2 = new JCheckBox("42");
	private JCheckBox num3 = new JCheckBox("201");

	public Window(JTree tree) {
		super("Panel");
		panel = new JPanel();
		pan = new JScrollPane(tree);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		xSize = 300;
		ySize = screenSize.height;
		xLoc = screenSize.width;
		yLoc = 0;
		panel.setLayout(new BorderLayout());
		createGUI();
		windowOpening();
		addWindowListener(new SlidingExit());
		pack();
	}

	private void createGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		label = new JLabel(sumToString(sum));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 20));
		panel.add(label, BorderLayout.CENTER);

		JPanel internalC = new JPanel();

		internalC.add(num1);

		num1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				updateText();
			}
		});

		internalC.add(num2);

		num2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				updateText();
			}
		});

		internalC.add(num3);

		num3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				updateText();
			}
		});

		panel.add(internalC, BorderLayout.NORTH);
		
		panel.add(pan, BorderLayout.SOUTH);
		getContentPane().add(panel);
		setVisible(true);
		setPreferredSize(new Dimension(xSize, ySize));
		setBounds(xLoc, yLoc, xSize, ySize);
	}

	private void updateText() {
		sum = 0;
		checkAllNum();
		label.setText(sumToString(sum));
	}

	public void checkAllNum() {
		if (num1.isSelected()) {
			sum += 12;
		}
		if (num2.isSelected()) {
			sum += 42;
		}
		if (num3.isSelected()) {
			sum += 201;
		}
	}

	private String sumToString(int sum2) {
		return Integer.toString(sum);
	}

	public void windowOpening() {

		for (; xLoc > screenSize.width - xSize; xLoc--) {
			setBounds(xLoc, yLoc, xSize, ySize);
		}
	}

	public class SlidingExit extends WindowAdapter {
		public void windowClosing(WindowEvent event) {
			for (; xLoc < screenSize.width - 20; xLoc++) {
				setBounds(xLoc, yLoc, xSize, ySize);
			}
		}
	}
}
