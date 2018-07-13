package xin.elasticsearch.util;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import static jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.ALPHA;

public class ImageUtil {
    private static final String FONT_NAME = "微软雅黑";
    private static final int FONT_SIZE = 35;
    private static final Color FONT_COLOR = new Color(2, 2, 2, 130);
    private static final String MARK_TEXT = "图片来源：hc测试";
    private static final String UPLOAD_PATH = "C:\\Users\\s_xun\\Desktop";

    /**
     *   计算水印文本长度
     *   中文长度即文本长度   英文长度为文本长度二分之一
     * @param text
     * @return
     */
    public static int getTextLength(String text){
        //水印文字长度
        int length = text.length();

        for (int i = 0; i < text.length(); i++) {
            String s =String.valueOf(text.charAt(i));
            if (s.getBytes().length>1) {
                length++;
            }
        }
        length = length%2==0?length/2:length/2+1;
        return length;
    }

    /**
     * 添加单条文字水印方法
     * @param myFile
     * @param imageFileName
     */
    public static void textWaterMark(File myFile, String imageFileName) {
        InputStream is =null;
        OutputStream os =null;

        try {
            //使用ImageIO解码图片
            Image image = ImageIO.read(myFile);
            //计算原始图片宽度长度
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            //创建图片缓存对象
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //创建java绘图工具对象
            Graphics2D graphics2d = bufferedImage.createGraphics();
            //参数主要是，原图，坐标，宽高
            graphics2d.drawImage(image, 0, 0, width, height, null);
            graphics2d.setFont(new Font(FONT_NAME, Font.PLAIN, FONT_SIZE));
            graphics2d.setColor(FONT_COLOR);

            //使用绘图工具将水印绘制到图片上
            //计算文字水印宽高值
            int waterWidth = FONT_SIZE*getTextLength(MARK_TEXT);
            //计算水印与原图高宽差
            int widthDiff = width-waterWidth;
            int heightDiff = height-FONT_SIZE;
            //水印透明设置
            graphics2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, ALPHA));
            //纵坐标在下方，不增加字体高度会靠上
            graphics2d.drawString(MARK_TEXT, widthDiff - 10, height - 10);
            graphics2d.dispose();
            os = new FileOutputStream(UPLOAD_PATH+"/"+imageFileName);
            //创建图像编码工具类
            JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
            //使用图像编码工具类，输出缓存图像到目标文件
            en.encode(bufferedImage);
            if(is!=null){
                is.close();
            }
            if(os!=null){
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("success");
    }
}
