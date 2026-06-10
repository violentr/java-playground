package simple.code.patterns;

public class RunHTTPNetwork {
    public static void main(String[] args) {
        /*
         *  Builder Pattern
         * 1. Create an object HTTPNetwork.Builder (static)
         * 2. Set the properties url, port, userAgent
         * 3. Build the object new HTTPNetwork(builder)
         *
         * */
        HTTPNetwork net = new HTTPNetwork.Builder("https://www.google.co.uk")
                .port(443)
                .userAgent("Mozilla/5.0")
                .build();
        System.out.println(net.getUrl());
    }
}