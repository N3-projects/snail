package yemaofpa;

import com.google.protobuf.InvalidProtocolBufferException;
import n3.sail.protobuf.schema.UserCacheSchema;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author N3 on 2017/11/22.
 */
public class TestUserCacheSchema {

    @Test
    public void simpleTest() {
        UserCacheSchema.CoreAccountDTO.Builder coreAccountBuilder = UserCacheSchema.CoreAccountDTO.newBuilder();
        coreAccountBuilder.setCoreAccountId("coreAccountId");
        coreAccountBuilder.setStatus("NORMAL");
        UserCacheSchema.CoreAccountDTO coreAccount = coreAccountBuilder.build();

        UserCacheSchema.OperatorDTO.Builder operatorBuilder = UserCacheSchema.OperatorDTO.newBuilder();
        operatorBuilder.setOperatorId("operatorId");
        operatorBuilder.setType("URS");
        UserCacheSchema.OperatorDTO operator = operatorBuilder.build();

        UserCacheSchema.UserCacheDTO.Builder builder = UserCacheSchema.UserCacheDTO.newBuilder();
        builder.setCoreAccountDTO(coreAccount);
        builder.setOperatorDTO(operator);
        UserCacheSchema.UserCacheDTO userCache = builder.build();

        byte[] userBytes = userCache.toByteArray();
        Map<String, Object> cache = new HashMap<>();
        // ... 保存至缓存
        cache.put("operatorId", userBytes);

        // ... 从缓存读取
        byte[] loadCache = (byte[])cache.get("operatorId");
        UserCacheSchema.UserCacheDTO loadUser = null;
        try {
            loadUser = UserCacheSchema.UserCacheDTO.parseFrom(loadCache);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(loadUser);
        System.out.println(loadUser.getCoreAccountDTO().getCoreAccountId());
        System.out.println(loadUser.getCoreAccountDTO().getStatus());
        System.out.println(loadUser.getOperatorDTO().getOperatorId());
        System.out.println(loadUser.getOperatorDTO().getType());
    }
}
