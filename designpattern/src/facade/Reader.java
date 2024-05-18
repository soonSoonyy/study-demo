package facade;

public class Reader {
    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect(){
        String msg = String.format("Reader %s connected to file", fileName);
        System.out.println(msg);
    }
    public void fileRead(){
        String msg = String.format("Reading %s file", fileName);
        System.out.println(msg);

    }
    public void fileDisconnect() {
        String msg = String.format("Reader %s Disconnected to file", fileName);
        System.out.println(msg);
    }
}
