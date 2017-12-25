package n3.snail.dubbo.serialization;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.serialize.ObjectInput;
import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.alibaba.dubbo.common.serialize.Serialization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author hzyemao
 * @version 1.0 , 2017/9/3
 */
//@Activate(group = {Constants.PROVIDER, Constants.CONSUMER})
public class N3ProtobufSerialization implements Serialization {

    private static final Logger log = LogManager.getLogger(N3ProtobufSerialization.class);
    @Override
    public byte getContentTypeId() {
        return 99;
    }

    @Override
    public String getContentType() {
        return "text/plain";    //无格式文本
    }

    @Override
    public ObjectOutput serialize(URL url, OutputStream output) throws IOException {
        log.info("使用n3ProtobufSerialization进行序列化, url=" + url.toFullString());
        return new ProtobufObjectOutput(output);
    }

    @Override
    public ObjectInput deserialize(URL url, InputStream input) throws IOException {
        log.info("使用n3ProtobufSerialization进行反序列化, url=" + url.toFullString());
        return null;
    }
}
