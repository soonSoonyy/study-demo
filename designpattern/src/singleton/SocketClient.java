package singleton;


public class SocketClient {

    private static SocketClient socketClient;

    // 기본 생성자를 막는다. //왜? 생성을 막기 위해서
    // 이 로직 밖에 없는지는 확인이 필요
    private SocketClient(){}

    // 이 메소드를 통해서 객체를 전달 할 수 있게 한다.
    public static SocketClient getInstance(){

        //null인 경우 생성 해준다.
        if(socketClient == null){
            socketClient = new SocketClient();
        }

        return socketClient;

    }

    public void connect(){
        System.out.println("connect Start");
    }

}
