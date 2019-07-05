import java.security.MessageDigest;

import org.jboss.netty.handler.codec.base64.Base64Encoder;

public class PassGenerator {

    public String generate(String senhaTexto) {

        try {
            byte[] digest = MessageDigest.getInstance("sha-256").digest(senhaTexto.getBytes());
         //   return Base64Encoder.encode(digest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}