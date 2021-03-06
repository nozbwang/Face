package com.zbwang.face.service.impl;

/**
 *  缩略图实现，将图片(jpg、bmp、png、gif等等)真实的变成想要的大小
 */
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 缩略图类（通用） 本java类能将jpg、bmp、png、gif图片文件，进行等比或非等比的大小转换。 具体使用方法
 * compressPic(大图片路径,生成小图片路径,大图片文件名,生成小图片文名,生成小图片宽度,生成小图片高度,是否等比缩放(默认为true))
 */
@Service
public class CompressService {

	// 图片处理
	public byte[] compressPic(byte[] content, int outputWidth, int outputHeight, boolean proportion) {
		InputStream in = new ByteArrayInputStream(content);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] result = null;
		try {
			BufferedImage img = ImageIO.read(in);
			if (img.getWidth(null) != -1) {
				// 如果图片尺寸较小，不要放大
				double width = (double) img.getWidth(null);
				double height = (double) img.getHeight(null);
				if (outputWidth >= width && outputHeight >= height) {
					return content;
				}
				int newWidth;
				int newHeight;
				// 判断是否是等比缩放
				if (proportion) {
					// 为等比缩放计算输出的图片宽度及高度
					double rate1 = ((double) img.getWidth(null)) / (double) outputWidth + 0.1;
					double rate2 = ((double) img.getHeight(null)) / (double) outputHeight + 0.1;
					// 根据缩放比率大的进行缩放控制
					double rate = rate1 > rate2 ? rate1 : rate2;
					newWidth = (int) (((double) img.getWidth(null)) / rate);
					newHeight = (int) (((double) img.getHeight(null)) / rate);
				} else {
					newWidth = outputWidth; // 输出的图片宽度
					newHeight = outputHeight; // 输出的图片高度
				}
				BufferedImage tag = new BufferedImage((int) newWidth, (int) newHeight, BufferedImage.TYPE_INT_RGB);

				/*
				 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
				 */
				tag.getGraphics().drawImage(img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH), 0, 0, null);
				// JPEGImageEncoder可适用于其他图片类型的转换
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(tag);
				result = out.toByteArray();
			}
		} catch (IOException e) {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(out);
		}
		return result;
	}

}
