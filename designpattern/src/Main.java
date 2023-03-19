import adapter.*;
import aop.AopBrower;
import decorator.*;
import observer.Button;
import observer.IButtonListener;
import proxy.BrowerProxy;
import proxy.Browser;
import proxy.IBrowser;
import singleton.AClazz;
import singleton.BClazz;
import singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

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

//        Browser browser = new Browser("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
    // 이럴 경우 여러번 실행이 되면서 캐시 기능이 구현되지 않고 있다.


//        IBrowser browserCache = new BrowerProxy("www.naver.com");
//        browserCache.show();
//        browserCache.show();
//        browserCache.show();
        /*
        이럴 경우 첫번째의 경우에만 로딩이 되고,
        이후에 호출 되는 내용은 캐싱을 사용 하는 개념이 된다.
        */


//        AtomicLong start = new AtomicLong();
//        AtomicLong end = new AtomicLong();
//
//        IBrowser aopBrower = new AopBrower("www.naver.com",
//                () -> {
//                    System.out.println("before");
//                    start.set(System.currentTimeMillis());
//                },
//                () -> {
//                    System.out.println("after");
//                    long now = System.currentTimeMillis();
//                    end.set(now - start.get());
//                }
//        );
//
//        aopBrower.show();
//        System.out.println("loading Time " + end.get());
//        //첫번 째는 로딩이 되기 때문에 Sleep 으로 걸었던 시간만큼 시간이 찍힌다.
//
//        aopBrower.show();
//        System.out.println("loading Time " + end.get());
//        //두 번째의 경우 cache를 사용 하기 때문에 end.get() 은 0이 된다.


        /*
        * 데코레이터 패턴
        * */
//        ICar audi = new Audi(1000);
//        audi.showPrice();
//        // 결과 : audi 의 가격은 1000 원 입니다.
//
//        //A3
//        ICar audi3 = new A3(audi, "A3");
//        audi3.showPrice();
//        //결과 : A3 의 가격은 2000 원 입니다.
//
//        //A4
//        ICar audi4 = new A4(audi, "A4");
//        audi4.showPrice();
//        //결과 : A4 의 가격은 3000 원 입니다.
//
//
//        //A5
//        ICar audi5 = new A5(audi, "A5");
//        audi5.showPrice();
//        //결과 : A5 의 가격은 4000원 입니다.

        /*
        * 옵저버 패턴
        * */
        Button button = new Button("button");

        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });


        button.click("메세지 전달 : click1");
        button.click("메세지 전달 : click2");
        button.click("메세지 전달 : click3");
        button.click("메세지 전달 : click4");

    }

    public static void allocated(ApiVersion1 apiVersion1){
        apiVersion1.initialized();
    }
}