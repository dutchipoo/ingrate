package com.dutchipoo.ingrate;

public class DataDirectoryFactory {
    public static DataDirectory getDataDirectory() {
	String osName = System.getProperty("os.name");

	switch (osName) {
	case "Mac OS X":
	    return new UnixDataDirectory();

	default:
	    throw new UnsupportedOperationException();
	}
    }
}
