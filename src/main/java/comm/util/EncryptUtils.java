package comm.util;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import system.model.User;

import java.security.MessageDigest;

/**
 * 加密工具
 * MD5 盐值加密
 */
public class EncryptUtils extends Md5Utils {

    // 随机数生成器
    private static SecureRandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    // 密码hash算法
    private static final String PASSWORD_HASH_ALGORITHM_NAME = "md5";

    // 密码迭代次数
    private static int PASSWORD_HASH_ITERATIONS = 2;

    /**
     * 密码加密
     *
     * @param password 原始密码
     * @param salt     hash盐值
     * @return
     */
    public static String encryptPassword(String password, String salt) {
        return new SimpleHash(PASSWORD_HASH_ALGORITHM_NAME, password,
                ByteSource.Util.bytes(salt), PASSWORD_HASH_ITERATIONS)
                .toHex();
    }

    /**
     * 用户密码加密
     *
     * @param user 用户信息
     */
    public static void encryptPassword(User user) {
        String salt = randomNumberGenerator.nextBytes().toHex();
        user.setEncryptSalt(salt);
        user.setPassword(encryptPassword(user.getPassword(),
                user.getEncryptSalt()));
    }



    /**
     * md5哈希
     *
     * @param str 源信息
     * @return 哈希值
     */
    public static String md5Encoder(String str) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            char[] strChars = str.toCharArray();
            byte[] strBytes = new byte[strChars.length];
            for (int i = 0; i < strChars.length; i++)
                strBytes[i] = (byte) strChars[i];
            byte[] md5Bytes = md5.digest(strBytes);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16)
                    hexValue.append("0");
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
//        String ecode = md5Encoder("llh1993824");
//        String result = encryptPassword("llh19938241",randomNumberGenerator.nextBytes().toHex());
//        System.out.println(ecode +"-----"+result);
//        System.out.println(encryptPassword("llh1993824","6f5a06a658938c7ed05d79fdf6a7e0ad"));
//        System.out.println("be7f94bbc22eb9a2655f773b55986104");
        User user = new User();
        user.setPassword("llh1993824");
        encryptPassword(user);
        System.out.println(user.toString());
    }
}