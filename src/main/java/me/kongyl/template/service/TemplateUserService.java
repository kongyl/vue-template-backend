package me.kongyl.template.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.kongyl.template.base.BizException;
import me.kongyl.template.base.ResMessage;
import me.kongyl.template.mapper.TemplateUserMapper;
import me.kongyl.template.model.TemplateUser;
import me.kongyl.template.model.TemplateUserExample;
import me.kongyl.template.util.CodeUtils;

@Service
public class TemplateUserService {

    @Autowired
    private TemplateUserMapper templateUserMapper;
    
    public TemplateUser login(String username, String password) throws BizException {
        TemplateUserExample usernameExample = new TemplateUserExample();
        usernameExample.createCriteria().andUsernameEqualTo(username).andIsDelEqualTo(false);
        List<TemplateUser> userList = templateUserMapper.selectByExample(usernameExample);
        if (userList.size() == 0) {
            throw new BizException(ResMessage.NO_RESULT);
        }
        if (userList.size() > 1) {
            throw new BizException(ResMessage.ERROR_DB);
        }
        TemplateUser user = userList.get(0);
        if (user.getIsLock()) {
            throw new BizException(ResMessage.ERROR_OTHER.getCode(), "用户已锁定");
        }
        if (!CodeUtils.bcryptCheck(password, user.getPassword())) {
            throw new BizException(ResMessage.ERROR_OTHER.getCode(), "用户名或密码错误");
        }
        
        return user;
    }
    
    public int saveToken(String id, String token) {
        TemplateUser user = new TemplateUser();
        user.setId(id);
        user.setToken(token);
        user.setTokenExpired(LocalDateTime.now().plusDays(30));
        user.setUpdateUser(id);
        user.setUpdateTime(LocalDateTime.now());
        return templateUserMapper.updateByPrimaryKeySelective(user);
    }
    
}
