# Lab Report 2
Name: Arjun Sarup

PID: A17527244

Email: asarup@ucsd.edu

---

## Part 1 - StringServer

For this section of the lab, I created a file called StringServer.java that operates on a local port and allows the user to add strings to a list and see the contents. My implementation can be seen in the code below:

```
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    String result = "";

    public String handleRequest(URI url){
        
        if(url.getQuery() != null) {
            String[] parameters = url.getQuery().split("=");
            if(url.getPath().equals("/add-message")) {
                if(parameters[0].equals("s")) {
                    result += (result == "" ? "" : "\n") + parameters[1];
                    return result;
                }
            } 
        }
        return "";
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
```

Essentially, once the server is created, if the path contains something of the form `/add-message?s=[STRING]`, then the `[STRING]` is concatenated to the output, with each string separated by a new line. (It's worth noting that the `URLHandler` interface that my progam implements can be found in the Server.java file from the wavelet repo.) The results look something like this:

![StringServer Demo 1](StringServer_Demo_1.png)
In this example, the URL is `localhost:6401/add-message?s=Hello, world!` (the `%20` in the example is read as a space). This URL is passed to the `handleRequest(URI url)` method of the `Handler()` object, which was created in with `Server.start(port, new Handler());` when the program was executed in the terminal. Then, the path of `url` is checked to ensure that it is in the correct format, which it is in this instance. From there, the query is parsed into `s` and `Hello, world!`, and the latter item is concatenated to `result`, which is a String property of the class. Finally, the `result` property is returned, printing it onto the screen.

![StringServer Demo 2](StringServer_Demo_2.png)
Similar to the last example, the `handleRequest(URI url)` method is called, setting `url` equal to `localhost:6401/add-message?s=StringServer`, and `url` is then checked for any invalid format. Since `url` is structured properly, the query is split into `s` and `StringServer`, and StringServer's `result` property is updated to now be the string `Hello, world!\nStringServer`. When `result` is returned, it is printed onto the screen, displaying `Hello, world!` and `StringServer` on separate lines.



