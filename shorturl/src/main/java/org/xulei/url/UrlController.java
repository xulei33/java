package org.xulei.url;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * short url controller.
 *
 * @author Lei
 */
@Controller
public class UrlController {
    private static Pattern URL = Pattern.compile("https?://[^\\s]+");
//    private static  Base64.Encoder urec = Base64.getUrlEncoder();
//    private static  Base64.Decoder urdc= Base64.getUrlDecoder();
    
    @Autowired
    private UrlService service;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> post(@RequestParam(value="url", required=true, defaultValue="") String longUrl,
    		@RequestParam(value="sysId", required=true)  String sysId,
    		@RequestParam(value="custId", required=false, defaultValue="")  String custId,
    		@RequestParam(value="traceCode", required=false, defaultValue="") String traceCode) {

    	if (!URL.matcher(longUrl).matches()) {
            ResponseEntity.badRequest().body("invalid url");
        }
        //
        Url url = new Url();
        url.setLongUrl(longUrl);
        url.setCustId(custId);
        url.setSysId(Integer.getInteger(sysId));
        url.setTraceCode(traceCode);
        service.generate(url);
        return ResponseEntity.ok( env.getProperty("base.url")+url.getCode());
    }
    
    @RequestMapping(value = "/s", method = RequestMethod.GET)
    public ResponseEntity<String> get(
    		@RequestParam(value="url", required=true, defaultValue="") String longUrl,
    		@RequestParam(value="sysId", required=true)  String sysId,
    		@RequestParam(value="custId", required=false, defaultValue="")  String custId,
    		@RequestParam(value="traceCode", required=false, defaultValue="") String traceCode) {
    	try {
    		System.out.println(longUrl);
//    		longUrl=urdc.decode(longUrl.getBytes("UTF8")).toString();
    		longUrl=URLDecoder.decode(longUrl, "UTF8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException("Base64 UrlDecoder UTF8 decode url  failed");
		}
    	
        if (!URL.matcher(longUrl).matches()) {
            ResponseEntity.badRequest().body("invalid url");
        }
        //
        Url url = new Url();
        url.setLongUrl(longUrl);
        url.setCustId(custId);
        url.setSysId(Integer.getInteger(sysId));
        url.setTraceCode(traceCode);
        service.generate(url);
        return ResponseEntity.ok( env.getProperty("base.url")+url.getCode());
    }
    
    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public String redirect(@PathVariable("code") String code,
    		@RequestHeader("User-Agent") String userAgent ,
    		HttpServletRequest req, HttpServletResponse resp) {
    	
        Url url=null;
		try {
			url = service.getUrlByCode(code);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:http://" + env.getProperty("default.url");
		}
        if (url == null){
            return "redirect:http://" + env.getProperty("default.url");
        }
        //
        String ip=getIpAddr(req);
        //
        String cookie="";
        Cookie[] cookies = req.getCookies();
        for(Cookie c : cookies){
        	if(c.getName().equals(env.getProperty("cookie.name"))){
        		cookie=c.getValue(); 
        	}
        }
        
       if("".equals(cookie)){
    	   cookie=url.getCustId();
    	   Cookie c=new Cookie(env.getProperty("cookie.name"), url.getCustId());
    	   c.setMaxAge(31536000);//One year
    	   resp.addCookie(c);
       }
       
       UrlVisitlog visitlog=new UrlVisitlog();
       visitlog.setCode(url.getCode());
       visitlog.setSysId(url.getSysId());
       visitlog.setCustId(url.getCustId());
       visitlog.setTraceCode(url.getTraceCode());
       visitlog.setIp(ip);
       visitlog.setUserAgent(userAgent);
       visitlog.setCookie(cookie);
       service.createUrlVisitlog(visitlog);
       
       return "redirect:" + url.getLongUrl();
    }
    
   
    
    /**
     * 获取Client IP地址
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) { 
           String ip = request.getHeader("x-forwarded-for"); 
           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
               ip = request.getHeader("Proxy-Client-IP"); 
           } 
           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
               ip = request.getHeader("WL-Proxy-Client-IP"); 
           } 
           if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
               ip = request.getRemoteAddr(); 
               if(ip.equals("127.0.0.1")){   
            	   InetAddress inet=null;   
    	           try {   
    	        	   inet = InetAddress.getLocalHost();   
    	           } catch (UnknownHostException e) {   
    	        	   e.printStackTrace();   
    	           }   
    	           ip= inet.getHostAddress();   
               }
           } 
           if(ip != null && ip.length() > 15){  
               if(ip.indexOf(",")>0){   
                   ip = ip.substring(0,ip.indexOf(","));   
               }   
           }   
           return ip; 
    }
}
