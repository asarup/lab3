import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    String result = "";

    public String handleRequest(URI url){
        
        if(url.getQuery() != null) {
            String[] parameters = url.getQuery().split("=");
            if(url.getPath().contains("/add-message")) {
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
