package system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import system.model.Recommend;
import system.model.RecommendExample;

public interface RecommendMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_recommend
     *
     * @mbggenerated
     */
    int countByExample(RecommendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_recommend
     *
     * @mbggenerated
     */
    int deleteByExample(RecommendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_recommend
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_recommend
     *
     * @mbggenerated
     */
    int insert(Recommend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_recommend
     *
     * @mbggenerated
     */
    int insertSelective(Recommend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_recommend
     *
     * @mbggenerated
     */
    List<Recommend> selectByExample(RecommendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_recommend
     *
     * @mbggenerated
     */
    Recommend selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_recommend
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Recommend record, @Param("example") RecommendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_recommend
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Recommend record, @Param("example") RecommendExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_recommend
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Recommend record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table blog_recommend
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Recommend record);
}