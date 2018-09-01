package TCPUDP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//多线程技术

public class UploadPic implements Runnable {

	private Socket s;

	public UploadPic(Socket s) {
		this.s = s;

	}

	@Override
	public void run() {

		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip + ".....connected");

		try {
			InputStream in = s.getInputStream();

			File dir = new File("e:\\pic");
			if (!dir.exists()) {
				dir.mkdirs();
			}
			int count = 1;

			File file = new File(dir, ip + "("+count+").jpg");
			while(file.exists()){
				file = new File(dir, ip + "("+(++count)+").jpg");
			}

			FileOutputStream fos = new FileOutputStream(file);

			byte[] buf = new byte[1024];

			int len = 0;
			while ((len = in.read(buf)) != -1) {
				fos.write(buf, 0, len);
			}

			OutputStream out = s.getOutputStream();
			out.write("上传成功".getBytes());

			fos.close();
			s.close();
		} catch (IOException e) {

		}
	}

}
