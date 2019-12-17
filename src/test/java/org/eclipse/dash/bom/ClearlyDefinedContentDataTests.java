package org.eclipse.dash.bom;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.junit.jupiter.api.Test;

class ClearlyDefinedContentDataTests {
	@Test
	void test() throws Exception {
		InputStream input = this.getClass().getResourceAsStream("/write-1.0.3.json");
		JsonReader reader = Json.createReader(new InputStreamReader(input, "UTF-8"));
    	JsonObject data = (JsonObject)reader.read();
		ClearlyDefinedContentData info = new ClearlyDefinedContentData(data);
		assertEquals("npm/npmjs/-/write/1.0.3", info.getId().toString());
		assertEquals("MIT", info.getLicense());
		assertEquals(97, info.getScore());
	}
}
