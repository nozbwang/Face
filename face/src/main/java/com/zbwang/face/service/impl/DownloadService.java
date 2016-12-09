package com.zbwang.face.service.impl;

import java.io.DataInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.stereotype.Service;

@Service
public class DownloadService {

	public byte[] getPictureFromRemoteUrl(String fileUrl) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DataInputStream in = null;
		try {
			URL url = new URL(fileUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			in = new DataInputStream(connection.getInputStream());
			byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = in.read(buffer)) > 0) {
				out.write(buffer, 0, count);
			}
			connection.disconnect();
			return out.toByteArray();
		} catch (Exception e) {
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
		return null;
	}

}