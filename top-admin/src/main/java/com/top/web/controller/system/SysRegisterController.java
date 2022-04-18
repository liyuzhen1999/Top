package com.top.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.top.common.core.controller.BaseController;
import com.top.common.core.domain.AjaxResult;
import com.top.common.core.domain.model.RegisterBody;
import com.top.common.utils.StringUtils;
import com.top.framework.web.service.SysRegisterService;
import com.top.system.service.ISysConfigService;

/**
 * 注册验证
 * 
 * @author top
 */
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
