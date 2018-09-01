package TCPUDP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadPicServer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		ServerSocket ss = new ServerSocket(10007);
		while (true) {
			Socket s = ss.accept();

			new Thread(new UploadPic(s)).start();
		}

		// ss.close();

	}

}
