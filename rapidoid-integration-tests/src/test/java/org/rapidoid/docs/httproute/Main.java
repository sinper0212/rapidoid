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

package org.rapidoid.docs.httproute;

import org.rapidoid.http.Req;
import org.rapidoid.setup.On;


public class Main {

	public static void main(String[] args) {
		/* Request handlers should match both the verb and the path: */

		On.get("/").json("Hi!");

		On.get("/x").html("Getting X");

		On.post("/x").json((Req req) -> "Posting X");

		On.delete("/x").html((Req req) -> "<b>Deleting X</b>");
	}

}
