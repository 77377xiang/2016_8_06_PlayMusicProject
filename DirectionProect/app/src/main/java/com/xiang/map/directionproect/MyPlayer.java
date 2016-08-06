package com.xiang.map.directionproect;

import android.content.Context;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * 音乐播放类---单例模式
 * Created by 90720 on 2016/7/20.
 */
public class MyPlayer {

    //音效下标常量
    public static final int INDEX_STONE_ENTER = 0;
    public static final int INDEX_STONE_CANCEL = 1;
    public static final int INDEX_STONE_COIN = 2;

    //歌曲播放
    private static MediaPlayer mMusicMediaPlayer;

    //音效数组---音乐只要一个MediaPlayer,音效需要多个Player,而且和音效文件一一对应
    private static final String[] TONES_NAME = {
            "walk_walk_to_spread.mp3"
    };
    //音效对应的MediaPlayer数组
    private static MediaPlayer[] mToneMediaPlayer = new MediaPlayer[TONES_NAME.length];

    //播放音效
    public static void playTone(Context context, int index) {
        //加载声音
        AssetManager assetManager = context.getAssets();
        if (mToneMediaPlayer[index] == null) {

            mToneMediaPlayer[index] = new MediaPlayer();
        }else {
            mToneMediaPlayer[index].reset();


        }

            try {
                AssetFileDescriptor fileDescriptor = assetManager.openFd(TONES_NAME[index]);
                mToneMediaPlayer[index].setDataSource(fileDescriptor.getFileDescriptor(),
                        fileDescriptor.getStartOffset(), fileDescriptor.getLength());
                mToneMediaPlayer[index].prepare();

            } catch (IOException e) {
                e.printStackTrace();
            }



        mToneMediaPlayer[index].start();
    }

    /**
     * 播放歌曲
     *
     * @param context
     * @param fileName
     */
    public static void playSong(Context context, String fileName) {
        //不管方法调用多少次,只创建一次,只有一个对象
        if (mMusicMediaPlayer == null) {
            mMusicMediaPlayer = new MediaPlayer();
        } else {
            //制重置,针对重复播放
            mMusicMediaPlayer.reset();

            //加载声音文件
            AssetManager assetManager = context.getAssets();
            try {
                AssetFileDescriptor fileDescriptor = assetManager.openFd(fileName);
                mMusicMediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(), fileDescriptor.getStartOffset(), fileDescriptor.getLength());
                mMusicMediaPlayer.prepare();
                //歌曲播放
                mMusicMediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    /**
     * 暂停歌曲
     *
     * @param context
     */
    public static void stopTheSong(Context context) {
        if (mMusicMediaPlayer != null) {
            mMusicMediaPlayer.stop();
        }
    }

    //  停止音效
    public static void stopTheTone(Context context, int n) {
        if (mToneMediaPlayer[n] != null) {
            mToneMediaPlayer[n].stop();
        }
    }


}
