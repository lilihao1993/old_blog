package system.elastucsearch.common;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Created by Administrator on 2016/11/9.
 */
public class RandomHan {
    private static Random ran = new Random();
    private final static int delta = 0x9fa5 - 0x4e00 + 1;

    public static char getRandomHan() {
        return (char) (0x4e00 + ran.nextInt(delta));
    }

    public static void main(String[] args) {
        System.out.println(getRandomJianHan(300));
    }


    /**
     * 获取指定长度随机简体中文
     * @param len int
     * @return String
     */
    public static String getRandomJianHan(int len)
    {
        String ret="";
        for(int i=0;i<len;i++){
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); //获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); //获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try
            {
                str = new String(b, "GBk"); //转成中文
            }
            catch (UnsupportedEncodingException ex)
            {
                ex.printStackTrace();
            }
            ret+=str;
        }
        return ret;
    }
}
