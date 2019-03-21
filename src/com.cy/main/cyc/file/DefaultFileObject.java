package cyc.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * Created by wcy on 2019/3/21.
 */
public class DefaultFileObject implements FileObject {

    public static CharBuffer getCharContent(String file){
        InputStream in = null;
        ByteBuffer buffer = null;
        String encoding = System.getProperty("file.encoding");
        try {
            in = new FileInputStream(file);
            buffer = makeByteBuffer(in);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Charset.forName(encoding).decode(buffer);
    }

    public static ByteBuffer makeByteBuffer(InputStream in) throws IOException {
        int limit = in.available();
        if (limit < 1024) {
            limit = 1024;
        }
        ByteBuffer result = ByteBuffer.allocate(limit);
        int position = 0;
        while (in.available() != 0) {
            if (position >= limit){
                // expand buffer
                result = ByteBuffer.allocate(limit <<= 1).put((ByteBuffer)result.flip());
            }
            int count = in.read(result.array(), position, limit - position);

            if (count < 0){
                break;
            }
            result.position(position += count);
        }
        return (ByteBuffer)result.flip();
    }
}
