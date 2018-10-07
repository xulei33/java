package cms.web.action.setting;

import java.util.Date;

import javax.annotation.Resource;

import cms.bean.setting.EditorTag;
import cms.bean.setting.SystemSetting;
import cms.service.setting.SettingService;
import cms.service.statistic.PageViewService;
import cms.service.user.UserService;
import cms.utils.JsonUtils;
import cms.web.action.lucene.TopicIndexManage;
import cms.web.action.user.UserLoginLogManage;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 设置管理
 *
 */
@Component("settingManage")
public class SettingManage {

	@Resource TopicIndexManage topicIndexManage;
	@Resource UserLoginLogManage userLoginLogManage;
	@Resource SettingService settingService;
	
	@Resource UserService userService;
	@Resource PageViewService pageViewService;
	
	/**
	 * 用户每分钟提交次数
	 * @param module 模块
	 * @param userName 用户名称
	 * @param count 次数
	 * @return
	 */
	@Cacheable(value="settingManage_cache_submitQuantity",key="#module + '_' + #userName")
	public Integer submitQuantity_add(String module,String userName,Integer count){
		return count;
	}
	/**
	 * 删除用户每分钟提交次数
	 * @param module 模块
	 * @param userName 用户名称
	 * @return
	 */
	@CacheEvict(value="settingManage_cache_submitQuantity",key="#module + '_' + #userName")
	public void submitQuantity_delete(String module,String userName){
	}
	
	
	/**
	 * 添加全部话题索引(异步)
	 */
	@Async
	public void addAllTopicIndex(){
		topicIndexManage.addAllTopicIndex();
	}
	/**
	 * 删除浏览量数据 (异步)
	 * @param endTime 结束时间
	 */
	@Async
	public void executeDeletePageViewData(Date endTime){
		pageViewService.deletePageView(endTime);
	}
	
	/**
	 * 删除用户登录日志数据 (异步)
	 * @param endTime 结束时间
	 */
	@Async
	public void executeDeleteUserLoginLogData(Date endTime){
		userService.deleteUserLoginLog(endTime);
	}
	
	
	/**
	 * 读取自定义评论编辑器允许使用标签
	 * @return
	 */
	public EditorTag readEditorTag(){
		SystemSetting systemSetting = settingService.findSystemSetting_cache();
		if(systemSetting.getEditorTag() != null && !"".equals(systemSetting.getEditorTag().trim())){
			return JsonUtils.toObject(systemSetting.getEditorTag(), EditorTag.class);
		}
		return null;
	}
	


	
	/**  
     * 总内存  
     *   
     * @return  
     */  
    public long totalMemory() {   
        long l = Runtime.getRuntime().totalMemory();   
        return (l / 1024 / 1024);   
    }   
  
    /**  
     * 分配最大内存  
     *   
     * @return  
     */  
    public long maxMemory() {   
        long l = Runtime.getRuntime().maxMemory();   
        return (l / 1024 / 1024);   
    }   
  
    /**  
     * 空闲内存 
     * @return  
     */  
    public long freeMemory() {   
        long l = Runtime.getRuntime().freeMemory();   
        return (l / 1024 / 1024);   
    }   
	
}
