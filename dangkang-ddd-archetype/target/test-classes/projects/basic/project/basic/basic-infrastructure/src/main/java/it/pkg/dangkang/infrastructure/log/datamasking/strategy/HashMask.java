package it.pkg.dangkang.infrastructure.log.datamasking.strategy;

import it.pkg.dangkang.infrastructure.log.datamasking.MaskStrategy;
import it.pkg.dangkang.infrastructure.it.pkgmon.util.EncodeUtil;
import it.pkg.dangkang.infrastructure.it.pkgmon.util.HashUtil;

/**
 * Hash掩码，主要用于一些敏感信息掩码后查询。
 * 算法：sha1(source+salt)
 */
public class HashMask implements MaskStrategy {

    private static String salt = "default_salt";

    /**
     * 默认用 default_salt
     * 可以通过DataMask来设置
     */
    public static String getSalt() {
        return salt;
    }

    /**
     * 设置salt
     */
    public static void setSalt(String salt) {
        HashMask.salt = salt;
    }

    @Override
    public String mask(String source, int[] params) {
        if (source == null || source.isEmpty()) {
            return source;
        }
        return EncodeUtil.encodeHex(HashUtil.sha1(source + getSalt()));
    }
}
