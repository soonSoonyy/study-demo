package strategy;

public class AppendStrategy implements EncodingStrategy{

    @Override
    public String encode(String str) {
        return "Append Strategy String: " + str;
    }
}
