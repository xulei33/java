package org.xulei.url;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * url service
 *
 *@author Lei
 */
@Service
public class UrlService {
    private static final Logger LOG = LoggerFactory.getLogger(UrlService.class);

    @Autowired
    private JedisPool pool;

    @Autowired
    private UrlRepository repo;

    @Autowired
    private Environment env;

    public void generate(Url url) {
        try (Jedis jedis = pool.getResource()) {
	        	long urlId = repo.generalUrlId();
	        	url.setUrlId(urlId);
	        	url.setCode(CodeTransfer.decode(urlId));
	        	repo.create(url);//persistent to Database
            	jedis.hset(env.getProperty("redis.url.key"), url.getCode(), JsonUtils.mapper.writeValueAsString(url));//add redis
        } catch (Exception e) {
            LOG.error("generate url exception", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public Url getUrlByCode(String code) throws Exception {
    	Url url =null;
        try (Jedis jedis = pool.getResource()) {
            String result = jedis.hget(env.getProperty("redis.urls.key"), code);
            if (result == null){
            	url = repo.findUrlByCode(code);
            }
//        return result == null ? null : JsonUtils.DEFAULT_GSON.fromJson(result, Url.class);
            return result == null ? null :  JsonUtils.mapper.readValue(result, Url.class);
        }
    }
    
    public void createUrlVisitlog(UrlVisitlog visitlog) {
    	repo.createUrlVisitlog(visitlog);
    }
}
