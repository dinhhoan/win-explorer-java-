package javacuoiky;

import java.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class javaio extends JFrame implements ActionListener {

	JTextArea ta = new JTextArea();
	JButton open = new JButton("Mở File");
	JFileChooser chooser;
	FileReader fr;
	BufferedReader br;

	public javaio() {
		Container cont = this.getContentPane();
		open.addActionListener(this);
		cont.add(ta);
		cont.add(open, "Center");
		this.setSize(400, 400);
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("PC Đình Hoàn");
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			String filename = chooser.getSelectedFile().getAbsolutePath();
			readFile(filename);

		}
	}

	public void readFile(String filename) {
		try {
			ta.setText("");
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String s;
			while ((s = br.readLine()) != null) {
				ta.append(s + "\n");
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static public boolean deleteDirectory(File path) {
	    if (path.exists()) {
	        File[] files = path.listFiles();
	        for (int i = 0; i < files.length; i++) {
	            if (files[i].isDirectory()) {
	                deleteDirectory(files[i]);
	            } else {
	                files[i].delete();
	            }
	        }
	    }
	    return (path.delete());
	}

	public static void main(String[] args) {
		new javaio();

	}

}