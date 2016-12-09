package com.zbwang.face.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zbwang.face.domain.Attach;
import com.zbwang.face.service.IAttachService;

@Controller
public class PictureController extends BaseController {

	@Autowired
	private IAttachService faceVoiceAttachService;

	@RequestMapping("/attach")
	public void getSmallAttach(String attachId, HttpServletResponse response) throws Exception {
		Attach faceVoiceAttach = faceVoiceAttachService.getAttachByAttachId(NumberUtils.toInt(attachId));
		if (faceVoiceAttach != null) {
			writeToBrowser(response, faceVoiceAttach.getSmallContent());
		}
	}

	@RequestMapping("/bigAttach")
	public void file(String attachId, HttpServletResponse response) throws Exception {
		Attach faceVoiceAttach = faceVoiceAttachService.getBigAttachByAttachId(NumberUtils.toInt(attachId));
		if (faceVoiceAttach != null) {
			response.setContentType("image/png");
			writeToBrowser(response, faceVoiceAttach.getBigContent());
		}
	}

	private void writeToBrowser(HttpServletResponse response, byte[] content) throws IOException {
		ByteArrayInputStream in = null;
		OutputStream out = null;
		try {
			in = new ByteArrayInputStream(content);
			out = response.getOutputStream();
			byte buffer[] = new byte[1024];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
	}
}
