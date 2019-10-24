/*
 * Copyright (C) 2019 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.xuexiang.imageprocess.utils;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;

import com.xuexiang.xutil.file.FileUtils;

import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;
import static org.opencv.imgproc.Imgproc.THRESH_BINARY;

/**
 * 图片处理工具类
 *
 * @author xuexiang
 * @since 2019-10-24 13:39
 */
public final class ImageProcessUtils {

    private ImageProcessUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }


    /**
     * 图片灰度化
     *
     * @param imgPath
     * @return
     */
    @Nullable
    public static Bitmap grayScale(String imgPath) {
        if (!FileUtils.isFileExists(imgPath)) {
            return null;
        }
        Mat src = Imgcodecs.imread(imgPath);
        //灰度化
        Mat dst = grayScale(src);
        Bitmap result = mat2Bitmap(dst);
        src.release();
        dst.release();
        return result;
    }

    /**
     * 图片灰度化
     *
     * @param srcBitmap
     * @return
     */
    @Nullable
    public static Bitmap grayScale(Bitmap srcBitmap) {
        if (srcBitmap == null) {
            return null;
        }
        Mat src = bitmap2Mat(srcBitmap);
        //灰度化
        Mat dst = grayScale(src);
        Bitmap result = mat2Bitmap(dst);
        src.release();
        dst.release();
        return result;
    }

    /**
     * 图片二值化
     *
     * @param imgPath
     * @return
     */
    @Nullable
    public static Bitmap binary(String imgPath, double thresh) {
        if (!FileUtils.isFileExists(imgPath)) {
            return null;
        }
        Mat src = Imgcodecs.imread(imgPath);
        //二值化
        Mat dst = binary(src, thresh);
        Bitmap result = mat2Bitmap(dst);
        src.release();
        dst.release();
        return result;
    }

    /**
     * 图片二值化
     *
     * @param srcBitmap
     * @return
     */
    @Nullable
    public static Bitmap binary(Bitmap srcBitmap, double thresh) {
        if (srcBitmap == null) {
            return null;
        }
        Mat src = bitmap2Mat(srcBitmap);
        //二值化
        Mat dst = binary(src, thresh);
        Bitmap result = mat2Bitmap(dst);
        src.release();
        dst.release();
        return result;
    }


    /**
     * 去红
     *
     * @param imgPath
     * @return
     */
    @Nullable
    public static Bitmap clearRed(String imgPath, double thresh) {
        if (!FileUtils.isFileExists(imgPath)) {
            return null;
        }
        Mat src = Imgcodecs.imread(imgPath);
        //去红
        Mat dst = clearRed(src, thresh);
        Bitmap result = mat2Bitmap(dst);
        src.release();
        dst.release();
        return result;
    }

    /**
     * 去红
     *
     * @param srcBitmap
     * @return
     */
    @Nullable
    public static Bitmap clearRed(Bitmap srcBitmap, double thresh) {
        if (srcBitmap == null) {
            return null;
        }
        Mat src = bitmap2Mat(srcBitmap);
        //去红
        Mat dst = clearRed(src, thresh);
        Bitmap result = mat2Bitmap(dst);
        src.release();
        dst.release();
        return result;
    }

    public static Bitmap clearBlue(String imgPath, int thresh) {
        if (!FileUtils.isFileExists(imgPath)) {
            return null;
        }
        Mat src = Imgcodecs.imread(imgPath);
        //去蓝
        Mat dst = clearBlue(src, thresh);
        Bitmap result = mat2Bitmap(dst);
        src.release();
        dst.release();
        return result;
    }


    public static Bitmap clearColour(String imgPath, int thresh) {
        if (!FileUtils.isFileExists(imgPath)) {
            return null;
        }
        Mat src = Imgcodecs.imread(imgPath);
        //去彩色
        Mat dst = clearColour(src, thresh);
        Bitmap result = mat2Bitmap(dst);
        src.release();
        dst.release();
        return result;
    }

    //====================================基础方法===============================================//

    /**
     * 默认二值化最大阈值
     */
    public static final int DEFAULT_THRESH_MAX_VALUE = 255;
    /**
     * 蓝色通道
     */
    public static final int BLUE_CHANNEL_INDEX = 0;
    /**
     * 绿色通道
     */
    public static final int GREEN_CHANNEL_INDEX = 1;
    /**
     * 红色通道
     */
    public static final int RED_CHANNEL_INDEX = 2;


    /**
     * 去红
     *
     * @param src
     * @param thresh 阈值
     * @return
     */
    public static Mat clearRed(Mat src, double thresh) {
        return clearRed(src, thresh, DEFAULT_THRESH_MAX_VALUE);
    }

    /**
     * 去红
     *
     * @param src
     * @param thresh 阈值
     * @param maxval 最大阈值， 一般为255
     */
    public static Mat clearRed(Mat src, double thresh, double maxval) {
        return clearColor(src, RED_CHANNEL_INDEX, thresh, maxval);
    }


    /**
     * 去蓝
     *
     * @param src
     * @param thresh 阈值
     */
    public static Mat clearBlue(Mat src, double thresh) {
        return clearBlue(src, thresh, DEFAULT_THRESH_MAX_VALUE);
    }

    /**
     * 去蓝
     *
     * @param src
     * @param thresh 阈值
     * @param maxval 最大阈值， 一般为255
     */
    public static Mat clearBlue(Mat src, double thresh, double maxval) {
        return clearColor(src, BLUE_CHANNEL_INDEX, thresh, maxval);
    }

    /**
     * 去除指定通道上的颜色
     *
     * @param src
     * @param channelIndex 颜色通道：0-蓝色，1-绿色，2-红色
     * @param thresh       阈值
     * @param maxval       最大阈值， 一般为255
     */
    public static Mat clearColor(Mat src, int channelIndex, double thresh, double maxval) {
        if (src == null) {
            return null;
        }

        //获取指定通道颜色
        List<Mat> channel = new ArrayList<>();
        Core.split(src, channel);
        Mat color = channel.get(channelIndex);

        Mat dst = new Mat();
        Imgproc.threshold(color, dst, thresh, maxval, THRESH_BINARY);
        return dst;
    }


    /**
     * 去除彩色
     *
     * @param src
     * @param thresh 阈值
     */
    public static Mat clearColour(Mat src, double thresh) {
        return clearColour(src, thresh, DEFAULT_THRESH_MAX_VALUE);
    }

    /**
     * 去除彩色
     *
     * @param src
     * @param thresh 阈值
     * @param maxval 最大阈值， 一般为255
     */
    public static Mat clearColour(Mat src, double thresh, double maxval) {
        if (src == null) {
            return null;
        }

        Mat dst = new Mat();

        return dst;
    }

    /**
     * 二值化
     *
     * @param src
     * @param thresh 阈值
     * @return
     */
    public static Mat binary(Mat src, double thresh) {
        return binary(src, thresh, DEFAULT_THRESH_MAX_VALUE);
    }

    /**
     * 二值化
     *
     * @param src
     * @param thresh 阈值
     * @param maxval 最大阈值， 一般为255
     * @return
     */
    public static Mat binary(Mat src, double thresh, double maxval) {
        if (src == null) {
            return null;
        }

        Mat imgGray = new Mat();
        Mat dst = new Mat();
        //先灰度化
        Imgproc.cvtColor(src, imgGray, COLOR_BGR2GRAY);
        //再二值化
        Imgproc.threshold(imgGray, dst, thresh, maxval, THRESH_BINARY);
        return dst;
    }


    /**
     * 灰度化
     *
     * @param src
     * @return
     */
    public static Mat grayScale(Mat src) {
        if (src == null) {
            return null;
        }
        Mat dst = new Mat();
        Imgproc.cvtColor(src, dst, COLOR_BGR2GRAY);
        return dst;
    }

    /**
     * bitmap转Mat
     *
     * @param src
     * @return
     */
    public static Mat bitmap2Mat(Bitmap src) {
        Mat mat = new Mat();
        Utils.bitmapToMat(src, mat);
        return mat;
    }

    /**
     * Mat转bitmap
     *
     * @param mat
     * @return
     */
    public static Bitmap mat2Bitmap(Mat mat) {
        Bitmap bitmap = Bitmap.createBitmap(mat.width(), mat.height(), Bitmap.Config.RGB_565);
        Utils.matToBitmap(mat, bitmap);
        return bitmap;
    }


}
