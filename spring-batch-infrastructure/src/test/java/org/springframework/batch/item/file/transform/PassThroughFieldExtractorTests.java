/*
 * Copyright 2006-2007 the original author or authors.
 *
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
 */
package org.springframework.batch.item.file.transform;

import static junit.framework.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author Dan Garrette
 * @since 2.0
 */
public class PassThroughFieldExtractorTests {

	@Test
	public void testExtract_string() {
		PassThroughFieldExtractor<String> extractor = new PassThroughFieldExtractor<String>();
		Object[] result = extractor.extract("abc");
		assertTrue(Arrays.equals(new Object[] { "abc" }, result));
	}

	@Test
	public void testExtract_array() {
		PassThroughFieldExtractor<String[]> extractor = new PassThroughFieldExtractor<String[]>();
		Object[] result = extractor.extract(new String[] { "a", "b", null, "d" });
		assertTrue(Arrays.equals(new Object[] { "a", "b", "", "d" }, result));
	}

	@Test
	public void testExtract_collection() {
		PassThroughFieldExtractor<List<String>> extractor = new PassThroughFieldExtractor<List<String>>();
		Object[] result = extractor.extract(Arrays.asList("a", "b", null, "d"));
		assertTrue(Arrays.equals(new Object[] { "a", "b", "", "d" }, result));
	}
}