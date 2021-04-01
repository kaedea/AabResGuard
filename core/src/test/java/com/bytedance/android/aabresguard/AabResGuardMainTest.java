package com.bytedance.android.aabresguard;

import org.junit.Test;

import java.io.File;
import java.nio.file.Path;

/**
 * Created by YangJing on 2019/10/16 .
 * Email: yangjing.yeoh@bytedance.com
 */
public class AabResGuardMainTest extends BaseTest {

    @Test
    public void test_help() {
        AabResGuardMain.main(
                new String[]{
                        "help"
                }
        );
    }

    @Test
    public void test_sign_aab() {
        Path bundlePath = loadResourceFile("demo/demo.aab").toPath();
        String inputAabPath = bundlePath.toString();
        String outputAabPath = inputAabPath.replace(".aab", "-signed.aab");
        assert !new File(outputAabPath).exists() || new File(outputAabPath).delete();

        System.out.println("sign aab: " + inputAabPath);
        AabResGuardMain.main(
                new String[]{
                        "sign-aab",
                        "--bundle=" + inputAabPath,
                        "--output=" + outputAabPath,
                }
        );
    }
}
