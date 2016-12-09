package com.zbwang.demo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Getpic {
	public Getpic() {
	}

	public static boolean saveUrlAs(String fileUrl, String savePath) {

		try {
			URL url = new URL(fileUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			DataInputStream in = new DataInputStream(connection.getInputStream());
			DataOutputStream out = new DataOutputStream(new FileOutputStream(savePath));
			byte[] buffer = new byte[4096];
			int count = 0;
			while ((count = in.read(buffer)) > 0) {
				out.write(buffer, 0, count);
			}
			out.close();
			in.close();
			connection.disconnect();
			return true;

		} catch (Exception e) {
			System.out.println(e + fileUrl + savePath);
			return false;
		}
	}

	public static void main(String[] args) {
		Getpic pic = new Getpic();
		String photoUrl = "http://fe.topitme.com/e/60/fb/1100892914633fb60eo.jpg";
		String fileName = photoUrl.substring(photoUrl.lastIndexOf("/"));
		String filePath = "E://";
		boolean flag = pic.saveUrlAs(photoUrl, filePath + fileName);
		System.out.println("Run ok!\n Get URL file " + flag);
	}

}