package com.example.test.eb.demo.mapper;

/**
 * @author lizongren
 * @create 2020.05.07 10:14
 */


import com.example.test.eb.demo.bean.Dag;
import com.example.test.eb.demo.bean.DagState;
import com.example.test.eb.demo.bean.QueryEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Mapper
@Component
public interface DagDao {

    @SelectProvider(type = DagSqlBuilder.class, method = "buildGetDagInfoList")
    @Results(id = "getDagList", value = {
            @Result(column = "dag_id", property = "dagId", id = true),
            @Result(column = "dag_id", property = "dagState",
                    many = @Many(select = "DagDao.getDagState", fetchType = FetchType.EAGER))
    })
    List<Dag> getDagList(@Param("queryEntities") List<QueryEntity> queryEntities,
                         @Param("ownerCode") String ownerCode,
                         @Param("creator") String creator,
                         @Param("currentPage") int currentPage,
                         @Param("numberPerPage") int numberPerPage,
                         @Param("indexOrderKey") String indexOrderKey,
                         @Param("indexOrder") String indexOrder);



    @SelectProvider(type = DagSqlBuilder.class, method = "buildGetDagInfoCount")
    int getDagCount(@Param("queryEntities") List<QueryEntity> queryEntities,
                    @Param("ownerCode") String ownerCode,
                    @Param("creator") String creator);

    @SelectProvider(type = DagSqlBuilder.class, method = "buildGetDagRunList")
    List<Map<String,Object>> getRunList(@Param("name") String name
                            );

    @SelectProvider(type = DagSqlBuilder.class, method = "buildGetDagRunCount")
    int getRunCount(@Param("queryEntities") List<QueryEntity> queryEntities,
                    @Param("ownerCode") String ownerCode,
                    @Param("creator") String creator);

    @Select("select dag_id,state,count(state) count from dag_run where dag_id = #{dagId} group by state")
    List<DagState> getDagState(@Param("dagId") String dagId);

    @Select("select count(1) from dag where dag_id = #{dagId}")
    int exist(@Param("dagId") String dagId);

    @Insert("insert into idox_owner_dag (owner_code,creator,dag_id) values (#{ownerCode},#{creator},#{dagId})")
    void addOwnerDag(@Param("ownerCode") String ownerCode, @Param("creator") String creator, @Param("dagId") String dagId);

    @Select("select count(1) from idox_owner_dag where dag_id = #{dagId}")
    int ownerDagExist(@Param("dagId") String dagId);

    @Update("update idox_owner_dag set owner_code = #{ownerCode},creator = #{creator} where dag_id = #{dagId}")
    void updateOwnerDag(@Param("ownerCode") String ownerCode, @Param("creator") String creator, @Param("dagId") String dagId);
    @Update("update ${ name } set id = #{ id } ")
    void updateData(@Param("name")String name,@Param("id")String id);

    @Insert("insert into busi_analysis_type  values (#{id},#{index})")
    void addData(@Param("id") String id, @Param("index") String index);

    @Update("update busi_analysis_type set indexs = #{ indexs } where indexs_id = #{indexs_id}")
    void setData(@Param("indexs_id")String indexs_id,@Param("indexs")String indexs);

    @Select("select * from busi_analysis_type where indexs_id = #{id}")
    List<Map<String,Object>> getData(@Param("id") String id);
    @Select("select * from ${ name }")
    List<Map<String,Object>> queryData(@Param("name")String name);

    @Delete("delete from idox_owner_dag where dag_id like CONCAT(#{dagId},'.%') or dag_id = #{dagId}")
    void deleteOwnerDag(@Param("dagId") String dagId);
}
