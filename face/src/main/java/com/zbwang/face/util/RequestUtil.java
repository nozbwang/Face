package com.zbwang.face.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;

import com.zbwang.face.constant.FaceConstants;

public class RequestUtil {

	public static Map<String, Object> getElements(HttpServletRequest request) {
		Map<String, Object> elements = new HashMap<String, Object>();
		try {
			List<FileItem> list = getRequestItems(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String value = item.getString("UTF-8");
					if (StringUtils.isNotBlank(value)) {
						elements.put(item.getFieldName(), value);
					}
				} else if (FaceConstants.picContentTypes.contains(item.getContentType())) {
					elements.put(item.getFieldName(), item);
				}
			}
		} catch (Exception e) {

		}
		return elements;
	}

	private static List<FileItem> getRequestItems(HttpServletRequest request) throws FileUploadException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		return upload.parseRequest(request);
	}
}
