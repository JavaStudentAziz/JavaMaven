package lesson22;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        CopyBufferIO bufferIO = new CopyBufferIO();
        FileCopyChannel copyChannel = new FileCopyChannel();
        FileCopyNio copyNio = new FileCopyNio();

        try {

            long start2 = System.currentTimeMillis();
            copyNio.copy("C:\\Users\\Камиля\\Downloads\\jdk-20_windows-x64_bin.exe","zxc2.exe");
            long end2 = System.currentTimeMillis();
            System.out.println("CopyNio " + (end2 - start2));

            long start = System.currentTimeMillis();
            bufferIO.copy("C:\\Users\\Камиля\\Downloads\\jdk-20_windows-x64_bin.exe","zxc.exe");
            long end = System.currentTimeMillis();
            System.out.println("CopyBufferIO " + (end - start));

            long start1 = System.currentTimeMillis();
            copyChannel.copy("C:\\Users\\Камиля\\Downloads\\jdk-20_windows-x64_bin.exe","zxc1.exe");
            long end1 = System.currentTimeMillis();
            System.out.println("CopyChannelNio " + (end1- start1));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
