public class ByteProcess {
    public static void main(String[] args) {
        System.out.println(process((byte) 0));
        System.out.println(process((byte) 128));
        System.out.println(process((byte) 192));
        System.out.println(process((byte) 224));
        System.out.println(process((byte) 240));
        System.out.println(process((byte) 248));
        System.out.println(process((byte) 252));
        System.out.println(process((byte) 254));
        System.out.println(process((byte) 255));
        System.out.println();
        System.out.println(process((byte) 55));
        System.out.println(process((byte) 190));
        System.out.println(process((byte) 199));
        System.out.println(process((byte) 235));
        System.out.println(process((byte) 247));
        System.out.println(process((byte) 250));
        System.out.println(process((byte) 253));
        System.out.println(process((byte) 254));
        System.out.println(process((byte) 255));
    }

private static int process(byte b) {
    int acc = 0;
    while(b < 0) {
        b = (byte) (b << 1);
        acc++;
    }
    return acc;
}
}
