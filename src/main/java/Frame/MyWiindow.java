package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MyWiindow extends javax.swing.JFrame {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private JTextField pathField;
	private JTextArea dirListArea;
	private JScrollPane jScrollPane1;
	private JButton gotoButton;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyWiindow inst = new MyWiindow();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public MyWiindow() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				pathField = new JTextField();
				getContentPane().add(pathField);
				pathField.setBounds(12, 21, 397, 39);
			}
			{
				gotoButton = new JButton();
				getContentPane().add(gotoButton);
				gotoButton.setText("\u8f6c\u5230...");
				gotoButton.setBounds(415, 21, 103, 34);
				gotoButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						gotoButtonActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(12, 66, 506, 260);
				{
					dirListArea = new JTextArea();
					jScrollPane1.setViewportView(dirListArea);
				}
			}
			pack();
			this.setSize(544, 365);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

	private void gotoButtonActionPerformed(ActionEvent evt) {

		/*
		 * //需求：将文本框中的文本转移到文本区域中 //1,获取文本框中的字符串。 String str =
		 * pathField.getText(); //2,将文本设置到文本区域中 dirListArea.setText(str); //
		 * 将文本框中的文本清除 pathField.setText("");
		 */

		/*
		 * 获取文本框中的目录，将该目录中的文件夹以及文件的名称显示在文本区域中。
		 */

		
		
		// 1,获取文本框中的路径。
		String str_dir = pathField.getText();

		// 2,将该路径封装成file对象。
		File dir = new File(str_dir);

		// 3,判断。
		if (dir.exists() && dir.isDirectory()) {

			
			//将前一次的内容清空。
			dirListArea.setText("");
//			String[] names = dir.list();
			File[] files = dir.listFiles(new FileFilter(){

				@Override
				public boolean accept(File pathname) {
					
					return !pathname.isHidden();
				}
				
			});

			for (File f : files) {
				dirListArea.append(f.getName()+LINE_SEPARATOR);
			}

		}

	}

}
