package adapter;

public class SocketAdapter implements ApiVersion1{
    private final ApiVersion2 apiVersion2;

    public SocketAdapter(ApiVersion2 apiVersion2){
        this.apiVersion2 = apiVersion2;
    }
    @Override
    public void initialized() {
        apiVersion2.allocated();
    }
}
