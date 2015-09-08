package com.ew.roc.net;

import com.loopj.android.http.RequestParams;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * RequestParams params = new RequestParams();
 * params.put("username", "james");
 * params.put("password", "123456");
 * params.put("profile_picture", new File("pic.jpg")); // Upload a File
 * params.put("profile_picture2", someInputStream); // Upload an InputStream
 * params.put("profile_picture3", new ByteArrayInputStream(someBytes)); // Upload some bytes
 * <p/>
 * Map&lt;String, String&gt; map = new HashMap&lt;String, String&gt;();
 * map.put("first_name", "James");
 * map.put("last_name", "Smith");
 * params.put("user", map); // url params: "user[first_name]=James&amp;user[last_name]=Smith"
 */
public class EwRequestParams extends RequestParams {


    /**
     * Constructs a new empty {@code RequestParams} instance.
     */
    public EwRequestParams(Object object) {
        super(ConvertObjToMap(object));
    }

    public EwRequestParams() {
        super();
    }

    public EwRequestParams(final String key, final String value) {
        super(key, value);
    }

    public EwRequestParams(Map<String, String> source) {
        super(source);
    }


    private static Map<String, String> ConvertObjToMap(Object obj) {
        Map<String, String> reMap = new HashMap<String, String>();
        if (obj == null)
            return null;
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (int i = 0; i < fields.length; i++) {
                try {
                    Field f = obj.getClass().getDeclaredField(fields[i].getName());
                    f.setAccessible(true);
                    Object o = f.get(obj);
                    reMap.put(fields[i].getName(), o + "");
                } catch (NoSuchFieldException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reMap;
    }

}

