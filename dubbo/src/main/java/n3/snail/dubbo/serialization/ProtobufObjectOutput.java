package n3.snail.dubbo.serialization;

import com.alibaba.dubbo.common.serialize.ObjectOutput;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MapEntry;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author hzyemao
 * @version 1.0 , 2017/9/3
 */
public class ProtobufObjectOutput implements ObjectOutput {

    private OutputStream out;
    private String encode="utf-8";

    ProtobufObjectOutput(OutputStream output) {
        this.out = output;
    }

    @Override
    public void writeObject(Object obj) throws IOException {
        ((com.google.protobuf.MessageLite) obj).writeTo(out);

    }

    private static <K, V> void serializeMapTo(CodedOutputStream codedOutput, Map<K, V> m,
            MapEntry<K, V> defaultEntry, int fieldNumber) throws IOException {
        for (Map.Entry<K, V> entry : m.entrySet()) {
            codedOutput.writeMessage(fieldNumber, defaultEntry.newBuilderForType()
                            .setKey(entry.getKey())
                            .setValue(entry.getValue())
                            .build());
        }
    }

    @Override
    public void writeBool(boolean v) throws IOException {
        com.google.protobuf.BoolValue.newBuilder().setValue(v).build().writeTo(out);
    }

    @Override
    public void writeByte(byte v) throws IOException {
        com.google.protobuf.BytesValue.parseFrom(new byte[]{v}).writeTo(out);
    }

    @Override
    public void writeShort(short v) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeInt(int v) throws IOException {
        com.google.protobuf.Int32Value.newBuilder().setValue(v).build().writeTo(out);
    }

    @Override
    public void writeLong(long v) throws IOException {
        com.google.protobuf.Int64Value.newBuilder().setValue(v).build().writeTo(out);
    }

    @Override
    public void writeFloat(float v) throws IOException {
        com.google.protobuf.FloatValue.newBuilder().setValue(v).build().writeTo(out);
    }

    @Override
    public void writeDouble(double v) throws IOException {
        com.google.protobuf.DoubleValue.newBuilder().setValue(v).build().writeTo(out);
    }

    @Override
    public void writeUTF(String v) throws IOException {
//        writeBytes(v.getBytes(encode));
        com.google.protobuf.ByteString.copyFromUtf8(v).writeTo(out);
    }

    @Override
    public void writeBytes(byte[] v) throws IOException {
//        com.google.protobuf.BytesValue.parseFrom(v).writeTo(out);
        com.google.protobuf.ByteString.copyFrom(v).writeTo(out);
    }

    @Override
    public void writeBytes(byte[] v, int off, int len) throws IOException {
//        com.google.protobuf.StringValue.newBuilder().setValue(new String(v, off, len))
//                .build().writeTo(out);
        com.google.protobuf.ByteString.copyFrom(v, off, len).writeTo(out);
    }

    @Override
    public void flushBuffer() throws IOException {
        out.flush();
    }
}
