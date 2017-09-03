package n3.snail.dubbo.serialization;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.serialize.ObjectInput;
import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.alibaba.dubbo.common.serialize.Serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author hzyemao
 * @version 1.0 , 2017/9/3
 */
public class N3Serialization implements Serialization {

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
        return null;
    }

    @Override
    public ObjectInput deserialize(URL url, InputStream input) throws IOException {
        return null;
    }
}
