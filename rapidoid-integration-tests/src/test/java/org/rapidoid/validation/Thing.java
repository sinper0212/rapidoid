/*-
 * #%L
 * rapidoid-integration-tests
 * %%
 * Copyright (C) 2014 - 2018 Nikolche Mihajlovski and contributors
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

package org.rapidoid.validation;

import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Authors("Nikolche Mihajlovski")
@Since("5.1.0")
public class Thing {

	@NotNull
	private String name;

	@Size(min = 3, max = 5)
	private String desc;

	public Thing(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

}
