/*
 * Copyright (c) zjc@scut 2016~
 * Free of All
 * Help Yourselves!
 * Any bugs were found please contact me at 739805340scut@gmail.com
 */

package cn.util.http.origin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjinci
 * @version 2016/9/14 11:33
 * @function Http请求返回状态码以及状态描述
 */
public class HttpStatus {

    private static final Map<Integer, String> code_text = new HashMap<>();

    static {
        code_text.put(100, "Continue");
        code_text.put(101, "Switching Protocols");
        code_text.put(102, "Processing");
        code_text.put(200, "OK");
        code_text.put(201, "Created");
        code_text.put(202, "Accepted");
        code_text.put(203, "Non-Authoritative Information"); // (since HTTP/1.1)
        code_text.put(204, "No Content");
        code_text.put(205, "Reset Content");
        code_text.put(206, "Partial Content");
        code_text.put(207, "Multi-Status");
        code_text.put(208, "Already Reported");
        code_text.put(226, "IM Used");

        code_text.put(301, "Moved Permanently");
        code_text.put(302, "Found");
        code_text.put(303, "See Other"); // (since HTTP/1.1)
        code_text.put(304, "Not Modified ");
        code_text.put(305, "Use Proxy"); // (since HTTP/1.1)
        code_text.put(306, "Switch Proxy");
        code_text.put(307, "Temporary Redirect"); // (since HTTP/1.1)
        code_text.put(308, "Permanent Redirect");

        code_text.put(400, "Bad Request");
        code_text.put(401, "Unauthorized");
        code_text.put(402, "Payment Required");
        code_text.put(403, "Forbidden");
        code_text.put(404, "Not Found");
        code_text.put(405, "Method Not Allowed");
        code_text.put(406, "Not Acceptable");
        code_text.put(407, "Proxy Authentication Required ");
        code_text.put(408, "Request Timeout");
        code_text.put(409, "Conflict");
        code_text.put(410, "Gone");
        code_text.put(411, "Length Required");
        code_text.put(412, "Precondition Failed");
        code_text.put(413, "Payload Too Large");
        code_text.put(414, "URI Too Long");
        code_text.put(415, "Unsupported Media Type");
        code_text.put(416, "Range Not Satisfiable");
        code_text.put(417, "Expectation Failed");

        code_text.put(500, "Internal Server Error");
        code_text.put(501, "Not Implemented");
        code_text.put(502, "Bad Gateway");
        code_text.put(503, "Service Unavailable");
        code_text.put(504, "Gateway Timeout");
        code_text.put(505, "HTTP Version Not Supported");
        code_text.put(506, "Variant Also Negotiates");
        code_text.put(507, "Insufficient Storage ");
        code_text.put(508, "Loop Detected");
        code_text.put(509, "Bandwidth Limit Exceeded ");
        code_text.put(510, "Not Extended ");
        code_text.put(511, "Network Authentication Required");
        code_text.put(520, "Unknown Error");
        code_text.put(522, "Origin Connection Time-out");
        code_text.put(598, "Network read timeout error ");
        code_text.put(599, "Network connect timeout error");
    }

    public static String getStatusText(int statusCode) {
        return code_text.get(statusCode);
    }

    public static String getStatusText(int statusCode, String defaultValue) {
        if (code_text.get(statusCode) == null)
            return defaultValue;
        return code_text.get(statusCode);
    }
}
