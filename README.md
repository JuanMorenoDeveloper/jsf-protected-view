# jsf-protected-view

CustomExternalContext sample to fix a problem with protected-views and params in JSF 2.2.11 or above. 

Commit to the implementation where change token from Timestamp to SecureToken: 
https://github.com/javaserverfaces/mojarra/commit/ab72d90c45fcca422e80d4db95d232d6f38239b4

Related issue:
https://github.com/javaee/javaserverfaces-spec/issues/1161
https://github.com/javaserverfaces/mojarra/issues/4139

Current implementation of ExternalContext:
https://github.com/javaserverfaces/mojarra/blob/master/impl/src/main/java/com/sun/faces/context/ExternalContextImpl.java</h5>

You can execute the sample with `mvn jetty:run` command and hit [http://localhost:8080/jsf-protected-view/](http://localhost:8080/jsf-protected-view/) to run the page.
