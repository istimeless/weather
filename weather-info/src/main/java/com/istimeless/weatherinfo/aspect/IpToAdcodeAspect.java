package com.istimeless.weatherinfo.aspect;

import com.istimeless.weathercommon.utils.IpUtil;
import com.istimeless.weathercommon.vo.Result;
import com.istimeless.weathercommon.vo.WeatherIpVO;
import com.istimeless.weatherinfo.advice.WeatherInfoEnum;
import com.istimeless.weatherinfo.advice.WeatherInfoException;
import com.istimeless.weatherinfo.client.WeatherIpClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author lijiayin
 */
@Slf4j
@Aspect
@Component
public class IpToAdcodeAspect {
    
    private final WeatherIpClient weatherIpClient;

    public IpToAdcodeAspect(WeatherIpClient weatherIpClient) {
        this.weatherIpClient = weatherIpClient;
    }

    @SuppressWarnings("all")
    @Around(value = "@annotation(IpToAdcode)")
    public Object handler(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs();
        String adcode = (String) args[0];
        if(StringUtils.isBlank(adcode)){
            HttpServletRequest httpServletRequest = ((ServletRequestAttributes) 
                    RequestContextHolder.getRequestAttributes()).getRequest();
            Result<WeatherIpVO> ipInfo = weatherIpClient.ipInfo(IpUtil.getIpAddr(httpServletRequest));
            if(!Objects.isNull(ipInfo)){
                WeatherIpVO data = ipInfo.getData();
                args[0] = data.getAdcode();
            }else {
                throw new WeatherInfoException(WeatherInfoEnum.SERVICE_FAIL.getCode(), "调用ip查询服务异常");
            }
        }
        return pjp.proceed(args);
    }
}
