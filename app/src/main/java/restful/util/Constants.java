package restful.util;

/**
 * Created by CodeKenn on 26/01/2017.
 */

public enum Constants {
    BASE_URL("https://api.github.com/"),
    ACCESS_TOKEN("fdcc749f66b0924e97e8dfa9032e94c95f613e2b");

    private String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
