package edu.upc.eetac.ea.notas.oauth;

import org.apache.tomcat.util.codec.binary.StringUtils;

import com.visural.common.StringUtil;

public class Facebook {
    // get these from your FB Dev App
    private static final String api_key = "782128101833807";     
    private static final String secret = "59ea5ce57440186560a4542d13c07c2a";
    private static final String client_id = "1877b5165659212f2e5f783231546753";  

    // set this to your servlet URL for the authentication servlet/filter
    private static final String redirect_uri = "http://www.onmydoorstep.com.au/fbauth"; 
    /// set this to the list of extended permissions you want
    private static final String[] perms = new String[] {"publish_stream", "email"};

    public static String getAPIKey() {
        return api_key;
    }

    public static String getSecret() {
        return secret;
    }

    public static String getLoginRedirectURL() {
        return "https://graph.facebook.com/oauth/authorize?client_id=" + 
            client_id + "&display=page&redirect_uri=" + 
            redirect_uri+"&scope="+StringUtil.delimitObjectsToString(",", perms);
       
        
    }

    public static String getAuthURL(String authCode) {
        return "https://graph.facebook.com/oauth/access_token?client_id=" + 
            client_id+"&redirect_uri=" + 
            redirect_uri+"&client_secret="+secret+"&code="+authCode;
    }
}