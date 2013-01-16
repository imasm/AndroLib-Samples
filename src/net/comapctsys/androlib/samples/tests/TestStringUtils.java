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

import net.compactsys.androlib.util.StringUtils;

public class TestStringUtils extends AndroidTestCase {

    public void testIsEmpty() {
        //isEmpty()
        assertEquals(StringUtils.isEmpty(null), true);
        assertEquals(StringUtils.isEmpty(""), true);
        assertEquals(StringUtils.isEmpty(" "), false);
        assertEquals(StringUtils.isEmpty("bob"), false);
        assertEquals(StringUtils.isEmpty("  bob  "), false);

        //isNotEmpty()
        assertEquals(StringUtils.isNotEmpty(null), false);
        assertEquals(StringUtils.isNotEmpty(""), false);
        assertEquals(StringUtils.isNotEmpty(" "), true);
        assertEquals(StringUtils.isNotEmpty("bob"), true);
        assertEquals(StringUtils.isNotEmpty("  bob  "), true);
    }

    public void testRepeat() {
        assertEquals(StringUtils.repeat(null, 2), null);
        assertEquals(StringUtils.repeat("", 0), "");
        assertEquals(StringUtils.repeat("", 2), "");
        assertEquals(StringUtils.repeat("a", 3), "aaa");
        assertEquals(StringUtils.repeat("ab", 2), "abab");
        assertEquals(StringUtils.repeat("a", -2), "");

        assertEquals(StringUtils.repeat(null, null, 2), null);
        assertEquals(StringUtils.repeat(null, "x", 2), null);
        assertEquals(StringUtils.repeat("", null, 0), "");
        assertEquals(StringUtils.repeat("", "", 2), "");
        assertEquals(StringUtils.repeat("", "x", 3), "xx");
        assertEquals(StringUtils.repeat("?", ", ", 3), "?, ?, ?");

        assertEquals(StringUtils.repeat('e', 0), "");
        assertEquals(StringUtils.repeat('e', 3), "eee");
        assertEquals(StringUtils.repeat('e', -2), "");
    }

    public void testPadding() {

        //padLeft
        assertEquals(StringUtils.padLeft(null, 1), null);
        assertEquals(StringUtils.padLeft("", 3), "   ");
        assertEquals(StringUtils.padLeft("bat", 3), "bat");
        assertEquals(StringUtils.padLeft("bat", 5), "  bat");
        assertEquals(StringUtils.padLeft("bat", 1), "bat");
        assertEquals(StringUtils.padLeft("bat", -1), "bat");

        assertEquals(StringUtils.padLeft(null, 3, 'z'), null);
        assertEquals(StringUtils.padLeft("", 3, 'z'), "zzz");
        assertEquals(StringUtils.padLeft("bat", 3, 'z'), "bat");
        assertEquals(StringUtils.padLeft("bat", 5, 'z'), "zzbat");
        assertEquals(StringUtils.padLeft("bat", 1, 'z'), "bat");
        assertEquals(StringUtils.padLeft("bat", -1, 'z'), "bat");

        assertEquals(StringUtils.padLeft(null, 3, "z"), null);
        assertEquals(StringUtils.padLeft("", 3, "z"), "zzz");
        assertEquals(StringUtils.padLeft("bat", 3, "yz"), "bat");
        assertEquals(StringUtils.padLeft("bat", 5, "yz"), "yzbat");
        assertEquals(StringUtils.padLeft("bat", 8, "yz"), "yzyzybat");
        assertEquals(StringUtils.padLeft("bat", 1, "yz"), "bat");
        assertEquals(StringUtils.padLeft("bat", -1, "yz"), "bat");
        assertEquals(StringUtils.padLeft("bat", 5, null), "  bat");
        assertEquals(StringUtils.padLeft("bat", 5, ""), "  bat");

        //padRight
        assertEquals(StringUtils.padRight(null, 3), null);
        assertEquals(StringUtils.padRight("", 3), "   ");
        assertEquals(StringUtils.padRight("bat", 3), "bat");
        assertEquals(StringUtils.padRight("bat", 5), "bat  ");
        assertEquals(StringUtils.padRight("bat", 1), "bat");
        assertEquals(StringUtils.padRight("bat", -1), "bat");

        assertEquals(StringUtils.padRight(null, 3, 'z'), null);
        assertEquals(StringUtils.padRight("", 3, 'z'), "zzz");
        assertEquals(StringUtils.padRight("bat", 3, 'z'), "bat");
        assertEquals(StringUtils.padRight("bat", 5, 'z'), "batzz");
        assertEquals(StringUtils.padRight("bat", 1, 'z'), "bat");
        assertEquals(StringUtils.padRight("bat", -1, 'z'), "bat");

        assertEquals(StringUtils.padRight(null, 3, "z"), null);
        assertEquals(StringUtils.padRight("", 3, "z"), "zzz");
        assertEquals(StringUtils.padRight("bat", 3, "yz"), "bat");
        assertEquals(StringUtils.padRight("bat", 5, "yz"), "batyz");
        assertEquals(StringUtils.padRight("bat", 8, "yz"), "batyzyzy");
        assertEquals(StringUtils.padRight("bat", 1, "yz"), "bat");
        assertEquals(StringUtils.padRight("bat", -1, "yz"), "bat");
        assertEquals(StringUtils.padRight("bat", 5, null), "bat  ");
        assertEquals(StringUtils.padRight("bat", 5, ""), "bat  ");
    }

    public void testRemove() {
        //removeStart
        assertEquals(StringUtils.removeStart(null, "www"), null);
        assertEquals(StringUtils.removeStart("", "www"), "");
        assertEquals(StringUtils.removeStart("www", null), "www");
        assertEquals(StringUtils.removeStart("www.domain.com", "www."), "domain.com");
        assertEquals(StringUtils.removeStart("domain.com", "www."), "domain.com");
        assertEquals(StringUtils.removeStart("www.domain.com", "domain"), "www.domain.com");
        assertEquals(StringUtils.removeStart("abc", ""), "abc");

        //removeStartIgnoreCase
        assertEquals(StringUtils.removeStartIgnoreCase(null, "www"), null);
        assertEquals(StringUtils.removeStartIgnoreCase("", "www"), "");
        assertEquals(StringUtils.removeStartIgnoreCase("www", null), "www");
        assertEquals(StringUtils.removeStartIgnoreCase("www.domain.com", "www."), "domain.com");
        assertEquals(StringUtils.removeStartIgnoreCase("www.domain.com", "WWW."), "domain.com");
        assertEquals(StringUtils.removeStartIgnoreCase("domain.com", "www."), "domain.com");
        assertEquals(StringUtils.removeStartIgnoreCase("www.domain.com", "domain"), "www.domain.com");
        assertEquals(StringUtils.removeStartIgnoreCase("abc", ""), "abc");

        //removeEnd
        assertEquals(StringUtils.removeEnd(null, "www"), null);
        assertEquals(StringUtils.removeEnd("", "www"), "");
        assertEquals(StringUtils.removeEnd("www", null), "www");
        assertEquals(StringUtils.removeEnd("www.domain.com", ".com."), "www.domain.com");
        assertEquals(StringUtils.removeEnd("www.domain.com", ".com"), "www.domain");
        assertEquals(StringUtils.removeEnd("www.domain.com", "domain"), "www.domain.com");
        assertEquals(StringUtils.removeEnd("abc", ""), "abc");

        //removeEndIgnoreCase
        assertEquals(StringUtils.removeEndIgnoreCase(null, "www"), null);
        assertEquals(StringUtils.removeEndIgnoreCase("", "www"), "");
        assertEquals(StringUtils.removeEndIgnoreCase("www", null), "www");
        assertEquals(StringUtils.removeEndIgnoreCase("www.domain.com", ".com."), "www.domain.com");
        assertEquals(StringUtils.removeEndIgnoreCase("www.domain.com", ".com"), "www.domain");
        assertEquals(StringUtils.removeEndIgnoreCase("www.domain.com", "domain"), "www.domain.com");
        assertEquals(StringUtils.removeEndIgnoreCase("abc", ""), "abc");
        assertEquals(StringUtils.removeEndIgnoreCase("www.domain.com", ".COM"), "www.domain");
        assertEquals(StringUtils.removeEndIgnoreCase("www.domain.COM", ".com"), "www.domain");
    }
}
