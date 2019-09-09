package com.istimeless.weathercommon.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author lijiayin
 */
@Slf4j
public class IpUtil {
    
    private static final String UNKNOWN = "unknown";
    
    private static final String LOCALHOST = "127.0.0.1";
    
    private static final String SPLIT = ",";

    public static String getIpAddr(HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = request.getHeader("x-forwarded-for");
            if (StringUtils.isBlank(ipAddress) || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isBlank(ipAddress) || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isBlank(ipAddress) || UNKNOWN.equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if (ipAddress.equals(LOCALHOST)) {
                    // 根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        log.error("获取ip地址异常：{}", e.getMessage(), e);
                    }
                    if(inet != null){
                        ipAddress = inet.getHostAddress();
                    }
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            if (StringUtils.isBlank(ipAddress) && ipAddress.indexOf(SPLIT) > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(SPLIT));
            }
        } catch (Exception e) {
            log.error("获取ip地址异常：{}", e.getMessage(), e);
        }
        return ipAddress;
    }
}
