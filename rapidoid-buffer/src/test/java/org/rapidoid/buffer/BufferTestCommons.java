package org.rapidoid.buffer;

/*
 * #%L
 * rapidoid-buffer
 * %%
 * Copyright (C) 2014 - 2015 Nikolche Mihajlovski
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.nio.ByteBuffer;

import org.rapidoid.annotation.Authors;
import org.rapidoid.data.KeyValueRanges;
import org.rapidoid.data.Range;
import org.rapidoid.test.TestCommons;
import org.testng.Assert;

@Authors("Nikolche Mihajlovski")
public class BufferTestCommons extends TestCommons {

	protected void eq(String whole, Range range, String expected) {
		eq(range.get(whole), expected);
	}

	protected void eqs(String whole, KeyValueRanges ranges, String... keysAndValues) {
		eq(keysAndValues.length % 2, 0);
		eq(ranges.count, keysAndValues.length / 2);
		for (int i = 0; i < ranges.count; i++) {
			Range key = ranges.keys[i];
			Range value = ranges.values[i];
			eq(whole, key, keysAndValues[i * 2]);
			eq(whole, value, keysAndValues[i * 2 + 1]);
		}
	}

	protected void eq(Range range, int start, int length) {
		Assert.assertEquals(range.start, start);
		Assert.assertEquals(range.length, length);
	}

	protected void isNone(Range range) {
		Assert.assertEquals(range.start, -1);
		Assert.assertEquals(range.length, 0);
	}

	protected void eq(Buf buf, String expected) {
		eq(buf.size(), expected.getBytes().length);
		eq(buf.data(), expected);

		byte[] bbytes = new byte[buf.size()];
		ByteBuffer bufy = ByteBuffer.wrap(bbytes);
		buf.writeTo(bufy);
		eq(new String(bbytes), expected);

		int size = (int) Math.ceil(expected.length() * 1.0 / buf.unitSize());
		isTrue(buf.unitCount() == size || buf.unitCount() == size + 1);

		byte[] bytes = expected.getBytes();
		synchronized (buf) {
			for (int i = 0; i < bytes.length; i++) {
				eq((char) buf.get(i), (char) bytes[i]);
			}
		}

		for (int len = 2; len < 10; len++) {
			for (int p = 0; p <= buf.size() - len; p++) {
				String sub = buf.get(new Range(p, len));
				eq(sub, expected.substring(p, p + len));
			}
		}
	}

}
