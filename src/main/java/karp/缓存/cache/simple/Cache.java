package karp.缓存.cache.simple;

/**
 * @Author: pjx
 * @Date: 2018/12/25 11:53
 * @Version 1.0
 */
public class Cache {

    private String key;//缓存ID
    private Object value;//缓存数据
    private long timeOut;//过期时间

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    private boolean expired; //是否终止

    public Cache() {
        super();
    }

    public Cache(String key, Object value, long timeOut, boolean expired) {
        this.key = key;
        this.value = value;
        this.timeOut = timeOut;
        this.expired = expired;
    }


}
class TestCache{
    public static void main(String[] args) {
        CacheManager.setSimpleFlag("wp",true);
        System.out.println(CacheManager.getSimpleFlag("wp"));
        System.out.println(CacheManager.getSimpleFlag("alksd"));
        CacheManager.putCache("abc", new Cache());
        CacheManager.putCache("def", new Cache());
        CacheManager.putCache("ccc", new Cache());
        CacheManager.clearKey("");
        Cache c = new Cache();
        for (int i = 0; i < 10; i++) {
            CacheManager.putCache("" + i, c);
        }
//        CacheManager.putCache("aaaaaaaa", c);
//        CacheManager.putCache("abchcy;alskd", c);
//        CacheManager.putCache("cccccccc", c);
//        CacheManager.putCache("abcoqiwhcy", c);
//        System.out.println("删除前的大小："+CacheManager.getCacheSize());
//        CacheManager.getCacheAllkey();
//        CacheManager.clearAll("a");
//        System.out.println("删除后的大小："+CacheManager.getCacheSize());
//        CacheManager.getCacheAllkey();
    }
}
