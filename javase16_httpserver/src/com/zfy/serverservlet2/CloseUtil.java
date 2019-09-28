package com.zfy.serverservlet2;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
	public static void closeIO(Closeable...io) {
		for(Closeable temp:io) {
				try {
					if(null!=temp) {
					temp.close();}
				} catch (IOException e) {
				}
		}
		
	}

}
