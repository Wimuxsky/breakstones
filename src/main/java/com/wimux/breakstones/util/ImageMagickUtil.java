package com.wimux.breakstones.util;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;

import java.io.IOException;

/**
 * @Author siqigang
 * @Date 2018/10/18 15:52
 */
public class ImageMagickUtil {

    public static void main(String[] args) throws InterruptedException, IOException, IM4JavaException {
        rotate();
    }

    private static void rotate() throws InterruptedException, IOException, IM4JavaException{
        IMOperation operation = new IMOperation();
        operation.addImage("/Users/Wimux/Downloads/image_201810181426381120/0_b745305d70964ef20fe304bc82058c51139332.jpg");
        operation.rotate(90d);
        operation.addImage("/Users/Wimux/Downloads/image_201810181426381120/0_b745305d70964ef20fe304bc82058c51139332b.jpg");

        ConvertCmd cmd = new ConvertCmd(true);
        cmd.run(operation);
    }
}
