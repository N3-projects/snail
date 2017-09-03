package n3.distribution.lock.sync;

/**
 * @author N3 on 2017/6/12.
 */
public class LockResource {

    private int expireTime;
    private String value;

    public LockResource(int expireTime, String value) {
        this.expireTime = expireTime;
        this.value = value;
    }

    public int getExpireTime() {
        return expireTime;
    }

    public String getValue() {
        return value;
    }
}
