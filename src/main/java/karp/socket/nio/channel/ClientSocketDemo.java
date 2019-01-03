package karp.socket.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @Author: pjx
 * @Date: 2018/12/20 16:30
 * @Version 1.0
 */
public class ClientSocketDemo {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 1234));
        String message = "client sending message " + System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byteBuffer.clear();
        System.out.println("client sends message: " + message);
        byteBuffer.put(message.getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);

        while (true) {
            byteBuffer.clear();
            int readBytes = socketChannel.read(byteBuffer);
            if (readBytes > 0) {
                byteBuffer.flip();
                System.out.println("client receive message: " + getString(byteBuffer));
                break;
            }
        }

        try {
            socketChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getString(ByteBuffer byteBuffer) {
        Charset charset;
        CharsetDecoder decoder;
        CharBuffer charBuffer;
        try {
            charset = Charset.forName("UTF-8");
            decoder = charset.newDecoder();
            charBuffer = decoder.decode(byteBuffer.asReadOnlyBuffer());
            return charBuffer.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
