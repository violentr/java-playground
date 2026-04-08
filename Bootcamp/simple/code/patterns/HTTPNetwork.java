package simple.code.patterns;

// The REAL object — private constructor, nobody can create it directly
/* Builder Pattern */
public class HTTPNetwork {
    private final String url;        // final! Cannot change after build
    private final int port;
    private final String userAgent;

    //  Private — only Builder can call this
    private HTTPNetwork(Builder builder) {
        this.url = builder.url;
        this.port = builder.port;
        this.userAgent = builder.userAgent;
    }

    //  The Builder lives INSIDE Network
    public static class Builder {
        private String url;
        private int port = 80;       // defaults live here
        private String userAgent = "Mozilla/5.0";

        public Builder(String url) {
            this.url = url;          //  required param in constructor
        }

        public Builder port(int port) {
            this.port = port;
            return this;             //  returns Builder so you can chain
        }

        public Builder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;             //  same here
        }

        public HTTPNetwork build() {
            return new HTTPNetwork(this); //  THIS is where Network is born
        }
    }
}
