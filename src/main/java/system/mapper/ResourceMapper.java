package system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import system.dto.HomeResourceDto;
import system.dto.RootResourceTreeDto;
import system.model.Resource;
import system.model.ResourceExample;

public interface ResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_resource
     *
     * @mbggenerated
     */
    int countByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_resource
     *
     * @mbggenerated
     */
    int deleteByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_resource
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_resource
     *
     * @mbggenerated
     */
    int insert(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_resource
     *
     * @mbggenerated
     */
    int insertSelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_resource
     *
     * @mbggenerated
     */
    List<Resource> selectByExample(ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_resource
     *
     * @mbggenerated
     */
    Resource selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_resource
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_resource
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Resource record, @Param("example") ResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_resource
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_resource
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Resource record);

    /**
     * 描述：查询主资源列表
     *
     * @return 资源dto
     */
    List<HomeResourceDto> selectHomeResources();

    /**
     * 描述：查询列表
     * @return
     */
    List<RootResourceTreeDto> selectRootResources();
}