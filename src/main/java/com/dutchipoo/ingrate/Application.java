package com.dutchipoo.ingrate;

import java.io.File;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryBuilder;

public class Application {
    public static void main(String[] args) {
		try {
			Repository repo = new RepositoryBuilder()
				.setGitDir(new File("/Users/chris.lamberson/Documents/ingrate/.git"))
				.readEnvironment()
				.findGitDir()
				.build();
			DataDirectory dd = DataDirectoryFactory.getDataDirectory();
			System.out.println(dd.getPath());
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
    }
}
