package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OTP {

    private final String USER_AGENT = "Mozilla/5.0";
    private String phoneNumber = "";
    private String message = "";

    public void setMessage(String message) {
        String[] temp = message.split(" ");
        StringBuilder mes = new StringBuilder();
        for (String str :
                temp) {
            mes.append(str).append("%20");
        }
        this.message = mes.toString().trim();
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.charAt(0) != '0')
            phoneNumber = "0" + phoneNumber;
        this.phoneNumber = phoneNumber;
    }

    public String send() throws Exception {
        String url = "https://raygansms.com/SendMessageWithCode.ashx?Username=a0forghani&Password=09145030651&Mobile=" + phoneNumber + "&Message=" + message;

        RestTemplate restTemplate = new RestTemplate();
        String results = restTemplate.getForObject(url, String.class);
        assert results != null;
        if (results.length()<3)
            throw new Exception("some thing wrong with SMS");
        System.out.println(results);
        return results;
//            URL obj = new URL(url);
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//            // optional default is GET
//            con.setRequestMethod("GET");
//
//            //add request header
//            con.setRequestProperty("User-Agent", USER_AGENT);
//
////            int responseCode = con.getResponseCode();
////            System.out.println("\nSending 'GET' request to URL : " + url);
////            System.out.println("Response Code : " + responseCode);
//
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuilder response = new StringBuilder();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//            if (Integer.parseInt(response.toString()) > 2000) {
//                status = true;
//                return "پیام با موفقیت ارسال شد.";
//            }else
//                return response.toString();
//        } catch (UnknownHostException e) {
//            return "خطای اتصال به اینترنت";

    }

}

