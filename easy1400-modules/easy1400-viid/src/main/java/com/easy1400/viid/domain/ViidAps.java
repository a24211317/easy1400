package com.easy1400.viid.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 采集系统表
 * @TableName viid_aps
 */
@TableName(value ="viid_aps")
public class ViidAps implements Serializable {
    /**
     * 设备 ID
     */
    @TableId
    private String apsid;

    /**
     * 名称
     */
    private String name;

    /**
     * IP 地址
     */
    private String ipaddr;

    /**
     * IPv6地址
     */
    private String ipv6addr;

    /**
     * 端口号
     */
    private Integer port;

    /**
     * 是否在线
     */
    private String isonline;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 设备 ID
     */
    public String getApsid() {
        return apsid;
    }

    /**
     * 设备 ID
     */
    public void setApsid(String apsid) {
        this.apsid = apsid;
    }

    /**
     * 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * IP 地址
     */
    public String getIpaddr() {
        return ipaddr;
    }

    /**
     * IP 地址
     */
    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    /**
     * IPv6地址
     */
    public String getIpv6addr() {
        return ipv6addr;
    }

    /**
     * IPv6地址
     */
    public void setIpv6addr(String ipv6addr) {
        this.ipv6addr = ipv6addr;
    }

    /**
     * 端口号
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 端口号
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 是否在线
     */
    public String getIsonline() {
        return isonline;
    }

    /**
     * 是否在线
     */
    public void setIsonline(String isonline) {
        this.isonline = isonline;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ViidAps other = (ViidAps) that;
        return (this.getApsid() == null ? other.getApsid() == null : this.getApsid().equals(other.getApsid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getIpaddr() == null ? other.getIpaddr() == null : this.getIpaddr().equals(other.getIpaddr()))
            && (this.getIpv6addr() == null ? other.getIpv6addr() == null : this.getIpv6addr().equals(other.getIpv6addr()))
            && (this.getPort() == null ? other.getPort() == null : this.getPort().equals(other.getPort()))
            && (this.getIsonline() == null ? other.getIsonline() == null : this.getIsonline().equals(other.getIsonline()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getApsid() == null) ? 0 : getApsid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getIpaddr() == null) ? 0 : getIpaddr().hashCode());
        result = prime * result + ((getIpv6addr() == null) ? 0 : getIpv6addr().hashCode());
        result = prime * result + ((getPort() == null) ? 0 : getPort().hashCode());
        result = prime * result + ((getIsonline() == null) ? 0 : getIsonline().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", apsid=").append(apsid);
        sb.append(", name=").append(name);
        sb.append(", ipaddr=").append(ipaddr);
        sb.append(", ipv6addr=").append(ipv6addr);
        sb.append(", port=").append(port);
        sb.append(", isonline=").append(isonline);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}