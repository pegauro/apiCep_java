package model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import javax.swing.JOptionPane;

public class RequestApi {           
    public static String api(String API_URL) {
        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+API_URL+"/json"))
                .build();
        
        
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200){
                return response.body();
            }else{
               JOptionPane.showMessageDialog(null,"Falha da requisição: "+ response.statusCode());
            }
        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }    
        return null;
    }    
}
