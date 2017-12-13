import java.math.BigDecimal;

public class Test {
    public static void main(String[] agrs){
        int width = 463;

        int default_width = 63;//水印标准宽度
        int default_height = 23;//水印标准宽度
        int width_1 = width/3;//修改水印宽度为图片宽度1/3 2017-12-07 chenyf update

        int height_1 = new BigDecimal(default_height).multiply(new BigDecimal(width_1).divide(new BigDecimal(default_width),3,BigDecimal.ROUND_HALF_DOWN)).intValue();//修改水印高度为 水印宽度按标准宽度缩放比例*水印标准高度 2017-12-07 chenyf update
        System.out.println(height_1);
    }
}
