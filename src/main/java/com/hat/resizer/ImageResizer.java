package com.hat.resizer;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.hat.resizer.service.ImageResizerService;
import com.hat.resizer.util.DataCreator;

public class ImageResizer {

	public final static Logger logger = Logger.getLogger(ImageResizer.class);

	public static void main(String[] args) {
		logger.info("start program, running...");

		DataCreator creator = new DataCreator();
		ImageResizerService imageResizerService = new ImageResizerService();
		ResizerIn resizerIn = creator.resizeInCreator(args);
		List<File> images = null;
		if (resizerIn != null) {
			images = imageResizerService.getImagesFromDirectory(resizerIn);
			imageResizerService.resize(resizerIn, images);
		} else {
			logger.info("required parametre args[0]:EntryDirectoryPath");
			logger.info("Or required parametres args[0]:resizedSuffixName, args[1]:resizedPreffixName, args[2]:entryDirectoryPath,"
					+ " args[3]:outDirectoryPath, args[4]:imageExtention");
			logger.info("Or required parametres args[0]:resizedSuffixName, args[1]:resizedPreffixName, args[2]:entryDirectoryPath,"
					+ " args[3]:outDirectoryPath, args[4]:imageExtention,args[5]:targetWidth, args[6]:targetHeight");
		}
		logger.info("running finish.");

	}


}
