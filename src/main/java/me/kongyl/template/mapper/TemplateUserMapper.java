package me.kongyl.template.mapper;

import java.util.List;
import me.kongyl.template.model.TemplateUser;
import me.kongyl.template.model.TemplateUserExample;
import org.apache.ibatis.annotations.Param;

public interface TemplateUserMapper {
    long countByExample(TemplateUserExample example);

    int deleteByExample(TemplateUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(TemplateUser record);

    int insertSelective(TemplateUser record);

    List<TemplateUser> selectByExample(TemplateUserExample example);

    TemplateUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TemplateUser record, @Param("example") TemplateUserExample example);

    int updateByExample(@Param("record") TemplateUser record, @Param("example") TemplateUserExample example);

    int updateByPrimaryKeySelective(TemplateUser record);

    int updateByPrimaryKey(TemplateUser record);
}