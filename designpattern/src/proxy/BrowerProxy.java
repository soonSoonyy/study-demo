package proxy;

public class BrowerProxy implements IBrowser {
    private String url;
    private Html html;

    public BrowerProxy (String url){
        this.url = url;
    }

    @Override
    public Html show(){

        if(html == null){
            this.html = new Html(url);
            System.out.println("This is Browser Proxy loading from html " + url);
        }

        System.out.println("This is Browser Proxy use Cache html " + url );
        return this.html;
    }
}
