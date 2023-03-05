import adapter.*;
import singleton.AClazz;
import singleton.BClazz;
import singleton.SocketClient;

public class Main {
    public static void main(String[] args) {


        /*
        * 싱글톤 테스트
        * */
//        AClazz aClazz = new AClazz();
//        BClazz bClazz = new BClazz();
//
//        SocketClient aSocketClient = aClazz.getSocketClient();
//        SocketClient bSocketClient = bClazz.getSocketClient();
//
//        System.out.println("두 객체는 서로 동일한가?");
//        System.out.println(aSocketClient.equals(bSocketClient));
        // 결과는 true

        /*
        * 어뎁터 패턴 테스트
        * */

        Authentication authentication = new Authentication();
        allocated(authentication);

        Authorize authorize = new Authorize();
        ApiVersion1 authorizeAdapter = new SocketAdapter(authorize);
        allocated(authorizeAdapter);

        Login login = new Login();
        ApiVersion1 LoginAdapter = new SocketAdapter(login);
        allocated(LoginAdapter);

    }

    public static void allocated(ApiVersion1 apiVersion1){
        apiVersion1.initialized();
    }
}