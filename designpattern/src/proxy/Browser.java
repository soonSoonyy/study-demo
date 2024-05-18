package proxy;

public class Browser implements IBrowser{
    private String url;

    public Browser(String url){
        this.url = url;
    }

    @Override
    public Html show() {
        System.out.println("This is browser loading from html" + url );
        return new Html(url);
    }
}
