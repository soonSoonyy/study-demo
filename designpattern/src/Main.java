import adapter.*;
import proxy.BrowerProxy;
import proxy.Browser;
import proxy.IBrowser;
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

//        Authentication authentication = new Authentication();
//        allocated(authentication);
//
//        Authorize authorize = new Authorize();
//        ApiVersion1 authorizeAdapter = new SocketAdapter(authorize);
//        allocated(authorizeAdapter);
//
//        Login login = new Login();
//        ApiVersion1 LoginAdapter = new SocketAdapter(login);
//        allocated(LoginAdapter);

        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
    // 이럴 경우 여러번 실행이 되면서 캐시 기능이 구현되지 않고 있다.


        IBrowser browserCache = new BrowerProxy("www.naver.com");
        browserCache.show();
        browserCache.show();
        browserCache.show();
        /*
        이럴 경우 첫번째의 경우에만 로딩이 되고,
        이후에 호출 되는 내용은 캐싱을 사용 하는 개념이 된다.
        */

    }

    public static void allocated(ApiVersion1 apiVersion1){
        apiVersion1.initialized();
    }
}