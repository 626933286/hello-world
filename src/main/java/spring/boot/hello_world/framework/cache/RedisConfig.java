/*package spring.boot.hello_world.framework.cache;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

@Configuration
public class RedisConfig {
    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;
    
    @Value("${spring.redis.cluster.timeOut}")
    private int timeOut = 2000;
    
    @Value("${spring.redis.cluster.max-redirects}")
    private int redirects = 8;
    
    @Bean
    public RedisClusterConfiguration getClusterConfiguration() {
        Map<String, Object> source = new HashMap<String, Object>();
        source.put("spring.redis.cluster.nodes", clusterNodes);
        source.put("spring.redis.cluster.timeout", timeOut);
        source.put("spring.redis.cluster.max-redirects", redirects);
        return new RedisClusterConfiguration(new MapPropertySource("RedisClusterConfiguration", source));
    }
    
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory cf = null;
        if( clusterNodes != null && !clusterNodes.isEmpty() ){
            cf = new JedisConnectionFactory( getClusterConfiguration() );
        }
        cf.afterPropertiesSet();
        return cf;
    }
    
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> rt = new RedisTemplate<String, Object>();
        rt.setConnectionFactory( redisConnectionFactory() );
        return rt;
    }
    
     *//**
     *序列化
     * <p style="display:none">modifyRecord</p>
     * <p style="display:none">version:V1.0,author:337084,date:2017年11月21日 下午3:44:51,content:TODO </p>
     * @author 337084
     * @date 2017年11月21日 下午3:44:51
     * @since
     * @version
     *//*
    public static enum StringSerializer implements RedisSerializer<String> {
        INSTANCE;

        @Override
        public byte[] serialize(String s) throws SerializationException {
            return (null != s ? s.getBytes() : new byte[0]);
        }

        @Override
        public String deserialize(byte[] bytes) throws SerializationException {
            if (bytes.length > 0) {
                return new String(bytes);
            } else {
                return null;
            }
        }
    }

    public static enum LongSerializer implements RedisSerializer<Long> {
        INSTANCE;

        @Override
        public byte[] serialize(Long aLong) throws SerializationException {
            if (null != aLong) {
                return aLong.toString().getBytes();
            } else {
                return new byte[0];
            }
        }

        @Override
        public Long deserialize(byte[] bytes) throws SerializationException {
            if (bytes.length > 0) {
                return Long.parseLong(new String(bytes));
            } else {
                return null;
            }
        }
    }

    public static enum IntSerializer implements RedisSerializer<Integer> {
        INSTANCE;

        @Override
        public byte[] serialize(Integer i) throws SerializationException {
            if (null != i) {
                return i.toString().getBytes();
            } else {
                return new byte[0];
            }
        }

        @Override
        public Integer deserialize(byte[] bytes) throws SerializationException {
            if (bytes.length > 0) {
                return Integer.parseInt(new String(bytes));
            } else {
                return null;
            }
        }
    }

}
*/