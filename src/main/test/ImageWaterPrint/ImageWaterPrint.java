package ImageWaterPrint;

import org.junit.Test;
import xin.elasticsearch.util.ImageUtil;

import java.io.File;

public class ImageWaterPrint {
    @Test
    public void test1(){
        File file = new File("C:\\Users\\s_xun\\Desktop\\other\\yigo-redist\\Images\\67636727.gif");
        ImageUtil.textWaterMark(file,"t.jpg");
    }
}
