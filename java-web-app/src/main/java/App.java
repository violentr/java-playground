public class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Test test = new Test();
        System.out.println(test.example);
//        String contextPath = "/";
//        String webappDirLocation = "src/main/webapp/";
//        String baseDirectory = new File(webappDirLocation).getAbsolutePath();
//
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8090);
//        StandardContext context = (StandardContext) tomcat.addWebapp(contextPath, baseDirectory);
//
//        // Additions to make @WebServlet work
//        String buildPath = "target/classes";
//        String webAppMount = "/WEB-INF/classes";
//
//        File additionalWebInfClasses = new File(buildPath);
//        WebResourceRoot resources = new StandardRoot(context);
//        resources.addPreResources(new DirResourceSet(resources, webAppMount, additionalWebInfClasses.getAbsolutePath(), contextPath));
//        context.setResources(resources);
//        // End of additions
//
//        tomcat.start();
//        tomcat.getServer().await();

    }
}
