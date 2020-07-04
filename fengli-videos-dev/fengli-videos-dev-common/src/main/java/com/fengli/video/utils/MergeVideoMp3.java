package com.fengli.video.utils;

import java.io.*;
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
		Process process = null;
        InputStream errorStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;

        try{
            process = builder.start();
            errorStream = process.getErrorStream();
            inputStreamReader = new InputStreamReader(errorStream);
            br = new BufferedReader(inputStreamReader);
            String line = "";
            while ( (line = br.readLine()) != null){

            }
        }catch (Exception e){
		    e.printStackTrace();
        }finally {
            if (br != null){
                br.close();
            }
            if (inputStreamReader != null){
                inputStreamReader.close();
            }
            if (errorStream != null){
                errorStream.close();
            }
        }
	}

	/**
	 * 合并音频
	 * @param videoInputPath 待合并视频磁盘路径
	 * @param mp3InputPath 音频磁盘路径
	 * @param seconds 视频长度
	 * @param videoOutputPath 合并后视频路径
	 * @throws Exception 异常
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

        ProcessBuilder builder = new ProcessBuilder(command);

        Process process = null;
        InputStream errorStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;

        try{
            process = builder.start();
            errorStream = process.getErrorStream();
            inputStreamReader = new InputStreamReader(errorStream);
            br = new BufferedReader(inputStreamReader);
            String line = "";
            while ( (line = br.readLine()) != null){
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (br != null){
                br.close();
            }
            if (inputStreamReader != null){
                inputStreamReader.close();
            }

            if (errorStream != null){
                errorStream.close();
            }
        }

	}

	/**
	 * 测试
	 */
	public static void main(String[] args) {

		MergeVideoMp3 ffmpeg = new MergeVideoMp3(
				"/usr/local/bin/ffmpeg");
		try {

			ffmpeg.passVideo("/root/fengli_videos_dev/2006257HXB39WTTC/video/wxb9cb2258cf0e244f.o6zAJs66hhpsiijNW5xwnrb0im6Q.xHy7LtLVT2ma43130f8f167cc3ba00c3d3df2e7fff72.mp4",
					"/root/fengli_videos_dev/temp/test.mp4");
			ffmpeg.convertor("/root/fengli_videos_dev/temp/test.mp4",
					"/root/fengli_videos_dev/bgm/一支榴莲 - 海底.mp3",
					7.1,
					"/root/fengli_videos_dev/end.mp4");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
