package com.hat.resizer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;

public class ImageResizer {

	public final static Logger logger = Logger.getLogger(ImageResizer.class);

	private List<File> images = new ArrayList<File>();

	public static void main(String[] args) {
		logger.info("start program, running...");

		ImageResizer imageResizer = new ImageResizer();
		ResizerIn resizerIn;
		// String resizedSuffixName, String resizedPreffixName,
		// String entryDirectoryPath, String outDirectoryPath,
		// String imageExtention, Integer targetWidth, Integer targetHeight
		resizerIn = imageResizer.getResizeIn(args);
		if (resizerIn != null) {
			imageResizer.getImagesFromDirectory(resizerIn);
			imageResizer.resize(resizerIn);
		} else {
			logger.info("required parametre args[0]:EntryDirectoryPath");
			logger.info("Or required parametres args[0]:resizedSuffixName, args[1]:resizedPreffixName, args[2]:entryDirectoryPath,"
					+ " args[3]:outDirectoryPath, args[4]:imageExtention");
			logger.info("Or required parametres args[0]:resizedSuffixName, args[1]:resizedPreffixName, args[2]:entryDirectoryPath,"
					+ " args[3]:outDirectoryPath, args[4]:imageExtention,args[5]:targetWidth, args[6]:targetHeight");
		}
		logger.info("running finish.");

	}

	private ResizerIn getResizeIn(String[] args) {
		ResizerIn resizerIn = null;
		if (args != null && args.length == 1) {
			resizerIn = new ResizerIn();
			resizerIn.setEntryDirectoryPath(args[0]);
		} else if (args != null && args.length == 5) {
			resizerIn = new ResizerIn(args[0], args[1], args[2], args[3],
					args[4]);
		} else if (args != null && args.length == 7) {
			resizerIn = new ResizerIn(args[0], args[1], args[2], args[3],
					args[4], Integer.valueOf(args[5]), Integer.valueOf(args[6]));
		}
		return resizerIn;
	}

	public void resize(ResizerIn resizerIn) {

		boolean checkDirectory = checkDirectory(resizerIn);
		if (!checkDirectory)
			return;
		if (images != null && images.size() > 0) {
			int targetWidth = getTargetWidh(resizerIn);
			int targetHeight = getTargetHeight(resizerIn);

			String imageExtention = resizerIn.getImageExtention();
			getImageExtention(resizerIn, imageExtention);

			for (File imageFile : images) {
				BufferedImage img;
				try {
					img = ImageIO.read(imageFile);
				} catch (IOException e) {
					logger.error(
							"Error occured while trying to read imageFile :", e);
					return;
				}

				BufferedImage scaledImg = Scalr.resize(img, Method.QUALITY,
						targetWidth, targetHeight, Scalr.OP_ANTIALIAS);
				StringBuilder sb = getImageName(resizerIn, imageFile);
				saveImage(sb.toString(), scaledImg,
						resizerIn.getImageExtention());
			}
		}
	}

	private boolean checkDirectory(ResizerIn resizerIn) {
		File folder = new File(resizerIn.getOutDirectoryPath());
		boolean checkDirectory = true;
		if (!folder.isDirectory() && folder.exists()) {
			logger.error("The ".concat(resizerIn.getOutDirectoryPath()).concat(
					" is not a directory."));
			checkDirectory = false;
		}
		if (!folder.exists()) {
			File outDirectory = new File(resizerIn.getOutDirectoryPath());
			checkDirectory = outDirectory.mkdir();
			if (!checkDirectory) {
				logger.error("Error occured while trying to create  ".concat(
						resizerIn.getOutDirectoryPath()).concat(" directory."));
			} else {
				logger.info("Create outPut directory : ".concat(resizerIn
						.getOutDirectoryPath()));
			}
		}
		return checkDirectory;
	}

	private StringBuilder getImageName(ResizerIn resizerIn, File imageFile) {
		StringBuilder sb = new StringBuilder();
		sb.append(resizerIn.getOutDirectoryPath()).append("/");
		if (StringUtils.isNoneBlank(resizerIn.getResizedPreffixName())) {
			sb.append(resizerIn.getResizedPreffixName());
		}
		sb.append(imageFile.getName());
		if (StringUtils.isNoneBlank(resizerIn.getResizedSuffixName())) {
			sb.append(resizerIn.getResizedSuffixName());
		}
		return sb;
	}

	private void getImageExtention(ResizerIn resizerIn, String imageExtention) {
		if (StringUtils.isNotBlank(imageExtention)) {
			imageExtention = imageExtention.toLowerCase();
		} else {
			imageExtention = "JPG";
			resizerIn.setImageExtention(imageExtention);
			logger.info("Resize defaut extention ".concat(imageExtention));
		}
	}

	private int getTargetHeight(ResizerIn resizerIn) {
		int targetHeight;
		if (resizerIn.getTargetHeight() == null) {
			targetHeight = 800;
			logger.info("Resize defaut Height " + targetHeight);
		} else {
			targetHeight = resizerIn.getTargetHeight();
		}
		return targetHeight;
	}

	private int getTargetWidh(ResizerIn resizerIn) {
		int targetWidth;
		if (resizerIn.getTargetHeight() == null) {
			targetWidth = 1400;
			logger.info("Resize defaut Width " + targetWidth);
		} else {
			targetWidth = resizerIn.getTargetHeight();
		}
		return targetWidth;
	}

	public void getImagesFromDirectory(ResizerIn resizerIn) {
		File folder = new File(resizerIn.getEntryDirectoryPath());
		if (!folder.exists() || !folder.isDirectory())
			return;

		for (final File fileEntry : folder.listFiles()) {
			if (!fileEntry.isDirectory() && isImageFile(fileEntry.getName())) {
				images.add(fileEntry);
			}
		}
	}

	public boolean isImageFile(String imageName) {
		boolean isImageFile = false;
		if (StringUtils.isNoneBlank(imageName)) {
			imageName = imageName.toUpperCase();
			if ((imageName.endsWith("JPG") || imageName.endsWith("JPEG") || imageName
					.endsWith("PNG")))
				isImageFile = true;
		}
		return isImageFile;
	}

	public void saveImage(String newImageName, BufferedImage bufferedImage,
			String imageExtention) {
		File outputfile = new File(newImageName);
		try {
			ImageIO.write(bufferedImage, "JPG", outputfile);
		} catch (IOException e) {
			logger.error("Error occured while trying to save resized image ", e);
		}
	}
}
