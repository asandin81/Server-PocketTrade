/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.InvalidClaimException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.TextCodec;
import io.jsonwebtoken.impl.crypto.MacProvider;
import java.util.Date;
import java.util.UUID;

import javax.crypto.SecretKey;


/**
 *
 * @author Angel Sandin
 */
public class Token {

    private static final SecretKey key = MacProvider.generateKey();
    private static final byte[] keyBytes = key.getEncoded();
    private static final String base64Encoded = TextCodec.BASE64.encode(keyBytes);

    /**
     * Crea un nou Token
     * @param identificador id de la BBDD
     * @return Retorna un String amb el token JWT, que expira a les 24 hores.
     */
    public static String generateToken(String identificador) {
        String id = UUID.randomUUID().toString().replace("-", "");
        Date now = new Date();
        Date exp = new Date(System.currentTimeMillis() + (1000 * 86400)); 

        String token = Jwts.builder()
            .setId(id)
            .setIssuedAt(now)
            .claim("identificador", identificador)
            .setNotBefore(now)
            .setExpiration(exp)
            .signWith(SignatureAlgorithm.HS256, base64Encoded)
            .compact();
        return token;
        
    }
    /**
     * Verifica que el Token sigi valid.
     * @param token
     * @param id 
     * @return True, si la verificacio es positiva,
     * False, y ha un error en la signatura, el identificador no es correcte,
     * o a Expirat el Token.
     */
    public static boolean verifyToken(String token, String id){
        
       try{
        Jwts.parser()
            .require("identificador", id)
            .setSigningKey(base64Encoded)
            .parseClaimsJws(token);
        return true;
       } catch (InvalidClaimException | SignatureException | ExpiredJwtException e){
           return false;
       }
        
    }    

}

