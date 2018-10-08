package br.ufc.qxd.Util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class SaveImage {
	public static void save_image(String path, MultipartFile image) {
		try {
			File file = new File(path);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void delete_image(String path) {
		File file = new File(path);
		if(file.exists()) {
			file.delete();
		}
	}
}
