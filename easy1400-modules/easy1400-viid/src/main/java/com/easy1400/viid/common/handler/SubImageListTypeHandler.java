package com.easy1400.viid.common.handler;

import cn.hutool.json.JSONUtil;
import com.easy1400.common.core.utils.StringUtils;
import com.easy1400.viid.domain.dto.SubImageListDTO;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName SubImageListTypeHandler
 * @Author CH
 * @Date 2023/9/5 15:35
 * @Version 1.0
 */
public class SubImageListTypeHandler extends BaseTypeHandler<SubImageListDTO> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SubImageListDTO parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, JSONUtil.toJsonStr(parameter));
    }

    @Override
    public SubImageListDTO getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        if (StringUtils.isNotEmpty(value)){
            return JSONUtil.toBean(value, SubImageListDTO.class);
        }
        return null;
    }

    @Override
    public SubImageListDTO getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if (StringUtils.isNotEmpty(value)){
            return JSONUtil.toBean(value, SubImageListDTO.class);
        }
        return null;
    }

    @Override
    public SubImageListDTO getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if (StringUtils.isNotEmpty(value)){
            return JSONUtil.toBean(value, SubImageListDTO.class);
        }
        return null;
    }
}
