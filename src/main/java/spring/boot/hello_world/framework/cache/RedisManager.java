package spring.boot.hello_world.framework.cache;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

@Component
public class RedisManager<T> {
    // 使用redisTemplate泛型 只能使用@Resource
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * <p>TODO(方法详细描述说明、方法参数的具体涵义)</p> 
     * @author 337084
     * @date 2017年11月21日 上午11:08:45
     * @param key
     * @return
     * @see
     */
    @SuppressWarnings("unchecked")
    public T get(String key, Class<T> type ) {
        logger.info("redis get 操作,key:" + key );
        redisTemplate.setKeySerializer(StringSerializer.INSTANCE );
        redisTemplate.setValueSerializer( new Jackson2JsonRedisSerializer<T>(type) );
        redisTemplate.afterPropertiesSet();
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        return (T)ops.get(key);
    }
    
    /**
     * <p>TODO(方法详细描述说明、方法参数的具体涵义)</p> 
     * @author 337084
     * @date 2017年11月21日 下午3:52:04
     * @param key
     * @param object
     * @param type
     * @see
     */
    public void set(String key, T object, Class<T> type) {
        logger.info("redis set 操作,key:" + key );
        redisTemplate.setKeySerializer(StringSerializer.INSTANCE );
        redisTemplate.setValueSerializer( new Jackson2JsonRedisSerializer<T>(type) );
        redisTemplate.afterPropertiesSet();

        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        ops.set( key, object );
    }
    
    /**
     * <p>TODO(方法详细描述说明、方法参数的具体涵义)</p> 
     * @author 337084
     * @date 2017年11月21日 上午11:10:28
     * @param key
     * @see
     */
    public void delObject( String key ) {
        logger.info("redis delete 操作,key:" + key );
        redisTemplate.setKeySerializer( StringSerializer.INSTANCE );
        redisTemplate.afterPropertiesSet();
        redisTemplate.delete( key );
    }
    
    
    /**
     *序列化
     * <p style="display:none">modifyRecord</p>
     * <p style="display:none">version:V1.0,author:337084,date:2017年11月21日 下午3:44:51,content:TODO </p>
     * @author 337084
     * @date 2017年11月21日 下午3:44:51
     * @since
     * @version
     */
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
