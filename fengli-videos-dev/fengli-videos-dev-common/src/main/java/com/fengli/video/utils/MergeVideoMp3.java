package com.fengli.video.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *  视频合并音频工具类
 *
 * @author Administrator
 */
public class MergeVideoMp3 {

	private String ffmpegEXE;
	
	public MergeVideoMp3(String ffmpegEXE) {
		super();
		this.ffmpegEXE = ffmpegEXE;
	}

	/**
	 * 过滤视频原背景音乐
	 * @param videoInputPath 原视频磁盘路径
	 * @param videoOutputPath 过滤后视频磁盘路径
	 * @throws IOException io异常
	 */
	public void passVideo(String videoInputPath, String videoOutputPath) throws IOException {
		List<String> commands = new ArrayList<>();
		commands.add(ffmpegEXE);

		commands.add("-i");
		commands.add(videoInputPath);

		commands.add("-vcodec");
		commands.add("copy");
		commands.add("-an");
		commands.add(videoOutputPath);

		ProcessBuilder builder = new ProcessBuilder(commands);
		Process process = builder.start();

		InputStream errorStream = process.getErrorStream();
		InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
		BufferedReader br = new BufferedReader(inputStreamReader);

		String line = "";
		while ( (line = br.readLine()) != null ) {
		}

		if (br != null) {
			br.close();
		}
		if (inputStreamReader != null) {
			inputStreamReader.close();
		}
		if (errorStream != null) {
			errorStream.close();
		}

	}

	/**
	 * 合并音频
	 * @param videoInputPath 待合并视频磁盘路径
	 * @param mp3InputPath 音频磁盘路径
	 * @param seconds 视频长度
	 * @param videoOutputPath 合并后视频路径
	 * @throws Exception
	 */
	public void convertor(String videoInputPath, String mp3InputPath,
			double seconds, String videoOutputPath) throws Exception {
//		ffmpeg.exe -i 苏州大裤衩.mp4 -i bgm.mp3 -t 7 -y 新的视频.mp4
		List<String> command = new ArrayList<>();
		command.add(ffmpegEXE);
		
		command.add("-i");
		command.add(videoInputPath);
		
		command.add("-i");
		command.add(mp3InputPath);
		
		command.add("-t");
		command.add(String.valueOf(seconds));
		
		command.add("-y");
		command.add(videoOutputPath);
		
//		for (String c : command) {
//			System.out.print(c + " ");
//		}
		
		ProcessBuilder builder = new ProcessBuilder(command);
		Process process = builder.start();
		
		InputStream errorStream = process.getErrorStream();
		InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
		
		String line = "";
		while ( (line = br.readLine()) != null ) {
		}
		
		if (br != null) {
			br.close();
		}
		if (inputStreamReader != null) {
			inputStreamReader.close();
		}
		if (errorStream != null) {
			errorStream.close();
		}
		
	}

	/**
	 * 测试
	 */
	public static void main(String[] args) {

		MergeVideoMp3 ffmpeg = new MergeVideoMp3(
				"D:\\ffmpeg-20200620-29ea4e1-win64-static\\bin\\ffmpeg.exe");
		try {

			ffmpeg.passVideo("F:\\videos\\tvc-v3_0b9db49_Trim.mp4", "F:\\videos\\tvc-v3_0b9db49_Trim1.mp4");
			ffmpeg.convertor("F:\\videos\\tvc-v3_0b9db49_Trim1.mp4",
					"F:\\fengli_videos_dev\\bgm\\一支榴莲 - 海底.mp3",
					7.1,
					"F:\\这是通过java生产的视频.mp4");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
