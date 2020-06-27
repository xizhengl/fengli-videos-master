package com.fengli.video.utils;

import java.io.*;
import java.util.List;

/**
 * 
 * @author Administrator
 * @Description: 获取视频的信息
 */
public class FetchVideoCover {
	// 视频路径
	private String ffmpegEXE;

	public void getCover(String videoInputPath, String coverOutputPath) throws IOException, InterruptedException {
//		ffmpeg.exe -ss 00:00:01 -i spring.mp4 -vframes 1 bb.jpg
		List<String> command = new java.util.ArrayList<>();
		command.add(ffmpegEXE);
		
		// 指定截取第1秒
		command.add("-ss");
		command.add("00:00:01");
				
		command.add("-y");
		command.add("-i");
		command.add(videoInputPath);
		
		command.add("-vframes");
		command.add("1");
		
		command.add(coverOutputPath);
		

		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = builder.start();

		InputStream errorStream = process.getErrorStream();
		InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
		BufferedReader br = new BufferedReader(inputStreamReader);

		if (new File(coverOutputPath).isFile()){
			System.out.println("coverOutputPath is File----------------------------------------");
		}

		br.close();
		inputStreamReader.close();
		errorStream.close();
	}

	public String getFfmpegEXE() {
		return ffmpegEXE;
	}

	public void setFfmpegEXE(String ffmpegEXE) {
		this.ffmpegEXE = ffmpegEXE;
	}

	public FetchVideoCover() {
		super();
	}

	public FetchVideoCover(String ffmpegEXE) {
		this.ffmpegEXE = ffmpegEXE;
	}
	
	public static void main(String[] args) {
		// 获取视频信息。
		FetchVideoCover videoInfo = new FetchVideoCover("c:\\ffmpeg\\bin\\ffmpeg.exe");
		try {
			videoInfo.getCover("c:\\北京北京.avi","c:\\北京.jpg");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}