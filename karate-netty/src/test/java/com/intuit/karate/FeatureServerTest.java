package com.intuit.karate;

import com.intuit.karate.junit4.Karate;
import com.intuit.karate.netty.FeatureServer;
import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 *
 * @author pthomas3
 */
@RunWith(Karate.class)
@KarateOptions(features = "classpath:com/intuit/karate/client.feature")
public class FeatureServerTest {
    
    private static FeatureServer server;

    @BeforeClass
    public static void beforeClass() {
        File file = FileUtils.getFileRelativeTo(FeatureServerTest.class, "server.feature");
        server = FeatureServer.start(file, 0, false, null);
        int port = server.getPort();
        System.setProperty("karate.server.port", port + "");        
    }
    
    @AfterClass
    public static void afterClass() {
        server.stop();
    }

}