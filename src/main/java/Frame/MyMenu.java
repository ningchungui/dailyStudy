package Frame;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MyMenu extends javax.swing.JFrame {
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private JMenuBar jMenuBar1;
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JMenuItem openItem;
	private JMenuItem closeItem;
	private JMenu jMenu1;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyMenu inst = new MyMenu();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MyMenu() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1, BorderLayout.CENTER);
				{
					jTextArea1 = new JTextArea();
					jScrollPane1.setViewportView(jTextArea1);
				}
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("\u6587\u4ef6");
					{
						openItem = new JMenuItem();
						jMenu1.add(openItem);
						openItem.setText("\u6253\u5f00");
						openItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								try {
									openItemActionPerformed(evt);
								} catch (IOException e) {
									
									e.printStackTrace();
								}
							}
						});
					}
					{
						closeItem = new JMenuItem();
						jMenu1.add(closeItem);
						closeItem.setText("\u9000\u51fa");
						closeItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								closeItemActionPerformed(evt);
							}
						});
					}
				}
			}
			pack();
			setSize(400, 300);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void closeItemActionPerformed(ActionEvent evt) {
		System.exit(0);
	}
	
	private void openItemActionPerformed(ActionEvent evt) throws IOException {
		
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "Text", "java", "txt");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       
	    		jTextArea1.setText("");
	            File file = chooser.getSelectedFile();
	            
	            BufferedReader bufr = new BufferedReader(new FileReader(file));
	            
	            String line = null;
	            while((line=bufr.readLine())!=null){
	            	
	            	jTextArea1.append(line+LINE_SEPARATOR);
	            }
	            
	            bufr.close();
	            
	    }

	}

}
