package org.server.data.util;

import static org.junit.Assert.*;
import org.junit.Test;
import org.server.security.EncryptUtil;

/**
 * 测试加密工具是否能正确进行加密和解密
 * @author Hirico
 * @version 2016/12/07 Hirico
 */
public class EncryptTest {

	@Test
	public void testEncryptAndDecrypt() {
		String charAndNum = "!test Text1";
		String chineseAdded = " 测试文字test@1 ";
		assertEquals(EncryptUtil.decrypt(EncryptUtil.encrypt(charAndNum)), charAndNum);
		assertEquals(EncryptUtil.decrypt(EncryptUtil.encrypt(chineseAdded)), chineseAdded);
	}
}
