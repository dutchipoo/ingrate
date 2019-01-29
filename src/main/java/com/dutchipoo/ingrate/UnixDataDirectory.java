package com.dutchipoo.ingrate;

import java.nio.file.Paths;

public class UnixDataDirectory implements DataDirectory {
    private System system;

    public UnixDataDirectory() {
	system = System;
    }

    public UnixDataDirectory(System s) {
	system = s;
    }

    public String getPath() {
	var env = system.getenv();
	var defaultDirectory = Paths.get(System.getProperty("user.home"), ".local/share/ingrate").toString();
	return env.getOrDefault("XDG_DATA_HOME", defaultDirectory);
    }
}
