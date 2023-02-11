public class Main {
    public static void main(String[] args) {
        String url = ("www.naver.com/books/it?page=10&size=20&name=spring-boot");

        //base 64 encodding

        //외부에서 주입을 받는 것을 DI라고 함.
        //url encoding
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);
        System.out.println(result);

    }
}