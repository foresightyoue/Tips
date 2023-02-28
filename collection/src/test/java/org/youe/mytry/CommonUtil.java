package org.youe.mytry;

import java.util.Objects;

import net.sf.json.JSONObject;

public class CommonUtil {

    public static boolean isEmpty(String str) {
		if (str == null || "".equals(str) || "null".equals(str)) {
			return true;
		}
		return false;
	}


    /**
	 *  json对象获取string值
	 * @param obj
	 * @param key
	 * @return
	 */
	public static String getJsonString(Object obj, String key) {
		return getJsonObject(obj, key) + "";
	}

	/**
	 *  转JsonObject并取值
	 * @param jsonObj
	 * @param key
	 * @return
	 */
	public static Object getJsonObject(Object jsonObj, String key) {
		try {
			if (!Objects.equals(null,jsonObj)) {
				JSONObject jsonObject = JSONObject.fromObject(jsonObj);
				return jsonObject.get(key);
			}
		} catch (Exception e) {
		}
		return null;
	}
}
