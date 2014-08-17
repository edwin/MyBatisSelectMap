package com.edw.mybatisselectmap.mapper;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author edwin < edwinkun at gmail dot com >
 */
public interface SelectMapper {
    List<HashMap<Object, Object>> select(HashMap<Object, Object> hashMap);
}