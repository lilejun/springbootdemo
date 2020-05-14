package com.lilejun.mybatisplustest.mptest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lilejun
 * @since 2020-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MpTeacher extends Model<MpTeacher> {

    private static final long serialVersionUID = 1L;

    private String teacherNo;

    private String name;

    private String subject;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
