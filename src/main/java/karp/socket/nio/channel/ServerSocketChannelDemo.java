package karp.socket.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * @Author: pjx
 * @Date: 2018/12/20 16:26
 * @Version 1.0
 */
public class ServerSocketChannelDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("localhost", 1234));
        serverSocketChannel.configureBlocking(false);

        while (true) {
            //socketChannel.read()      socketChannel.write()
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel != null) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                socketChannel.read(byteBuffer);
                byteBuffer.flip();
                System.out.println("server received message: " + getString(byteBuffer));
                byteBuffer.clear();
                String message = "server sending message " + System.currentTimeMillis();
                System.out.println("server sends message: " + message);
                byteBuffer.put(message.getBytes());
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                break;
            }
        }
        try {
            serverSocketChannel.close();
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
