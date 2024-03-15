package com.config;

import com.utilities.FileUtil;

public class Configuration {
	FileUtil fis = new FileUtil();
	public String getAppUrl(String env) {
		return fis.getProperty("/src/test/resources/config.properties", "app"+env+".url");
	}
	public String getBrowsername() {
		return fis.getConfiguration("browser_name");
	}
	public String getExecutionMode() {
		FileUtil file = new FileUtil();
		return file.getProperty("/src/test/resources/config.properties", "execution_mode");
	}

}
