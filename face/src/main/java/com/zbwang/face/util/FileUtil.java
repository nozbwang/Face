package com.zbwang.face.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class FileUtil
{

	private static final Logger LOG = Logger.getLogger(FileUtil.class);

	public static String readFile(String fileName)
	{
		StringBuilder content = new StringBuilder();
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
			try
			{
				String line;
				while ((line = br.readLine()) != null)
				{
					content.append(line);
				}
			}
			finally
			{
				br.close();
			}
		}
		catch (Exception e)
		{
			LOG.error("Fail to read file into memory.", e);
		}
		return content.toString();
	}

}
