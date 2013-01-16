/*
 * Copyright 2012 Ivan Masmitjà
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.comapctsys.androlib.samples.tests;

import android.test.AndroidTestCase;
import android.test.MoreAsserts;

import net.comapctsys.androlib.samples.MyApplication;
import net.compactsys.androlib.crypto.SimpleCrypto;

public class TestSimpleCrypto extends AndroidTestCase {

    public void testEncriptAndDecryptString() {
        String original = "original text 123456 ()[]´ÑÇ";

        String encrypted = SimpleCrypto.encrypt(original, MyApplication.getInstance().getApplicationContext());
        MoreAsserts.assertNotEqual("orignail and ecripted must be different", original, encrypted);

        String decrypted = SimpleCrypto.decrypt(encrypted, MyApplication.getInstance().getApplicationContext());
        MoreAsserts.assertNotEqual("orignail and ecripted must be different",decrypted, encrypted);

        assertEquals("orignail and ecripted must be equals", original, decrypted);
    }
}
