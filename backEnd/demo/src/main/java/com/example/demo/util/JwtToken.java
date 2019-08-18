package com.example.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * JwtToken:
 *
 * @author XvYanPeng
 * @date 2019/8/16 20:20
 */
public class JwtToken {
    //密钥
    private static String secretKey = "159852";

    public static String getToken(User user) {
        // JWT的标准head
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        //生成token
        String token = JWT.create().
                withHeader(map)
                // token负载内容
                .withClaim("用户名", user.getUserName())
                .withClaim("密码", user.getPassword())
                // 签名加密（还可以设置签名时间和到期时间）
                .sign(Algorithm.HMAC256(secretKey));
        return token;
    }

    public static Map<String, Claim> decodeToken(String token) {
        DecodedJWT jwt = null;
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
        jwt = verifier.verify(token);
        return jwt.getClaims();
    }
}
