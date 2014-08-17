package com.edw.mybatisselectmap;

import com.edw.mybatisselectmap.config.MyBatisSqlSessionFactory;
import com.edw.mybatisselectmap.mapper.SelectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

/**
 *
 * @author edwin < edwinkun at gmail dot com >
 */
public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            
            HashMap<Object, Object> hashMapParameter = new HashMap<Object, Object>();
            hashMapParameter.put("orderBy", "id");
            hashMapParameter.put("address", "%ciledug%");
            
            sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession(true);
            SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
            
            List<HashMap<Object, Object>> hashMapResults = mapper.select(hashMapParameter);
            
            for (HashMap<Object, Object> hashMapResult : hashMapResults) {
                logger.debug(hashMapResult);
            }
        } catch (Exception e) {
            logger.error(e, e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
