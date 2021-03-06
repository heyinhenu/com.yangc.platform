package com.yangc.system.resource;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yangc.bean.ResultBean;
import com.yangc.exception.WebApplicationException;

@Controller
@RequestMapping("/ping")
public class PingResource {

	private static final Logger logger = Logger.getLogger(PingResource.class);

	/**
	 * @功能: 检查是否通畅
	 * @作者: yangc
	 * @创建日期: 2013年12月23日 下午2:13:04
	 * @return
	 */
	@RequestMapping(value = "system", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean system() {
		logger.info("system");
		try {
			return new ResultBean(true, "success");
		} catch (Exception e) {
			e.printStackTrace();
			return WebApplicationException.build();
		}
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	@ResponseBody
	public ResultBean test(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		logger.info("test");
		try {
			return new ResultBean(true, DateFormatUtils.format(date, "yyyy-MM-dd"));
		} catch (Exception e) {
			e.printStackTrace();
			return WebApplicationException.build();
		}
	}

}
