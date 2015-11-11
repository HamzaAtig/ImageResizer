package com.hat.resizer;

public class ResizerIn {

	private String resizedSuffixName;
	private String resizedPreffixName;
	private String entryDirectoryPath;
	private String outDirectoryPath;
	private String imageExtention;

	private Integer targetWidth;
	private Integer targetHeight;

	public ResizerIn() {
		super();

	}

	public ResizerIn(String resizedSuffixName, String resizedPreffixName,
			String entryDirectoryPath, String outDirectoryPath,
			String imageExtention) {
		super();
		this.resizedSuffixName = resizedSuffixName;
		this.resizedPreffixName = resizedPreffixName;
		this.entryDirectoryPath = entryDirectoryPath;
		this.outDirectoryPath = outDirectoryPath;
		this.imageExtention = imageExtention;
	}

	public ResizerIn(String resizedSuffixName, String resizedPreffixName,
			String entryDirectoryPath, String outDirectoryPath,
			String imageExtention, Integer targetWidth, Integer targetHeight) {
		super();
		this.resizedSuffixName = resizedSuffixName;
		this.resizedPreffixName = resizedPreffixName;
		this.entryDirectoryPath = entryDirectoryPath;
		this.outDirectoryPath = outDirectoryPath;
		this.imageExtention = imageExtention;
		this.targetWidth = targetWidth;
		this.targetHeight = targetHeight;
	}
	
	public String getResizedSuffixName() {
		return resizedSuffixName;
	}

	public void setResizedSuffixName(String resizedSuffixName) {
		this.resizedSuffixName = resizedSuffixName;
	}

	public String getResizedPreffixName() {
		return resizedPreffixName;
	}

	public void setResizedPreffixName(String resizedPreffixName) {
		this.resizedPreffixName = resizedPreffixName;
	}

	public String getEntryDirectoryPath() {
		return entryDirectoryPath;
	}

	public void setEntryDirectoryPath(String entryDirectoryPath) {
		this.entryDirectoryPath = entryDirectoryPath;
	}

	public String getOutDirectoryPath() {
		return outDirectoryPath;
	}

	public void setOutDirectoryPath(String outDirectoryPath) {
		this.outDirectoryPath = outDirectoryPath;
	}

	public String getImageExtention() {
		return imageExtention;
	}

	public void setImageExtention(String imageExtention) {
		this.imageExtention = imageExtention;
	}

	public Integer getTargetWidth() {
		return targetWidth;
	}

	public void setTargetWidth(Integer targetWidth) {
		this.targetWidth = targetWidth;
	}

	public Integer getTargetHeight() {
		return targetHeight;
	}

	public void setTargetHeight(Integer targetHeight) {
		this.targetHeight = targetHeight;
	}

}
