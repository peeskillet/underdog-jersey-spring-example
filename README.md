Jersey and Spring Example with Java Config (no web.xml)
===

There are Jersey - Spring integrated examples out there using web.xml configuration,
but I haven't found many that used all Java configurations. It may be due to the fact
that there is no examples in the Jersey documentation, or that fact that the way
the `jersey-spring3` module is built makes it difficult to make this integration,
without digging into the source code.

What happens is that Jersey's `SringWebInitializer` registers its own `ContextLoaderListener`
and our attempt to load another one from our `WebApplicationInitializer` causes an 
exception to be thrown. This caused a lot of headache for me. 

I then discovered this [issue filed](https://java.net/jira/browse/JERSEY-2038) which
had some work-arounds. So I put together a little project, taking some helpful hints
from comments.

**Required:** Maven (to build)

**Recommended:** [cURL](http://curl.haxx.se/) (for testing)

###Build, Run, and Test:

1. Package Maven project (after resolving dependencies, two test should be ran and should pass)

        mvn clean package

2. Run project with [jetty-maven-plugin](http://eclipse.org/jetty/documentation/current/jetty-maven-plugin.html). 
This is not required, but I prefer it in development, rather than deploying to local server instance.

        mvn jetty:run

3. Run cURL command to test (not required, you can simple use the browser url bar

        curl -i http://localhost:8080/rest/greeting?name=Peeskillet
    **Result**

        curl -i http://localhost:8080/rest/greeting?name=Peeskillet
        HTTP/1.1 200 OK
        Content-Type: text/plain
        Content-Length: 20
        Server: Jetty(9.2.4.v20141103)

        Bonjour, Peeskillet!