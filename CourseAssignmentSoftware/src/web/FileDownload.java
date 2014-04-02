/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
public class FileDownload
{
	/**
	 * Method downloads file from URL to a given directory.
	 * 
	 * @param fileURL
	 *            - file URL to download
	 * @param destinationDirectory
	 *            - directory to download file to
	 * @throws IOException
	 */
	public static void download(String fileURL, String destinationDirectory)
			throws IOException {
		// File name that is being downloaded
		String downloadedFileName = fileURL
				.substring(fileURL.lastIndexOf("/") + 1);

		// Open connection to the file
		URL url = new URL(fileURL);
		InputStream is = url.openStream();
		// Stream to the destionation file
		FileOutputStream fos = new FileOutputStream(destinationDirectory + "/"
				+ downloadedFileName);

		// Read bytes from URL to the local file
		byte[] buffer = new byte[4096];
		int bytesRead = 0;

		System.out.print("Downloading " + downloadedFileName);
		while ((bytesRead = is.read(buffer)) != -1) {
			System.out.print("."); // Progress bar :)
			fos.write(buffer, 0, bytesRead);
		}
		System.out.println("done!");

		// Close destination stream
		fos.close();
		// Close URL stream
		is.close();
	}
}