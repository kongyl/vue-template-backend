package me.kongyl.template.util;

import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;

public class CodeUtils {

    private CodeUtils() {}
    
    public static String uuid() {
        return UUID.randomUUID().toString();
    }
    
    /**
     * BCrypt加密
     * @param str
     * @return
     */
    public static String bcrypt(String str) {
        return BCrypt.hashpw(str, BCrypt.gensalt());
    }
    
    /**
     * BCrypt检查
     * @param candidate
     * @param hashed
     * @return
     */
    public static boolean bcryptCheck(String candidate, String hashed) {
        return BCrypt.checkpw(candidate, hashed);
    }
    
}
