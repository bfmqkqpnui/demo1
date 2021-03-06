package pers.springcloud.utils;

/**
 * 令牌
 */
public class Token {
    /**
     * 令牌签名
     */
    private String signature;
    /**
     * 过期时间 时间戳
     */
    private String exp;
    /**
     * 发行时间 时间戳
     */
    private String iat;
    /**
     * 登录用户名
     */
    private String memberId;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

}
