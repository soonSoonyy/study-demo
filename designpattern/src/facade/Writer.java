package facade;

public class Writer {
    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect(){
        String msg = String.format("Writer %s connected to file", fileName);
        System.out.println(msg);
    }
    public void fileWrite(){
        String msg = String.format("Writer %s file", fileName);
        System.out.println(msg);

    }
    public void fileDisconnect() {
        String msg = String.format("Writer %s Disconnected to file", fileName);
        System.out.println(msg);
    }
}
