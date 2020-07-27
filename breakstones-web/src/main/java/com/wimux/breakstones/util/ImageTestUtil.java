package com.wimux.breakstones.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

/**
 * @Author siqigang
 * @Date 2018/10/29 14:41
 */
public class ImageTestUtil {

    public static void main(String[] args) {
        getAvgRGB();
    }


    private static void getAvgRGB() {
        String filename = "/Users/Wimux/Downloads/bg.jpg";
        List<Integer> rList = new ArrayList<>();
        List<Integer> gList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();

        int[] rgb = new int[3];
        File file = new File(filename);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int width = bi.getWidth();
        int height = bi.getHeight();
        int minx = bi.getMinX();
        int miny = bi.getMinY();
        System.out.println("width=" + width + ",height=" + height + ".");
        System.out.println("minx=" + minx + ",miniy=" + miny + ".");
        for (int i = minx; i < width; i++) {
            for (int j = miny; j < height; j++) {
                int pixel = bi.getRGB(i, j); // 下面三行代码将一个数字转换为RGB数字
                rgb[0] = (pixel & 0xff0000) >> 16;
                rgb[1] = (pixel & 0xff00) >> 8;
                rgb[2] = (pixel & 0xff);
                System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + ","
                        + rgb[1] + "," + rgb[2] + ")");

                rList.add((pixel & 0xff0000) >> 16);
                gList.add((pixel & 0xff00) >> 8);
                bList.add((pixel & 0xff));
            }
        }

        OptionalDouble  r = rList.stream().mapToInt(Integer::valueOf).average();
    }
}
