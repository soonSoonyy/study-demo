package aop;

import proxy.Html;
import proxy.IBrowser;

public class AopBrower implements IBrowser {

    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;

    public AopBrower (String url, Runnable before, Runnable after){
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {
        before.run();

        if(html == null){
            this.html = new Html(url);
            System.out.println("This is Browser Proxy loading from html "+ url );
            try{
                Thread.sleep(1500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        after.run();
        System.out.println("This is Browser Proxy use Cache html " + url );
        return html;
    }
}