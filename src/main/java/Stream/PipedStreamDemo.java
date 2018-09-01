package Stream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */

	public static void main(String[] args) throws IOException {

		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);
		new Thread(new Input(in)).start();
		new Thread(new Output(out)).start();
		
	}

}


class Input implements Runnable{

	private PipedInputStream in;
	
	public Input(PipedInputStream in) {
		super();
		this.in = in;
	}

	@Override
	public void run() {
		
		byte[] buf = new byte[1024];
		int len;
		try {
			len = in.read(buf);//阻塞。
			String str = new String(buf,0,len);
			System.out.println(str);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
}

class Output implements Runnable{

	private PipedOutputStream out;
	
	public Output(PipedOutputStream out) {
		super();
		this.out = out;
	}

	@Override
	public void run() {
		
		try {
			out.write("哈哈哈，我来了!".getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
}