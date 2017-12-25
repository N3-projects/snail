package n3.snail.java.regex;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

/**
 * @author N3 on 2017/11/15.
 */
public class TestPatternMatcher {

    private PatternMatcher patternMatcher;

    @BeforeClass
    public void beforeClass() {
        patternMatcher = new PatternMatcher();
    }

    @Test
    public void testIsPatternMatches() {
        assertTrue(Pattern.matches("\\d{11}", "11234512678"));
        assertTrue(patternMatcher.isPatternMatches("11234512678", "\\d{4}45.*"));
        assertTrue(patternMatcher.isPatternMatches("11623745", "^11\\d{1,5}45.*"));
        assertTrue(patternMatcher.isPatternMatches("ab72bfa0-60a7-4d16-a609-a06a0a91f6ee", "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}"));
        String access = "59.111.198.100 59.111.198.100 - [2017/11/15:16:10:06.910 +0800] \"GET /addWapTradeWithPayAccountIdAndHandFee?goodsName=gcdgoodname&platformPrivateField=segfpsiumfchyzmvoxtj&userIp=127.0.0.1&handFee=0.02&tradeAmount=0.12&platformTradeTime=2017-11-15+00%3A00%3A00&payAccountId=epayautotest%40163.com&buyerNickName=testBuyer&notifyUrl=https%3A%2F%2Fepay.163.com%2Fservlet%2Fcontroller%3Foperation%3DorderSuccess%26pId%3D1&platformTradeId=cmceuiwkthnptnqwtdhvpexxebuafcgqvkngezal&sellerNickName=my_platform2&platformId=http%3A%2F%2Fwww.google.com&logisticsType=0&signature=047912e777843a1848db1b8d97f5a2f615e5c02f59f35ae73af8e516a2f9361596e37a410e40ad6b7674b7dfa3398b01576fb8f3aa646d59d839a345a9ed11fd19781d5a852ea039747e2a2df312b83c6a8a74e1d447076f0675516d0c20b964b7d0f452a33d8fc9442f2f422af13b8640e8d79bfa6277aaa0acad0b64f3af96&sellerId=my_platform2%40wyb.163.com&category=2008&tradeType=1 HTTP/1.1\" 200 - \"-\" \"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0;)\" 8 abc-kRunfElDe9DgMU__v ab72bfa0-60a7-4d16-a609-000000000000 {hmux-0.0.0.0:6800-0$434224792}";
        assertTrue(patternMatcher.isPatternMatches("access", ".+[GET|POST] .+ "));
    }

    @Test
    public void testPatternSplit() {
        String[] split = patternMatcher.patternSplit("11234512678", "2\\d{1}");
        assertNotNull(split);
        assertTrue(split.length > 0);
        for (String str : split) {
            System.out.println(str);
        }
    }

    @Test
    public void testPatternSplitMax() {
        String source = "2017-11-15 00:00:49,938 - module.filter.ContextFilter [gateRouteLocalCacheCleanTimer] INFO  module.filter.ContextFilter(149)   - invoke url:dubbo://223.252.220.42:20866/com.netease.epay.gate.client.withdraw.service.UpdateTimeQueryService?accesslog=log/rpc_access.log&anyhost=true&application=epay-core&check=false&default.retries=0&default.timeout=2000&dubbo=2.4.9&interface=com.netease.epay.gate.client.withdraw.service.UpdateTimeQueryService&logger=log4j&methods=getGateServiceLogLevel,getLastPayGateUpdateVersion,getLatestWithdrawGateUpdateTime,getLastRuleUpdateVersion,getLastWithdrawUpdateVersion&payload=52428800&pid=30934&revision=3.5.26&sentry_target_cluster_name=gate-service-test&side=consumer&timestamp=1510303467601&version=1.0.0";
        String[] split = patternMatcher.patternSplitMax(source, " {1,}",9);
        assertNotNull(split);
        assertTrue(split.length == 9);
        assertTrue(split[8].startsWith("invoke"));
    }

}
