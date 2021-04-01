package com.bytedance.android.aabresguard.commands;

import com.android.tools.build.bundletool.flags.FlagParser;
import com.bytedance.android.aabresguard.AabResGuardMain;
import com.bytedance.android.aabresguard.BaseTest;
import com.bytedance.android.aabresguard.commands.AabSignCommand;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by YangJing on 2019/10/16 .
 * Email: yangjing.yeoh@bytedance.com
 */
public class AabSginCommandTest extends BaseTest {

    @Test
    public void test_sign_aab() throws IOException, InterruptedException {
        Path bundlePath = loadResourceFile("demo/demo.aab").toPath();
        String inputAabPath = bundlePath.toString();
        String outputAabPath = inputAabPath.replace(".aab", "-signed.aab");
        assert !new File(outputAabPath).exists() || new File(outputAabPath).delete();

        System.out.println("sign aab: " + inputAabPath);
        AabSignCommand.fromFlags(
                new FlagParser().parse(
                        "--bundle=" + inputAabPath,
                        "--output=" + outputAabPath
                )
        ).execute();
    }
}
