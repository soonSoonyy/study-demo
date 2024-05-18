package strategy;

public class NormalStrategy implements EncodingStrategy {
    @Override
    public String encode(String str) {
        return str;
    }
}
