package facade;

public class Ftp {
    private String host;
    private int port;
    private String path;

    public Ftp(String host, int port, String path) {
        this.host = host;
        this.port = port;
        this.path = path;
    }

    public void connect(){
        System.out.println("FTP Connecting to " + host + ":" + port);
    }
    public void moveDirectory(){
        System.out.println("FTP Move Directory to path " + path);
    }
    public void disconnect(){
        System.out.println("FTP Disconnect to " + host + ":" + port);

    }
}
