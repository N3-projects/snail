package n3.java.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**将输出流转换为输入流，并打印出来<br>
 * <b>tips:</b>基本思路就两种<br>
 * 1.通过ByteArray进行转化，适合数据量较小的情况<br>
 * 2.通过本地文件进行转化，适合大量数据，但有磁盘IO性能损耗
 * @author n3 on 2016/12/12.
 */
public class Output2Input {

    public static void main(String[] args) throws IOException {
        String source = "sdfj23\n89fh83\nf7834yf\n8gf823\n";
        System.out.println(source);
        File file = new File("D://test.txt");
        FileOutputStream output = new FileOutputStream("D://test.txt");
        output.write(source.getBytes());
        output.flush();
        output.close();
        //写入本地文件end

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        FileChannel outChannel = new FileOutputStream("D://test2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate( 1024 );
        while (br.ready())
        {
            buffer.clear();
            String str = br.readLine();
            buffer.put((str.replace("\n","")+"1111"+"\n").getBytes());
            buffer.flip();
            outChannel.write(buffer);
            outChannel.force(true);
        }

        br.close();
        outChannel.close();
    }
}
