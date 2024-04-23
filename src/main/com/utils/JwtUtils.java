package com.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JwtUtils {

    private static final String secretForHash = "!Q@W#E$R";

    public static String createToken(Long id){
        JWTCreator.Builder builder = JWT.create();

        //payload
        builder.withClaim("user_id", id);

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR, 3); //默认3天过期

        builder.withExpiresAt(instance.getTime());//指定令牌的过期时间
        return builder.sign(Algorithm.HMAC256(secretForHash));
    }

    public static Long verify(String token) {
        //如果有任何验证异常，此处都会抛出异常
        try {
            DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC256(secretForHash)).build().verify(token);
//            if(id.equals(decodedJWT.getClaim("user_id").asLong())){
//                return true;
//            }else {
//                return false;
//            }
            return decodedJWT.getClaim("user_id").asLong();
        }catch (Exception e){
            return null;
        }
    }

}
