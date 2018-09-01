package Frame;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//1，创建Frame对象。
		Frame f = new Frame();
		
		//2,对窗体进行基本设置。
		f.setLayout(new FlowLayout());
		f.setSize(500, 400);
		f.setLocation(400, 150);
		
		//3,创建需要往窗体添加的组件。比如按钮。
		Button but = new Button("my button");
		
		//4,将按钮添加到窗体中。
		f.add(but);
		
		
		TextField tf = new TextField(20);
		
		f.add(tf);
		
		/*
		 * 需求：点击按钮就要有效果。
		 * 1，事件源：按钮。
		 * 2，事件：ActionEvent
		 * 3，监听器：ActionListener
		 * 4，处理方式：actionPerformed
		 * 
		 */
		//1,通过事件源的方法，将监听器注册到事件源上。
		/*but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				System.out.println("button run.."+e);
				System.exit(0);
				
			}
		});*/
		
		//在按钮上添加鼠标监听。
		but.addMouseListener(new MouseAdapter(){
			private int count;
			@Override
			public void mouseClicked(MouseEvent e) {
				
//				System.out.println("clicked ..."+count++);
//				System.out.println("clicked count :"+e.getClickCount());
				if(e.getClickCount()==2){//判断双击。
					System.out.println("double click");
				}
			}
			
		});
		
		
		
		
		
		/*
		 * 在文本框中添加键盘监听。
		 */
		tf.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				
//				System.out.println(e.getKeyCode()+":"+KeyEvent.getKeyText(e.getKeyCode()));
				int code = e.getKeyCode();
				
				/*
				if(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9){
					System.out.println("ok");
				}
				else{
					e.consume();
					System.out.println("只能是数字");
				}
				*/
				if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_ENTER){
					System.out.println("ctrl+enter run");
				}
			}
			
		});
		
		/*
		 * 在窗体上添加一个关闭。
		 * 
		 * 事件源：Frame
		 * 事件：WindowEvent
		 * 事件监听器：WindowListener
		 * 事件处理：
		 */
		
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				
//				System.out.println("我关！");
				System.exit(0);
			}
			
		}
		);
		
		
		
		//显示窗体
		f.setVisible(true);
		
		System.out.println("hello");
	}

}
