package desktop.app;

import java.awt.FontFormatException;
import java.io.IOException;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class MyTree implements TreeSelectionListener {

	private DefaultMutableTreeNode root;
	private JTree tree;
	private MyFont font;

	public MyTree(MyFont font) throws FontFormatException, IOException {
		this.font = font;
		createTree();
	}

	private void createTree() throws FontFormatException, IOException {

		root = new DefaultMutableTreeNode("root");
		DefaultMutableTreeNode father = new DefaultMutableTreeNode("father");
		DefaultMutableTreeNode mother = new DefaultMutableTreeNode("mother");
		root.add(father);
		root.add(mother);
		DefaultMutableTreeNode grandFatherFather = new DefaultMutableTreeNode(
				"grandfather");
		DefaultMutableTreeNode grandMotherFather = new DefaultMutableTreeNode(
				"grandmother");
		DefaultMutableTreeNode grandMotherMother = new DefaultMutableTreeNode(
				"grandmother");
		DefaultMutableTreeNode grandFatherMother = new DefaultMutableTreeNode(
				"grandfather");
		father.add(grandFatherFather);
		father.add(grandMotherFather);
		mother.add(grandMotherMother);
		mother.add(grandFatherMother);
		grandFatherFather.add(new DefaultMutableTreeNode("and Other"));
		grandMotherFather.add(new DefaultMutableTreeNode("and Other"));
		grandMotherMother.add(new DefaultMutableTreeNode("and Other"));
		grandFatherMother.add(new DefaultMutableTreeNode("and Other"));

		tree = new JTree(root);
		tree.setFont(font.getFont());
		tree.addTreeSelectionListener(this);
	}

	public JTree getTree() {
		return tree;
	}

	@Override
	public void valueChanged(TreeSelectionEvent e) {
	}

}
