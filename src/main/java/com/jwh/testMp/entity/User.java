package com.jwh.testMp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author lazzaro
 * @since 2019-11-25
 */

public class User extends Model<User> {

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    @TableField(fill = FieldFill.UPDATE)
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 直属上级id
     */
    private Long manager_id;

    /**
     * 创建时间
     * TableField(fill = FieldFill.UPDATE)   插入时自动填充
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime create_time;

    /**
     * 修改时间
     *  TableField(fill = FieldFill.UPDATE) 更新时自动填充
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime update_time;

    /**
     * 版本
     */
    @Version
    private Integer version;

    /**
     * 逻辑删除标识(0.未删除,1.已删除)
     */
    @TableLogic()
    @TableField(select = false)
    private Integer deleted;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getManager_id() {
        return manager_id;
    }

    public void setManager_id(Long manager_id) {
        this.manager_id = manager_id;
    }

    public LocalDateTime getCreate_time() {
        return create_time;
    }

    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    public LocalDateTime getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(LocalDateTime update_time) {
        this.update_time = update_time;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", name=" + name +
        ", age=" + age +
        ", email=" + email +
        ", manager_id=" + manager_id +
        ", create_time=" + create_time +
        ", update_time=" + update_time +
        ", version=" + version +
        ", deleted=" + deleted +
        "}";
    }
}
