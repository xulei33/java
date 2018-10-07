package org.xulei.i18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * 国际化控制器
 * 
 * @author Goofy
 */
@Controller
@RequestMapping("/")
public class I18nController {

	@Autowired
	CookieLocaleResolver resolver;

	/**
	 * 语言切换
	 */
	@RequestMapping("/lang/{language}")
	public ModelAndView language(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("language") String language) {

		language = language.toLowerCase();

		if (language == null || language.equals("")) {
			return new ModelAndView("redirect:/welcome");
		} else {
			if (language.equals("zh_cn")) {
				resolver.setLocale(request, response, Locale.CHINA);
			} else if (language.equals("en")) {
				resolver.setLocale(request, response, Locale.ENGLISH);
			} else {
				resolver.setLocale(request, response, Locale.CHINA);
			}
		}
		return new ModelAndView("redirect:/welcome");
	}

	/**
	 * 演示一些消息
	 */
	@RequestMapping("something")
	public ModelAndView something() {
		return new ModelAndView("something");
	}

	/**
	 * 换页面
	 */
	@RequestMapping("welcome")
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(request.getLocale().getISO3Country() +" " +request.getLocale().getDisplayLanguage() +"	"+ request.getLocale().getLanguage());
		
		return new ModelAndView("welcome");
	}
}
