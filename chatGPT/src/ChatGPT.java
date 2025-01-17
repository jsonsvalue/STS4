import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChatGPT {
	
   private static String GPT_URL = "https://api.openai.com/v1/chat/completions";

   public static void main(String[] args) throws IOException {
      URL url = new URL(GPT_URL);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
      connection.setDoInput(true);
      connection.setDoOutput(true);
      
      JSONObject data = new JSONObject();
      data.put("model", "gpt-3.5-turbo");
      data.put("temperature", 0.7);
      
      JSONObject message = new JSONObject();
      message.put("role", "user");
      message.put("content", "안녕? Chat GPT에 대해 자세하게 소개해줘.");
    		  
      JSONArray messages = new JSONArray();
      messages.put(message);
      
      data.put("messages", messages);
      
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
      bw.write(data.toString());
      bw.flush();
      bw.close();
      
      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String line = null;
      
      while ((line = br.readLine()) != null) {
         sb.append(line);
      }
      
      System.out.println(sb.toString());
   }
}