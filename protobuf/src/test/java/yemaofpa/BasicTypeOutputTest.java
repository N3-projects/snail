package yemaofpa;

import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/**
 * @author N3 on 2017/10/1.
 */
public class BasicTypeOutputTest {

    @Test
    public void writeBytes() throws Exception{
        String str = "我们";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteString.copyFromUtf8(str).writeTo(out);
        out.flush();
        byte[] data = out.toByteArray();
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        String decode = ByteString.readFrom(in).toStringUtf8();
        System.out.println(decode);
    }
}
