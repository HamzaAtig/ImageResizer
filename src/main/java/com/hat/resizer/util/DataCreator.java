package com.hat.resizer.util;

import com.hat.resizer.ResizerIn;

public class DataCreator {

	public ResizerIn resizeInCreator(String[] args) {
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
}
