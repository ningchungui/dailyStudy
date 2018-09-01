package TCPUDP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
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
public class UploadPic extends javax.swing.JFrame {
	private JTextField pathField;
	private JButton uploadButton;
	private JButton browerButton;
	private File file;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UploadPic inst = new UploadPic();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public UploadPic() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				pathField = new JTextField();
				getContentPane().add(pathField);
				pathField.setBounds(21, 12, 278, 42);
			}
			{
				browerButton = new JButton();
				getContentPane().add(browerButton);
				browerButton.setText("\u6d4f\u89c8...");
				browerButton.setBounds(311, 12, 98, 42);
				browerButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						browerButtonActionPerformed(evt);
					}
				});
			}
			{
				uploadButton = new JButton();
				getContentPane().add(uploadButton);
				uploadButton.setText("\u4e0a    \u4f20");
				uploadButton.setBounds(104, 144, 217, 107);
				uploadButton.setFont(new java.awt.Font("宋体",0,28));
				uploadButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						try {
							uploadButtonActionPerformed(evt);
						} catch (IOException e) {
							
							e.printStackTrace();
						}
					}
				});
			}
			pack();
			this.setSize(456, 337);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	private void browerButtonActionPerformed(ActionEvent evt) {
		 JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(this);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		      
		    	file = chooser.getSelectedFile();
		           String path =  file.getAbsolutePath();
		           pathField.setText(path);
		    }

	}
	
	private void uploadButtonActionPerformed(ActionEvent evt) throws IOException {
		
Socket s = new Socket("192.168.1.200",10007);
		
		
		//客户端要读取图片。
		FileInputStream fis = new FileInputStream(file);
		
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=fis.read(buf))!=-1){
			out.write(buf,0,len);
		}
		
		//告诉服务端已经写完。
		s.shutdownOutput();
		
		InputStream in = s.getInputStream();
		//读取上传成功字样。
		byte[] bufIn = new byte[1024];
		int lenIn = in.read(bufIn);
//		System.out.println();
		String str = new String(bufIn,0,lenIn);
		pathField.setText(str);
		
		fis.close();
		s.close();
		
	}

}
